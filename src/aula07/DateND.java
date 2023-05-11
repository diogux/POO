package aula07;

public class DateND extends Date {
    long resultado; // dia inicial 1/1/2000

    public DateND(int day, int month, int year) {
        if (validDate(day, month, year)) {
            this.resultado = DistanceInDays(day, month, year);
        } else {
            throw new IllegalArgumentException("A data não é valida.");
        }
    }

    private long DistanceInDays(int day, int month, int year) {
        long resultado = 0;
        for (int i = 2000; i < year; i++) {
            if (leapYear(i)) {
                resultado += 366;
            } else {
                resultado += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            resultado += monthDays(i, year);
        }
        resultado += day;
        return resultado;
    }

    public void increment(int increment) {
        resultado += increment;
    }

    public void decrement(int decrement) {
        resultado -= decrement;
    }

    @Override
    public String toString() {
        if (resultado == 0)
            return "1/1/2000";
        return String.format("A data indicada está a uma distacia (%s) de %d dias da data 1/1/2000",
                resultado > 0 ? "positiva" : "negativa", Math.abs(resultado));
    }

    // Teste
    public static void main(String[] args) {
        DateND data = new DateND(12, 1, 2023);
        System.out.println(data);

    }
}
