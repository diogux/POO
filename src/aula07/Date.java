package aula07;

public abstract class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public abstract void increment(int increment);

    public abstract void decrement(int decrement);

    // getters e setters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static boolean leapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

    }

    public static boolean validYear(int year) {
        return year >= 0;
    }

    public static int monthDays(int month, int year) {
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

    public static boolean validDate(int day, int month, int year) {
        return validYear(year) && validMonth(month) && day >= 1 && day <= monthDays(month, year);
    }

    @Override
    public int compareTo(Date date) {
        if (getYear() > date.getYear()) {
            return 1;
        } else if (getYear() < date.getYear()) {
            return -1;
        } else {
            if (getMonth() > date.getMonth()) {
                return 1;
            } else if (getMonth() < date.getMonth()) {
                return -1;
            } else {
                if (getDay() > date.getDay()) {
                    return 1;
                } else if (getDay() < date.getDay()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
