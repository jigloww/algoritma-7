public class Dosen09 {
    String kode;
    String nama;
    boolean jenisKelamin; 
    int usia;

    public Dosen09(String kd, String name, boolean jk, int age) {
        this.kode = kd;
        this.nama = name;
        this.jenisKelamin = jk;
        this.usia = age;
    }

    public void tampil() {
        String jk = (jenisKelamin) ? "Laki-laki" : "Perempuan";
        System.out.println("Kode Dosen  : " + kode);
        System.out.println("Nama Dosen  : " + nama);
        System.out.println("Jenis Kelamin : " + jk);
        System.out.println("Usia Dosen  : " + usia);
    }
}
