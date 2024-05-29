package model;

public class CalculoHoras {

    public static long calcularDiferencaTempo(long initialTime, long finalTime) {
        return finalTime - initialTime;
    }

    public static String calcularDiferencaTempoFormatada(long initialTime, long finalTime) {
        long diferenca = calcularDiferencaTempo(initialTime, finalTime);

        if(diferenca > 14400000) {
            long horasExtras = diferenca - 14400000;
            return formatarTempo(horasExtras);
        }

        long diffSeconds = diferenca / 1000 % 60;
        long diffMinutes = diferenca / (60 * 1000) % 60;
        long diffHours = diferenca / (60 * 60 * 1000) % 24;

        return String.format("%02d:%02d:%02d", diffHours, diffMinutes, diffSeconds);
    }

    public static String calcularHorasExtra(long totHours) {
        long horasExtras = totHours - 14400000;

        if (horasExtras <= 0) {
            return "00:00:00";
        }

        return formatarTempo(horasExtras);
    }

    public static String formatarTempo(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("O valor de tempo não pode ser negativo.");
        }

        long segundos = millis / 1000;
        long horas = segundos / 3600;
        segundos %= 3600;
        long minutos = segundos / 60;
        segundos %= 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public static String horasApagar(long initialTime, long finalTime, long millis) {
        long diferenca = calcularDiferencaTempo(initialTime, finalTime);
        diferenca -= millis;

        diferenca = Math.abs(diferenca);
        long diffSeconds = diferenca / 1000 % 60;
        long diffMinutes = diferenca / (60 * 1000) % 60;
        long diffHours = diferenca / (60 * 60 * 1000);

        return String.format("%02d:%02d:%02d", diffHours, diffMinutes, diffSeconds);
    }

    public static String calcularSalario(long milissegundosTotais) {

        double horas = milissegundosTotais / 3600000.0;

        double salario =  20 * horas;

        return String.format("%.2f", salario);
    }

}

