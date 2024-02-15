import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor(2);

        supervisor.aturPresensi(7, 16);

        supervisor.aturLembur(0);

        double totalGaji = supervisor.hitungTotalGaji();

        NumberFormat formatgaji = NumberFormat.getCurrencyInstance(Locale.of("id", "ID"));

        String gaji = formatgaji.format(totalGaji);

        System.out.println("Total gaji: " + gaji);
    }
}