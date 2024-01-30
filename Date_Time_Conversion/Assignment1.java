package Date_Time_Conversion;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class DateTimeConversionResult {
    private final boolean valid;
    private final LocalDateTime localDateTime;

    public DateTimeConversionResult(boolean valid, LocalDateTime localDateTime) {
        this.valid = valid;
        this.localDateTime = localDateTime;
    }

    public boolean isValid() {
        return valid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}

class DateTimeParser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public DateTimeConversionResult parseDateTime(String userInput) {
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(userInput, FORMATTER);
            return new DateTimeConversionResult(true, localDateTime);
        } catch (Exception e) {
            return new DateTimeConversionResult(false, null);
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter date and time (dd/MM/yyyy HH:mm): ");
        String userInput = inputScanner.nextLine();

        DateTimeParser dateTimeParser = new DateTimeParser();
        DateTimeConversionResult conversionResult = dateTimeParser.parseDateTime(userInput);

        if (conversionResult.isValid()) 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            long unixTimestamp = conversionResult.getLocalDateTime().atZone(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
            System.out.println("Unix Timestamp: " + unixTimestamp);

            ZonedDateTime zonedIST = conversionResult.getLocalDateTime().atZone(ZoneId.of("Asia/Kolkata"));
            ZonedDateTime zonedUTC = zonedIST.withZoneSameInstant(ZoneId.of("UTC"));
            System.out.println("UTC Timestamp: " + zonedUTC.format(formatter));

            LocalDateTime localUTC = zonedUTC.toLocalDateTime();
            System.out.println("Local Timestamp (IST): " + localUTC.format(formatter));
        } 
        else
        {
            System.out.println("Invalid date format. Please use the format dd/MM/yyyy HH:mm");
        }

    }
}




