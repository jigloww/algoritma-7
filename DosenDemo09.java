import java.util.Scanner;

public class DosenDemo09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DataDosen09 daftarDosen = new DataDosen09();
        
        while (true) {
            System.out.println("\n=== MENU DATA DOSEN ===");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampilkan Data Dosen");
            System.out.println("3. Sorting ASC (Usia termuda ke tertua)");
            System.out.println("4. Sorting DSC (Usia tertua ke termuda)");
            System.out.println("5. Cari Dosen berdasarkan Nama (Sequential Search)");
            System.out.println("6. Cari Dosen berdasarkan Usia (Binary Search)");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
                case 1:
                    if (daftarDosen.idx < 10) {
                        System.out.print("Masukkan Kode Dosen: ");
                        String kode = input.nextLine();
                        System.out.print("Masukkan Nama Dosen: ");
                        String nama = input.nextLine();
                        System.out.print("Jenis Kelamin (L = Laki-laki, P = Perempuan): ");
                        char gender = input.next().charAt(0);
                        boolean jenisKelamin = (gender == 'L' || gender == 'l');
                        System.out.print("Masukkan Usia: ");
                        int usia = input.nextInt();
                        input.nextLine();

                        Dosen09 dsn = new Dosen09(kode, nama, jenisKelamin, usia);
                        daftarDosen.tambah(dsn);
                        System.out.println("Data dosen berhasil ditambahkan!");
                    } else {
                        System.out.println("Data dosen sudah penuh!");
                    }
                    break;
                
                case 2:
                    daftarDosen.tampil();
                    break;
                
                case 3:
                    daftarDosen.sortingASC();
                    daftarDosen.tampil();
                    break;
                
                case 4:
                    daftarDosen.sortingDSC();
                    daftarDosen.tampil();
                    break;

                case 5:
                    System.out.print("Masukkan Nama Dosen yang dicari: ");
                    String namaCari = input.nextLine();
                    daftarDosen.pencarianDataSequential(namaCari);
                    break;
                
                case 6:
                    System.out.print("Masukkan Usia Dosen yang dicari: ");
                    int usiaCari = input.nextInt();
                    daftarDosen.pencarianDataBinary(usiaCari);
                    break;
                
                case 7:
                    System.out.println("Terima kasih! Program selesai.");
                    input.close();
                    return;
                
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
}
