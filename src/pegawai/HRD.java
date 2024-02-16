/*
 * KODE INI DIBUAT OLEH:
 * ANDY RAHMAN RAMADHAN
 * 220401070404
*/

package pegawai;

public class HRD implements Pegawai {
    private final double GAJI_POKOK = 5000000;
    private final double TRANSPORT = 750000000;
    private final double LEMBUR_PER_JAM = 7500;
    private final double TUNJANGAN_ISTRI = 250000;
    private final double TUNJANGAN_ANAK_1 = 90000;
    private final double TUNJANGAN_ANAK_2 = 190000;

    @Override
    public double hitungGaji(int jamMasuk, int jamPulang, int jumlahAnak) {
        // Menghitung jam lembur
        int jamLembur = Math.max(0, jamPulang - 16);

        // Menghitung potongan gaji karena terlambat
        int potonganTerlambat = Math.max(0, jamMasuk - 7) * 100000;

        // Menghitung potongan gaji karena pulang awal
        int potonganPulangAwal = Math.max(0, 16 - jamPulang) * 100000;

        // Menghitung gaji pokok
        double gajiPokok = GAJI_POKOK - potonganTerlambat - potonganPulangAwal;

        // Menghitung tunjangan anak
        double tunjanganAnak = jumlahAnak == 1 ? TUNJANGAN_ANAK_1 : TUNJANGAN_ANAK_2;

        // Menghitung total gaji
        double totalGaji = gajiPokok + TRANSPORT + (jamLembur * LEMBUR_PER_JAM) + TUNJANGAN_ISTRI + tunjanganAnak;

        return totalGaji;
    }
}
