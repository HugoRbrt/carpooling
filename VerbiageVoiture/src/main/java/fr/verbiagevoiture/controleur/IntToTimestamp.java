package fr.verbiagevoiture.controleur;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

public class IntToTimestamp {
    public static Timestamp convert(int year, int month, int day, int hour, int minutes) {
        return Timestamp.valueOf(
                LocalDateTime.of(
                        year,
                        Month.of(month),
                        day,
                        hour,
                        minutes));
    }
}
