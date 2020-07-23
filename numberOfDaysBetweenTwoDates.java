import java.time.temporal.ChronoUnit;
import java.time.*;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] first = date1.split("-");
        String[] second = date2.split("-");

        LocalDate firstDate = LocalDate.of(Integer.parseInt(first[0]), Integer.parseInt(first[1]), Integer.parseInt(first[2]));

        LocalDate secondDate = LocalDate.of(Integer.parseInt(second[0]), Integer.parseInt(second[1]), Integer.parseInt(second[2]));

        return Math.abs((int)ChronoUnit.DAYS.between(firstDate, secondDate));
    }
}
