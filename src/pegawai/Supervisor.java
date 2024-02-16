package pegawai;

public class Supervisor implements Pegawai {
    private double GAJI_POKOK = 10000000;
    private double LEMBUR_PER_JAM = 10000;
    private double BIAYA_TRANSPORTASI = 1000000;
    private double TUNJANGAN_ISTRI = 300000;
    private double TUNJANGAN_ANAK;
    private Presensi presensi;
    private Lembur lembur;

    public Supervisor(int jumlahAnak) {
        this.TUNJANGAN_ANAK = jumlahAnak > 1 ? 200000 : 100000;
        this.presensi = new Presensi();
        this.lembur = new Lembur();
    }

    public void aturPresensi(int waktuTiba, int waktuBerangkat) {
        presensi.aturWaktu(waktuTiba, waktuBerangkat);
    }

    public void aturLembur(int jamLembur) {
        lembur.aturJam(jamLembur);
    }

    @Override
    public double hitungTotalGaji() {
        double totalGaji = GAJI_POKOK + BIAYA_TRANSPORTASI + TUNJANGAN_ISTRI + TUNJANGAN_ANAK + lembur.hitung(LEMBUR_PER_JAM);
        if (presensi.datangTerlambat()) {
            totalGaji -= presensi.menitTelat() * 100000;
        }
        if (presensi.pulangCepat()) {
            totalGaji -= presensi.menitAwal() * 100000;
        }
        return totalGaji;
    }
}