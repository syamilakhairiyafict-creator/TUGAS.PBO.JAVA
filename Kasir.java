import java.util.Scanner;

 class Struk2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] barang = {"Mie ayam", "Bakso", "Es-Buah", "Es-campur"};
        int[] harga = {2000, 5000, 7000, 15000};
        int[] jumlahMenu = new int[barang.length];
        String tambahan = "y";
        int totalBelanja = 0;

        System.out.println("=== KASIR SEDERHANA ===");

        while (tambahan.equalsIgnoreCase("y")) {
            System.out.println("Daftar menu:");

            for (int i = 0; i < barang.length; i++) {
                System.out.println((i + 1) + ". " + barang[i] + " - Rp" + harga[i]);
            }

            System.out.println("========================");

            System.out.print("Masukan nomor menu: ");
            int pilihan = input.nextInt();

            // Validasi nomor menu
            if (pilihan < 1 || pilihan > barang.length) {
                System.out.println("Nomor menu tidak valid!");
                continue;
            }

            System.out.print("Masukan jumlah: ");
            int jumlah = input.nextInt();

            int subtotal = harga[pilihan - 1] * jumlah;
            jumlahMenu[pilihan - 1] += jumlah;
            totalBelanja += subtotal;

            System.out.println("Menu: " + barang[pilihan - 1]);
            System.out.println("Jumlah: " + jumlah);
            System.out.println("Subtotal: Rp." + subtotal);

            System.out.print("Apakah ingin beli menu lain? (y/n): ");
            tambahan = input.next();

            System.out.println("========================");
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("        DETAIL PEMBELIAN");
        System.out.println("================================");

        for (int j = 0; j < barang.length; j++) {
            if (jumlahMenu[j] > 0) {
                int subtotal = harga[j] * jumlahMenu[j];

                System.out.println(
                    barang[j]
                    + " x " + jumlahMenu[j]
                    + " = Rp" + subtotal
                );
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Total Belanja : Rp" + totalBelanja);

        // Pembayaran satu kali setelah semua pesanan
        int bayar;

        do {
            System.out.print("Uang Pembayaran : Rp");
            bayar = input.nextInt();

            if (bayar < totalBelanja) {
                System.out.println(
                    "Uang kurang Rp" + (totalBelanja - bayar)
                );
            }

        } while (bayar < totalBelanja);

        int kembalian = bayar - totalBelanja;

        System.out.println("Uang Bayar     : Rp" + bayar);
        System.out.println("Kembalian      : Rp" + kembalian);
        System.out.println("Status         : LUNAS");

        System.out.println("================================");
        System.out.println("          TERIMA KASIH!");
        System.out.println("================================");

        input.close();
    }
}