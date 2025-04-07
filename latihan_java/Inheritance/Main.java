package Inheritance;

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
        System.out.println("Total Gaji : " + hitungGaji());
    }

}

public class Main {
    public static void main(String[] args){
        Dosen dosen1 = new Dosen("Edwin", "301", 15, 15000);
        dosen1.tampilkanInfo();
    }
}
