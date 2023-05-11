package aula07;

public class DateYMD extends Date {

    public DateYMD(int day, int month, int year) {
        if (validDate(day, month, year)) {
            setDay(day);
            setMonth(month);
            setYear(year);
        } else {
            throw new IllegalArgumentException("A data não é valida.");
        }
    }

    @Override
    public void increment(int increment) {
        for (int i = 0; i < increment; i++) {
            int day = getDay();
            int month = getMonth();
            int year = getYear();
            day++;
            if (day > monthDays(month, year)) {
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }

    @Override
    public void decrement(int decrement) {
        int day = getDay();
        int month = getMonth();
        int year = getYear();
        day -= decrement;
        while (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            day += monthDays(month, year);
        }
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    @Override
    public String toString() {
        return String.format("%04d/%02d/%02d", getYear(), getMonth(), getDay());
    }
}
