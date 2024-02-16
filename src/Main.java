import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

import pegawai.*;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan Kode (Supervisor = SPV, HRD = HRD, Teknisi = TKN, Karyawan = KRY): ");
        String kode = scanner.nextLine().toUpperCase();

        System.out.print("Jam Masuk: ");
        int jamMasuk = scanner.nextInt();

        System.out.print("Jam Pulang: ");
        int jamPulang = scanner.nextInt();

        System.out.print("Tunjangan Anak: ");
        int tunjanganAnak = scanner.nextInt();

        // Jika jamMasuk dan jamPulang berada dalam rentang 1-24
        if ((jamMasuk < 1 || jamMasuk > 24) || (jamPulang < 1 || jamPulang > 24)) {
            System.out.println("Jam tidak valid. Harus antara  1-24.");
            return; // Hentikan eksekusi program
        }

        Pegawai pegawai;
        switch (kode) {
            case "SPV":
                pegawai = new Supervisor();
                break;
            case "HRD":
                pegawai = new HRD();
                break;
            case "TKN":
                pegawai = new Teknisi();
                break;
            case "KRY":
                pegawai = new Karyawan();
                break;
            default:
                System.out.println("Kode tidak valid");
                return;
        }

        double gaji = pegawai.hitungGaji(jamMasuk, jamPulang, tunjanganAnak);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("id", "ID"));

        String formatGaji = formatter.format(gaji);
        
        System.out.println("Gaji total: " + formatGaji);

        scanner.close();
    }
}
