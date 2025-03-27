class DataDosen09 {
    Dosen09[] dataDosen = new Dosen09[10]; 
    int idx = 0; 

    public void tambah(Dosen09 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    public void tampil() {
        if (idx == 0) {
            System.out.println("Belum ada data dosen.");
            return;
        }
        System.out.println("\nData Dosen:");
        System.out.println("--------------------------");
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
            System.out.println("--------------------------");
        }
    }

    public void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - 1 - i; j++) {
                if (dataDosen[j].usia > dataDosen[j + 1].usia) {
                    Dosen09 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j + 1];
                    dataDosen[j + 1] = temp;
                }
            }
        }
        System.out.println("Data berhasil diurutkan secara ASCENDING (Termuda ke Tertua).");
    }

    public void sortingDSC() {
        for (int i = 1; i < idx; i++) {
            Dosen09 temp = dataDosen[i];
            int j = i - 1;
            while (j >= 0 && dataDosen[j].usia < temp.usia) { 
                dataDosen[j + 1] = dataDosen[j];
                j--;
            }
            dataDosen[j + 1] = temp;
        }
        System.out.println("Data berhasil diurutkan secara DESCENDING (Tertua ke Termuda).");
    }

    // Pencarian Data Sequential berdasarkan Nama
    public void pencarianDataSequential(String namaCari) {
        boolean ditemukan = false;
        int count = 0;
        
        System.out.println("\nHasil Pencarian Nama: " + namaCari);
        System.out.println("--------------------------");

        for (int i = 0; i < idx; i++) {
            if (dataDosen[i].nama.equalsIgnoreCase(namaCari)) {
                dataDosen[i].tampil();
                System.out.println("--------------------------");
                ditemukan = true;
                count++;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data dosen dengan nama '" + namaCari + "' tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("⚠️ Peringatan: Ada lebih dari satu dosen dengan nama yang sama.");
        }
    }

    // Pencarian Data Binary berdasarkan Usia (Tampilkan Semua yang Sama)
    public void pencarianDataBinary(int usiaCari) {
        sortingASC(); 
        
        int kiri = 0, kanan = idx - 1;
        boolean ditemukan = false;

        System.out.println("\nHasil Pencarian Usia: " + usiaCari);
        System.out.println("--------------------------");

        // Melakukan binary search
        while (kiri <= kanan) {
            int mid = (kiri + kanan) / 2;
            
            if (dataDosen[mid].usia == usiaCari) {
                int i = mid;
                
                while (i >= 0 && dataDosen[i].usia == usiaCari) {
                    dataDosen[i].tampil();
                    System.out.println("--------------------------");
                    i--;
                }
                
                i = mid + 1;
                while (i < idx && dataDosen[i].usia == usiaCari) {
                    dataDosen[i].tampil();
                    System.out.println("--------------------------");
                    i++;
                }
                
                ditemukan = true;
                break;
            } else if (dataDosen[mid].usia < usiaCari) {
                kiri = mid + 1;
            } else {
                kanan = mid - 1;
            }
        }

        if (!ditemukan) {
            System.out.println("Data dosen dengan usia '" + usiaCari + "' tidak ditemukan.");
        }
    }
}
