class Mobil {
    private String merk;
    private int tahun;

    // Constructor
    public Mobil(String merk, int tahun){
        this.merk = merk;
        this.tahun = tahun;
    }

    // Getter
    public String getMerk(){
        return merk;
    }

    public int getTahun(){
        return tahun;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setTahun(int tahun){
        if (tahun > 1885) {
            this.tahun = tahun;
        } else {
            System.out.println("Tahun tidak valid");
        }
    }

    public void info(){
        System.out.println("Mobil: " + merk + ", Tahun: " + tahun);
    }
}

// Class utama
class Main {
    public static void main(String[] args){
        
        Mobil mobil1 = new Mobil("Toyota", 2022);

        System.out.println("Merk :" + mobil1.getMerk());

        // Menggunakan setter untuk mengubah nilai
        mobil1.setMerk("Honda");
        mobil1.setTahun(2020);

        // Menampilkan info mobil
        mobil1.info();
    }
}