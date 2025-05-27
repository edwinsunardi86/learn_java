package Interface;

import java.util.Arrays;
import java.util.List;

interface ICetakInfo {
    void cetak();
}

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

class Dosen extends Pegawai implements ICetakInfo{
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

    @Override
    public void cetak(){
        tampilkanInfo();
    }

}

class Staff extends Pegawai implements ICetakInfo{
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

    @Override
    public void cetak(){
        tampilkanInfo();
    }
}

public class Main {
    public static void main(String[] args){
        // List<Dosen> dosen = new Dosen("Edwin", "301", 15, 35000);
        // List<Staff> staff = new Staff("Devi", "302", 3500000);
        List<ICetakInfo> iCetakInfo = Arrays.asList(new Dosen("Edwin", "301", 15, 35000),new Staff("Devi", "302", 3500000));
        iCetakInfo.forEach(n -> {
            n.cetak();
        });
    }
}
