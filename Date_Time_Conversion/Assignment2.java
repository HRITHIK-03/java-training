package Date_Time_Conversion;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


class DateTimeInput {
    private LocalDateTime localDateTime;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isValidDateTime(String input) {
        try {
            LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        DateTimeInput userInput = getUserInput();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime originalDateTime = userInput.getLocalDateTime();
        LocalDateTime addOneDay = originalDateTime.plusDays(1);
        LocalDateTime minusTenDays = originalDateTime.minusDays(10);
        LocalDateTime addOneHour = originalDateTime.plusHours(1);
        LocalDateTime minusFiveHoursThirtyMins = originalDateTime.minusHours(5).minusMinutes(30);

        List<LocalDateTime> dateList = new ArrayList<>();
        dateList.add(originalDateTime);
        dateList.add(addOneDay);
        dateList.add(minusTenDays);
        dateList.add(addOneHour);
        dateList.add(minusFiveHoursThirtyMins);

        Collections.sort(dateList, Comparator.naturalOrder());

        System.out.println("Original Date: " + originalDateTime.format(formatter));
        System.out.println("Add one day: " + addOneDay.format(formatter));
        System.out.println("Minus 10 days: " + minusTenDays.format(formatter));
        System.out.println("Add 1 hour: " + addOneHour.format(formatter));
        System.out.println("Minus 5 hours and 30 minutes: " + minusFiveHoursThirtyMins.format(formatter));

        System.out.println("\nSorted Dates:");
        for (LocalDateTime date : dateList) {
            System.out.println(date.format(formatter));
        }
    }

    private static DateTimeInput getUserInput() { // This function is added to the main class as we are returning the object of the DateTimeInput class. It is for better readability.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date and time (dd/MM/yyyy HH:mm): ");
        String userInput = scanner.nextLine();

        DateTimeInput dateTimeInput = new DateTimeInput();
        while (!dateTimeInput.isValidDateTime(userInput)) {
            System.out.println("Invalid date and time format. Please use the format dd/MM/yyyy HH:mm");
            System.out.println("Enter date and time again: ");
            userInput = scanner.nextLine();
        }

        dateTimeInput.setLocalDateTime(LocalDateTime.parse(userInput, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        return dateTimeInput;
    }
}


