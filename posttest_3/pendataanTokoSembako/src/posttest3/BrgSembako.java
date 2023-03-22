
package posttest3;


import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BrgSembako extends TokoSembako{
     private final String kodeBrg = "Brg";
    private long noKodeBrg;
    
    BrgSembako(String namaBrg, String satuan, int stokAwal, int stokMasuk, int stokKeluar, int hargaBeli, int hargaJual, long noKodeBrg){
        super(namaBrg,satuan,stokAwal,stokMasuk,stokKeluar,hargaBeli,hargaJual,noKodeBrg);
    }
    
    
    BrgSembako() {
        //UNTUK MENGATASI EROR DI MAIN
    }
    
    BrgSembako Brg;
    ArrayList<BrgSembako> BrgList = new ArrayList<>();
    InputStreamReader isr = new InputStreamReader (System.in);
    BufferedReader br = new BufferedReader(isr);
    Scanner inp = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    protected void tambahBarang () throws IOException{
        boolean ulang=true;
        System.out.println("\t|==================================================|");
        System.out.println("\t|               TAMBAH BARANG SEMBAKO            |");
        System.out.println("\t|==================================================|");
        System.out.print("Nama sembako : ");
        namaBrg = inp.nextLine();
        System.out.print("Satuan : ");
        satuan = inp.nextLine();
        System.out.print("Stok Awal  : ");
        stokAwal = Integer.parseInt(br.readLine());
        System.out.print("Stok Masuk  : ");
        stokMasuk = Integer.parseInt(br.readLine());
        System.out.print("Stok Keluar  : ");
        stokKeluar = Integer.parseInt(br.readLine());

        while(ulang){
            System.out.print("Harga Beli Barang [Satuan] : ");
            String strHargaBeli=inp.nextLine();
            System.out.print("Harga Jual Barang [Satuan] : ");
            String strHargaJual=inp.nextLine();
            if (strHargaJual.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }else if(strHargaBeli.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }
            else{
                try{
                    hargaBeli = (Integer.parseInt(strHargaBeli));
                    hargaJual = (Integer.parseInt(strHargaJual));
                    noKodeBrg++;
                    System.out.println("No Kode Barang : " + kodeBrg + noKodeBrg);
                    Brg = new BrgSembako(namaBrg, satuan, stokAwal, stokMasuk, stokKeluar, hargaBeli, hargaJual, noKodeBrg); // OBJEK ke - 1
                    BrgList.add(Brg);
                    System.out.println("\n>> Tambah Data Barang SEMBAKO Berhasil <<");
                    ulang=false;
                }catch(NumberFormatException e){
                    System.err.println("Data Yang anda masukkan tidak sesuai");
                }
            }
        }
    }
    
    protected void tampilBarang(){
        System.out.println("\t|==================================================|");
        System.out.println("\t|               TAMPIL BARANG SEMBAKO             |");
        System.out.println("\t|==================================================|");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("|===============================================================|");
            System.out.println("\tNo Kode Barang : " + kodeBrg + BrgList.get(i).getNoKodeBrg());
            System.out.println("\tNama Barang : " + BrgList.get(i).getNamaBrg());
            System.out.println("\tJenis Satuan : " + BrgList.get(i).getSatuan());
            System.out.println("\tStok Awal : " + BrgList.get(i).getStokAwal());
            System.out.println("\tStok Masuk : " + BrgList.get(i).getStokMasuk());
            System.out.println("\tStok Keluar : " + BrgList.get(i).getStokKeluar());
            System.out.println("\tStok Akhir : " + (BrgList.get(i).getStokAwal()+BrgList.get(i).getStokMasuk()-BrgList.get(i).getStokKeluar()));
            System.out.println("\tHarga Beli Barang [Satuan] : Rp" + BrgList.get(i).hargaBeli);
            System.out.println("\tHarga Jual Barang [Satuan] : Rp" + BrgList.get(i).hargaJual);
            System.out.println("|===============================================================|");
            System.out.println(" ");
        }
    }
    
    public ArrayList<BrgSembako> ubahBarang(ArrayList<BrgSembako> Brglist) throws IOException {
        int ubah;
        System.out.println("\t|==================================================|");
        System.out.println("\t|               UBAH BARANG SEMBAKO               |");
        System.out.println("\t|==================================================|");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("No Kode Barang : " + kodeBrg +
            BrgList.get(i).getNoKodeBrg());
            System.out.println("Nama Barang : " + BrgList.get(i).getNamaBrg());
            System.out.println(" ");
        }
        if (BrgList.size() == 1){
            ubah = 0;
        } else {
            System.out.print("\nInput No Kode untuk Mengubah Data [Input Angka Saja] : ");
            ubah = inputInt.nextInt();
            ubah--;
        }
        System.out.print("\nUbah Nama Barang : ");
//        BrgList.get(ubah).namaBrg = (inp.nextLine());
        BrgList.get(ubah).setNamaBrg(br.readLine());
        System.out.print("Ubah Jenis Satuan : ");
        BrgList.get(ubah).setSatuan(br.readLine());
        System.out.print("Ubah Stok Awal : ");
        BrgList.get(ubah).setStokAwal(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Stok Masuk : ");
        BrgList.get(ubah).setStokMasuk(Integer.parseInt(br.readLine()));
         System.out.print("Ubah Stok Keluar : ");
        BrgList.get(ubah).setStokKeluar(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Harga Beli Barang [Satuan] : ");
        BrgList.get(ubah).setHargaBeli(Integer.parseInt(br.readLine()));
        System.out.print("Ubah Harga Jual Barang [Satuan] : ");
        BrgList.get(ubah).setHargaJual(Integer.parseInt(br.readLine()));
        System.out.println("\n>> Data Barang Bangunan Berhasil Di Ubah <<\n");

        return BrgList;
    }
    
    public void hapusBarang() {
        System.out.println("\t|==================================================|");
        System.out.println("\t|               HAPUS BARANG SEMBAKO              |");
        System.out.println("\t|==================================================|");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("No Kode Barang : " + kodeBrg +
            BrgList.get(i).getNoKodeBrg());
            System.out.println("Nama Barang : " + BrgList.get(i).getNamaBrg());
            System.out.println(" ");
        }
        int hapus;
        System.out.print("\nMasukan No Kode untuk Hapus Barang [Input Angka Belakang] : ");
        hapus = inputInt.nextInt();
        hapus--;
        BrgList.remove(hapus);
        System.out.println("\n>> Data Barang Sembako Berhasil di Hapus <<\n");
    }

    
}
