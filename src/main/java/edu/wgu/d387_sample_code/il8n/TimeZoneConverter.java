package edu.wgu.d387_sample_code.il8n;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    public String  convertTimeZones () {
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUniversal = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        //Get local date time
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        System.out.println("My current time: " + zonedDateTime.toString());

        // Formatting pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Initialize StringBuilder to concatenate results
        StringBuilder result = new StringBuilder();

        //Converting Eastern to local?
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        result.append("Eastern Time: ").append(zonedDateTimeEastern.format(formatter)).append(" ET\n");

        //Converting Mountain to local
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        result.append("Mountain Time: ").append(zonedDateTimeMountain.format(formatter)).append(" MT\n");

        //Converting Universal to local
        ZonedDateTime zonedDateTimeUniversal = zonedDateTime.withZoneSameInstant(zUniversal);
        result.append("Universal Time: ").append(zonedDateTimeUniversal.format(formatter)).append(" UTC\n");

        return result.toString();
    }
    public static void main(String[] args) {
        TimeZoneConverter converter = new TimeZoneConverter();

        // Get converted times as a concatenated String
        String convertedTimes = converter.convertTimeZones();

        // Print or use the concatenated String
        System.out.println(convertedTimes);
    }



}
