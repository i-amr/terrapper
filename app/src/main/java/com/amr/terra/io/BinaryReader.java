package com.amr.terra.io;

import com.amr.terra.TerrapperApp;
import com.amr.terra.data.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BinaryReader implements AutoCloseable {

  private RandomAccessFile raf;
  private final byte[] scratch = new byte[8];
  private final ByteBuffer buffer = ByteBuffer.wrap(scratch).order(ByteOrder.LITTLE_ENDIAN);

  public BinaryReader(File file) throws IOException {
    this(file.getAbsolutePath());
  }

  public BinaryReader(String file) throws IOException {
    raf = new RandomAccessFile(file, "r");
  }

  public BinaryReader(String file, String key) throws IOException {
    this(new File(file), key);
  }

  public BinaryReader(File file, String key) throws IOException {
    File tempFile = new File(TerrapperApp.context.getCacheDir(), file.getName());

    try (FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(tempFile)) {

      byte[] encryptedData = new byte[(int) file.length()];
      fis.read(encryptedData);

      byte[] keyBytes = key.getBytes(StandardCharsets.UTF_16LE);
      SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
      IvParameterSpec iv = new IvParameterSpec(keyBytes);

      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

      byte[] decryptedData = cipher.doFinal(encryptedData);
      fos.write(decryptedData);

      raf = new RandomAccessFile(tempFile, "r");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int skipBytes(int count) throws IOException {
    return raf.skipBytes(count);
  }

  public void seek(long pos) throws IOException {
    raf.seek(pos);
  }

  public long getFilePointer() throws IOException {
    return raf.getFilePointer();
  }

  public char peekChar() throws IOException {
    long position = raf.getFilePointer();
    int b = raf.readUnsignedByte();
    raf.seek(position);
    return (char) b;
  }

  public String readString() throws IOException {
    int length = 0;
    int step = 0;
    while (true) {
      int b = raf.readUnsignedByte();
      length |= (b & 0x7F) << (step * 7);
      if ((b & 0x80) == 0) break;
      step++;
    }
    byte[] buf = new byte[length];
    raf.readFully(buf);
    return new String(buf, StandardCharsets.UTF_8);
  }

  public String readChars(int count) throws IOException {
    byte[] buf = new byte[count];
    raf.readFully(buf);
    return new String(buf, StandardCharsets.UTF_8);
  }

  public boolean[] readBitArray(int length) throws IOException {
    boolean[] booleans = new boolean[length];
    int data = 0;
    int bitMask = 128;

    for (int i = 0; i < length; i++) {
      if (bitMask != 128) {
        bitMask <<= 1;
      } else {
        data = readUByte();
        bitMask = 1;
      }

      if ((data & bitMask) == bitMask) {
        booleans[i] = true;
      }
    }

    return booleans;
  }

  public int readUByte() throws IOException {
    return raf.readUnsignedByte(); // 0~255
  }

  public byte readSByte() throws IOException {
    return raf.readByte(); // -128~127
  }

  public boolean readBoolean() throws IOException {
    return readSByte() != 0;
  }

  public float readSingle() throws IOException {
    return readBytes(4).getFloat();
  }

  public double readDouble() throws IOException {
    return readBytes(8).getDouble();
  }

  public int readUInt16() throws IOException {
    return readInt16() & 0xFFFF;
  }

  public long readUInt32() throws IOException {
    return Integer.toUnsignedLong(readInt32());
  }

  public BigInteger readUInt64() throws IOException {
    return new BigInteger(1, ByteBuffer.allocate(8).putLong(readInt64()).array());
  }

  public short readInt16() throws IOException {
    return readBytes(2).getShort();
  }

  public int readInt32() throws IOException {
    return readBytes(4).getInt();
  }

  public long readInt64() throws IOException {
    return readBytes(8).getLong();
  }

  public Color readRGB() throws IOException {
    return new Color(readUByte(), readUByte(), readUByte());
  }

  public Color readARGB() throws IOException {
    return new Color(readUByte(), readUByte(), readUByte(), readUByte());
  }

  public ByteBuffer readBytes(int size) throws IOException {
    raf.readFully(scratch, 0, size);
    buffer.rewind();
    return buffer;
  }

  public UUID readUUID() throws IOException {
    byte[] b = new byte[16];
    raf.readFully(b);

    // First 3 components are little-endian (C# Guid layout)
    long msb =
        ((long) (b[3] & 0xFF) << 56)
            | ((long) (b[2] & 0xFF) << 48)
            | ((long) (b[1] & 0xFF) << 40)
            | ((long) (b[0] & 0xFF) << 32)
            | ((long) (b[5] & 0xFF) << 24)
            | ((long) (b[4] & 0xFF) << 16)
            | ((long) (b[7] & 0xFF) << 8)
            | ((long) (b[6] & 0xFF));

    // Last 8 bytes are big-endian
    long lsb =
        ((long) (b[8] & 0xFF) << 56)
            | ((long) (b[9] & 0xFF) << 48)
            | ((long) (b[10] & 0xFF) << 40)
            | ((long) (b[11] & 0xFF) << 32)
            | ((long) (b[12] & 0xFF) << 24)
            | ((long) (b[13] & 0xFF) << 16)
            | ((long) (b[14] & 0xFF) << 8)
            | ((long) (b[15] & 0xFF));

    return new UUID(msb, lsb);
  }

  @Override
  public void close() throws IOException {
    raf.close();
  }
}
