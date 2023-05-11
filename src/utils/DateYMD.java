package utils;

import java.time.LocalDate;

public class DateYMD {
    private int day;
    private int month;
    private int year;

    public DateYMD(int day, int month, int year) {
        if (valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("A data não é valida");
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    static boolean validYear(int year) {
        return year >= 0;
    }

    static int monthDays(int month, int year) {
        if (month == 2) {
            if (leapYear(year)) {
                return 29; // Ano bissexto
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    static boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

    }

    static boolean valid(int day, int month, int year) {
        return validYear(year) && validMonth(month) && day >= 1 && day <= monthDays(month, year);
    }

    public String toString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }

    public void increment() {
        if (valid(day + 1, month, year)) {
            day++;
        } else if (valid(1, month + 1, year)) {
            day = 1;
            month++;
        } else if (valid(1, 1, year + 1)) {
            day = 1;
            month = 1;
            year++;
        } else {
            System.out.println("Data inválida.");
        }
    }

    public static DateYMD today() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        return new DateYMD(day, month, year);
    }

    public void decrement() {
        if (valid(day - 1, month, year)) {
            day--;
        } else if (valid(monthDays(month - 1, year), month - 1, year)) {
            day = monthDays(month - 1, year);
            month--;
        } else if (valid(31, 12, year - 1)) {
            day = 31;
            month = 12;
            year--;
        } else {
            System.out.println("Data inválida.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        DateYMD d = (DateYMD) obj;
        return d.day == this.day && d.month == this.month && d.year == this.year;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.day;
        hash = 31 * hash + this.month;
        hash = 31 * hash + this.year;
        return hash;
    }
}
