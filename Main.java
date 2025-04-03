class Mobil {
    String merk;
    int tahun;

    // Constructor
    public Mobil(String merk, int tahun) {
        this.merk = merk;
        this.tahun = tahun;
    }

    // Method
    public void info() {
        System.out.println("Mobil: " + merk + ", Tahun: " + tahun);
    }
}

// Class utama dengan method main()
public class Main {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", 2022);
        mobil1.info();
    }
}
