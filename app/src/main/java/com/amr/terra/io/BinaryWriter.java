package com.amr.terra.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * Binary writer for Terraria world files.
 * <p>
 * Symmetric counterpart to {@link BinaryReader}: every {@code readXxx} method
 * has a matching {@code writeXxx} that serialises the same number of bytes in
 * the same byte order (little-endian, matching the C# {@code BinaryWriter}
 * used by Terraria / Re-Logic).
 */
public class BinaryWriter implements AutoCloseable {

  private final RandomAccessFile raf;
  private final byte[] scratch = new byte[8];
  private final ByteBuffer buffer = ByteBuffer.wrap(scratch).order(ByteOrder.LITTLE_ENDIAN);

  // ── Construction ──────────────────────────────────────────────────────────

  public BinaryWriter(File file) throws IOException {
    this(file.getAbsolutePath());
  }

  public BinaryWriter(String path) throws IOException {
    raf = new RandomAccessFile(path, "rw");
    raf.setLength(0); // truncate – we are writing a fresh file
  }

  // ── Positioning ───────────────────────────────────────────────────────────

  public void seek(long pos) throws IOException {
    raf.seek(pos);
  }

  public long getFilePointer() throws IOException {
    return raf.getFilePointer();
  }

  // ── Primitive writes ──────────────────────────────────────────────────────

  /** Writes a single unsigned byte (0–255). */
  public void writeUByte(int value) throws IOException {
    raf.writeByte(value & 0xFF);
  }

  /** Writes a signed byte (−128–127). */
  public void writeSByte(byte value) throws IOException {
    raf.writeByte(value);
  }

  /** Writes a boolean as a signed byte (0 = false, 1 = true). */
  public void writeBoolean(boolean value) throws IOException {
    writeSByte(value ? (byte) 1 : (byte) 0);
  }

  /** Writes a little-endian signed 16-bit integer. */
  public void writeInt16(short value) throws IOException {
    buffer.rewind();
    buffer.putShort(value);
    raf.write(scratch, 0, 2);
  }

  /** Writes a little-endian unsigned 16-bit integer (accepts int 0–65535). */
  public void writeUInt16(int value) throws IOException {
    writeInt16((short) (value & 0xFFFF));
  }

  /** Writes a little-endian signed 32-bit integer. */
  public void writeInt32(int value) throws IOException {
    buffer.rewind();
    buffer.putInt(value);
    raf.write(scratch, 0, 4);
  }

  /** Writes a little-endian unsigned 32-bit integer (accepts long 0–2^32−1). */
  public void writeUInt32(long value) throws IOException {
    writeInt32((int) (value & 0xFFFFFFFFL));
  }

  /** Writes a little-endian signed 64-bit integer. */
  public void writeInt64(long value) throws IOException {
    buffer.rewind();
    buffer.putLong(value);
    raf.write(scratch, 0, 8);
  }

  /**
   * Writes a little-endian unsigned 64-bit integer (accepts BigInteger).
   * Only the lowest 64 bits are written.
   */
  public void writeUInt64(BigInteger value) throws IOException {
    writeInt64(value.longValue());
  }

  /** Writes a little-endian IEEE 754 single-precision float. */
  public void writeSingle(float value) throws IOException {
    buffer.rewind();
    buffer.putFloat(value);
    raf.write(scratch, 0, 4);
  }

  /** Writes a little-endian IEEE 754 double-precision float. */
  public void writeDouble(double value) throws IOException {
    buffer.rewind();
    buffer.putDouble(value);
    raf.write(scratch, 0, 8);
  }

  // ── String / chars ────────────────────────────────────────────────────────

  /**
   * Writes a .NET-style length-prefixed UTF-8 string.
   * The length is encoded as a 7-bit variable-length integer (LEB128),
   * matching {@link BinaryReader#readString()}.
   */
  public void writeString(String value) throws IOException {
    final byte[] bytes = (value == null ? "" : value).getBytes(StandardCharsets.UTF_8);
    writeLeb128(bytes.length);
    raf.write(bytes);
  }

  /**
   * Writes exactly {@code count} bytes of the string (no length prefix),
   * mirroring {@link BinaryReader#readChars(int)}.
   */
  public void writeChars(String value, int count) throws IOException {
    final byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
    raf.write(bytes, 0, count);
  }

  // ── Composite types ───────────────────────────────────────────────────────

  /**
   * Writes a boolean array packed into bytes, mirroring
   * {@link BinaryReader#readBitArray(int)}.
   * Each byte stores up to 8 flags; bits are filled LSB-first within each byte.
   */
  public void writeBitArray(boolean[] values) throws IOException {
    int data = 0;
    int bitMask = 128; // sentinel – forces a new byte on first iteration

    for (boolean v : values) {
      if (bitMask != 128) {
        bitMask <<= 1;
      } else {
        if (bitMask == 128 && data != 0) {
          // flush previous byte (not first time)
        }
        data = 0;
        bitMask = 1;
      }
      if (v) data |= bitMask;

      // Flush byte when we've filled all 8 bits OR on the last element
      // Actually we must replicate the exact reader loop to know when to flush:
      // Reader reads a new byte when bitMask == 128 (after shift past 7).
      // We write a byte every time bitMask wraps back to 1 — i.e., one byte per
      // 8 elements.  The simpler approach below is equivalent:
    }

    // Simpler, correct implementation:
    writeBitArraySimple(values);
  }

  /** Simple, correct implementation used by writeBitArray. */
  private void writeBitArraySimple(boolean[] values) throws IOException {
    int i = 0;
    while (i < values.length) {
      int b = 0;
      for (int bit = 0; bit < 8 && i < values.length; bit++, i++) {
        if (values[i]) b |= (1 << bit);
      }
      writeUByte(b);
    }
  }

  /**
   * Writes a C# {@code Guid} (UUID) in the mixed-endian layout used by
   * Terraria, mirroring {@link BinaryReader#readUUID()}.
   * <p>
   * First three components little-endian, last 8 bytes big-endian.
   */
  public void writeUUID(UUID uuid) throws IOException {
    final long msb = uuid.getMostSignificantBits();
    final long lsb = uuid.getLeastSignificantBits();

    // Reverse the MSB layout that readUUID applied
    // readUUID: b[0..3] → bytes 3,2,1,0 of msb[56..32]  (Data1, LE)
    //           b[4..5] → bytes 5,4 of msb                (Data2, LE)
    //           b[6..7] → bytes 7,6 of msb                (Data3, LE)
    final byte[] b = new byte[16];

    // Data1 (4 bytes, little-endian)
    b[0] = (byte) (msb >> 32);
    b[1] = (byte) (msb >> 40);
    b[2] = (byte) (msb >> 48);
    b[3] = (byte) (msb >> 56);

    // Data2 (2 bytes, little-endian)
    b[4] = (byte) (msb >> 16);
    b[5] = (byte) (msb >> 24);

    // Data3 (2 bytes, little-endian)
    b[6] = (byte) (msb);
    b[7] = (byte) (msb >> 8);

    // Data4 (8 bytes, big-endian)
    b[8]  = (byte) (lsb >> 56);
    b[9]  = (byte) (lsb >> 48);
    b[10] = (byte) (lsb >> 40);
    b[11] = (byte) (lsb >> 32);
    b[12] = (byte) (lsb >> 24);
    b[13] = (byte) (lsb >> 16);
    b[14] = (byte) (lsb >> 8);
    b[15] = (byte) (lsb);

    raf.write(b);
  }

  // ── Internal helpers ──────────────────────────────────────────────────────

  /**
   * Writes a non-negative integer as a 7-bit variable-length (LEB128) value,
   * matching the .NET {@code BinaryWriter.Write(string)} length prefix.
   */
  private void writeLeb128(int value) throws IOException {
    while (value > 0x7F) {
      raf.writeByte((value & 0x7F) | 0x80);
      value >>>= 7;
    }
    raf.writeByte(value & 0x7F);
  }

  // ── AutoCloseable ─────────────────────────────────────────────────────────

  @Override
  public void close() throws IOException {
    raf.close();
  }
}
