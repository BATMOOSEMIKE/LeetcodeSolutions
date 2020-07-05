class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //Starting "base" date of January 1 1968, monday (leap year)
        int yearDiff = year - 1968;
        int daysFromYearDiff = yearDiff * 365 + (yearDiff+3)/4;

        int monthDiff = month - 1;
        int daysFromMonthDiff = 0;
        switch(monthDiff){
            case 0:
                daysFromMonthDiff = 0;
                break;
            case 1:
                daysFromMonthDiff = 31;
                break;
            case 2:
                daysFromMonthDiff = 59;
                break;
            case 3:
                daysFromMonthDiff = 90;
                break;
            case 4:
                daysFromMonthDiff = 120;
                break;
            case 5:
                daysFromMonthDiff = 151;
                break;
            case 6:
                daysFromMonthDiff = 181;
                break;
            case 7:
                daysFromMonthDiff = 212;
                break;
            case 8:
                daysFromMonthDiff = 243;
                break;
            case 9:
                daysFromMonthDiff = 273;
                break;
            case 10:
                daysFromMonthDiff = 304;
                break;
            case 11:
                daysFromMonthDiff = 334;
                break;

        }
        //Account for leap year past feb
        if(monthDiff > 1 && year%4 == 0){
            daysFromMonthDiff++;
        }

        int dayDiff = day - 1;
        int totalDiff = dayDiff + daysFromMonthDiff + daysFromYearDiff;

        int move = totalDiff % 7;

        switch(move){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
        }

        return "Monday";
    }
}
