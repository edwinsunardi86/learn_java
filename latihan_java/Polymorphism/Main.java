package Polymorphism;

import java.util.Arrays;
import java.util.List;

class Pegawai {
    protected String nama;
    protected String nip;

    public Pegawai(String nama, String nip){
        this.nama = nama;
        this.nip = nip;
    }
    public void tampilkanInfo(){
        System.out.println("Nama : " + nama);
        System.out.println("Nip : " +  nip);
    }
}

class Dosen extends Pegawai {
    private int jumlahSks;
    private int tarifPerSks;

    public Dosen(String nama, String nip,int jumlahSks, int tarifPerSks){
        super(nama, nip);
        this.jumlahSks = jumlahSks;
        this.tarifPerSks = tarifPerSks;
    }

    public int hitungGaji(){
        return jumlahSks * tarifPerSks;
    }
    @Override
    public void tampilkanInfo(){
        // System.out.println("Nama : " + nama);
        // System.out.println("Nip : " +  nip);
        super.tampilkanInfo();
        System.out.println("Total SKS : " + jumlahSks);
        System.out.println("Tarif per SKS : " + tarifPerSks);
        System.out.println("Total Gaji : " + hitungGaji() + "\n");
    }

}

class Staff extends Pegawai{
    private int gajiBulanan;
    public Staff(String nama, String nip, int gajiBulanan){
        super(nama,nip);
        this.gajiBulanan = gajiBulanan;
    }

    @Override
    public void tampilkanInfo(){
        super.tampilkanInfo();
        System.out.println("Total gaji: " + gajiBulanan + "\n");
    }
}

public class Main {
    public static void main(String[] args){
        List<Pegawai> pegawai = Arrays.asList(new Dosen("Edwin", "012", 15, 15000), new Staff("Devi", "014", 3500000));
        
        // perulangan / non lambda expression
        // for (Pegawai n : pegawai) {
        //     n.tampilkanInfo();
        // }

        // anonymous function
        // pegawai.forEach(new Consumer<Pegawai>() {
        //     @Override
        //     public void accept(Pegawai n) {
        //         n.tampilkanInfo();
        //     }
        // });
        pegawai.forEach(n -> {
            n.tampilkanInfo();
        });
    }
}
