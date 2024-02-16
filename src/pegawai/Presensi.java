package pegawai;

class Presensi {
    private int waktuTiba;
    private int waktuBerangkat;

    public void aturWaktu(int waktuTiba, int waktuBerangkat) {
        this.waktuTiba = waktuTiba;
        this.waktuBerangkat = waktuBerangkat;
    }

    public boolean datangTerlambat() {
        return waktuTiba > 7;
    }

    public boolean pulangCepat() {
        return waktuBerangkat < 16;
    }

    public int menitTelat() {
        return Math.max(0, waktuTiba - 7);
    }

    public int menitAwal() {
        return Math.max(0, 16 - waktuBerangkat);
    }
}