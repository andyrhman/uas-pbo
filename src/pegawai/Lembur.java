package pegawai;

class Lembur {
    private int jamLembur;

    public void aturJam(int jamLembur) {
        this.jamLembur = jamLembur;
    }

    public double hitung(double jumlah) {
        return jamLembur * 10000;
    }
}