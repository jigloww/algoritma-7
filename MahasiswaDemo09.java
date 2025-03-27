import java.util.Locale;
import java.util.Scanner;

public class MahasiswaDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan jumlah Mahasiswa yang akan di input: ");
        int jumMHS = sc.nextInt();
        MahasiswaBerprestasi09 list = new MahasiswaBerprestasi09(jumMHS);
        sc.useLocale(Locale.US);
        sc.nextLine();

        for (int i = 0; i < jumMHS; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            String ip = sc.nextLine().replace(",", ".");
            double ipk = Double.parseDouble(ip);
            System.out.println("--------------------------------");
            list.tambah(new Mahasiswa09(nim, nama, kelas, ipk));
        }

        list.tampil();

        // Melakukan pencarian data sequential
        System.out.println("------------------------------------------------------");
        System.out.println("Pencarian Data");
        System.out.println("------------------------------------------------------");
        System.out.println("Masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        String cariInput = sc.nextLine().replace(",", ".");
        double cari = Double.parseDouble(cariInput);

        System.out.println("Menggunakan sequential searching");
        double posisi = list.sequentialSearching(cari);
        int pss = (int) posisi;
        list.tampilPosisi(cari, pss);
        list.tampildataSearch(cari, pss);

        // Melakukan pencarian data binary
        System.out.println("------------------------------------------------------");
        System.out.println("Pencarian Data");
        System.out.println("------------------------------------------------------");
        System.out.println("Masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        cari = sc.nextDouble();
        System.out.println("------------------------------------------------------");
        System.out.println("Menggunakan binary search");
        System.out.println("------------------------------------------------------");
        double posisi2 = list.findBinarySearch(cari, 0, jumMHS-1);
        int pss2 = (int) posisi2;
        list.tampilPosisi(cari, pss2);
        list.tampildataSearch(cari, pss2);
    }
}
