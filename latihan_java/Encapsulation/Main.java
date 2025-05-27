package Encapsulation;

class Mahasiswa{
    private String nama;
    private String nim;
    private double ipk;

    public Mahasiswa(String nama, String nim, double ipk){
        this.nama = nama;
        this.nim = nim;
        setIpk(ipk);
    }

    public String getNama(){
        return nama;
    }

    public String getNim(){
        return nim;
    }

    public double getIpk(){
        return ipk;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public void setIpk(double ipk){
        if(ipk >= 0.0 && ipk <= 4.0){
            this.ipk = ipk;
        }else{
            System.out.println("Tidak valid");
        }
    }

    public void tampilkanData(){
        // System.out.println("Nama : " + nama + " | NIM : " + nim + " | IPK :" + ipk);
        System.out.println("Nama: " + nama);
        System.out.println("NIM: "+ nim);
        System.out.println("IPK: " + ipk);
    }
}

public class Main {
    public static void main(String[] args){
        Mahasiswa mh1 = new Mahasiswa("Edwin","013", 3.20);
        Mahasiswa mh2 = new Mahasiswa("Devi", "015", 3.02);
        Mahasiswa mh3 = new Mahasiswa("Maria", "023", 5.5);

        // System.out.println("Nama : " + mh1.getNama() + " | NIM : " + mh1.getNim() + " | IPK :" + mh1.getIpk());
        // System.out.println(mh2);
        // mh3.setNama("Lidia");
        mh3.tampilkanData();
    }
}

