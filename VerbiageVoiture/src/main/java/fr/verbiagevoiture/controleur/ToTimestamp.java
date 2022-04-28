package fr.verbiagevoiture.controleur;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

import org.eclipse.swt.widgets.DateTime;

public class ToTimestamp {
    public static Timestamp fromInt(int year, int month, int day, int hour, int minutes) {
        return Timestamp.valueOf(
                LocalDateTime.of(
                        year,
                        Month.of(month),
                        day,
                        hour,
                        minutes));
    }

    /**
     * Dans la vue, on a deux objets de type DateTime : l'un représente le jour de
     * départ, l'autre l'heure de départ
     * 
     * @param day   jour de départ
     * @param hours heure de départ
     * @return Timestamp à fournir à la requête SQL
     */
    public static Timestamp fromDateTime(DateTime day, DateTime hours) {
        return Timestamp.valueOf(
                LocalDateTime.of(
                        day.getYear(),
                        Month.of(day.getMonth()),
                        day.getDay(),
                        hours.getHours(),
                        hours.getMinutes()));
    }
}
