package com.amr.terra.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class DateTime {
  // .NET Ticks start at 0001-01-01 00:00:00
  static final LocalDateTime DOTNET_EPOCH = LocalDateTime.of(1, 1, 1, 0, 0, 0);

  // Number of ticks per second (1 tick = 100ns; 10 million ticks = 1s)
  static final long TICKS_PER_SECOND = 10_000_000;

  // Bit masks
  static final long TICKS_MASK = 0x3FFFFFFFFFFFFFFFL;

  // Flags for .NET DateTimeKind (stored in the 2 MSB)
  static final long KIND_UNSPECIFIED = 0;
  static final long KIND_UTC         = 1;
  static final long KIND_LOCAL       = 2;

  /**
   * Returns the current local time.
   * Mirrors DateTime.Now in C#.
   */
  public static LocalDateTime now() {
    return LocalDateTime.now();
  }

  /**
   * Converts a LocalDateTime to a .NET DateTime binary (Int64).
   * Mirrors DateTime.ToBinary() in C#.
   *
   * Assumes local time (KIND_LOCAL), matching DateTime.Now behavior in .NET.
   *
   * @param dt The datetime to convert.
   * @return A 64-bit binary representation compatible with .NET DateTime.FromBinary().
   */
  public static long toBinary(LocalDateTime dt) {
    // Convert local time to UTC first
    LocalDateTime utcDt = dt.atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneOffset.UTC)
                .toLocalDateTime();

    // Calculate ticks since .NET epoch (0001-01-01)
    long micros = ChronoUnit.MICROS.between(DOTNET_EPOCH, utcDt);
    long ticks  = micros * 10; // microseconds → ticks (1 tick = 100ns)

    // Stamp KIND_LOCAL into top 2 bits (matching DateTime.Now behavior)
    return (KIND_LOCAL << 62) | (ticks & TICKS_MASK);
  }

  /**
   * Converts a .NET DateTime binary (Int64) into a LocalDateTime.
   * Mirrors DateTime.FromBinary() in C#.
   *
   * @param raw The 64-bit binary value read from file.
   * @return Parsed LocalDateTime.
   */
  public static LocalDateTime fromBinary(long raw) {
    raw = raw & 0xFFFFFFFFFFFFFFFFL;

    long kind  = (raw >> 62) & 0x03;
    long ticks = raw & TICKS_MASK;
    long micros = ticks / 10;

    LocalDateTime utcDt = DOTNET_EPOCH
        .plusSeconds(micros / 1_000_000)
        .plusNanos((micros % 1_000_000) * 1000);

    if (kind == KIND_LOCAL) {
      return utcDt.atOffset(ZoneOffset.UTC)
            .atZoneSameInstant(ZoneId.systemDefault())
            .toLocalDateTime();
    }

    if (kind == KIND_UTC) return utcDt;

    return utcDt; // KIND_UNSPECIFIED
  }
}