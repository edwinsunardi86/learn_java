// Abstract class
abstract class Kendaraan {
    protected String merk;
    public Kendaraan(String merk){
        this.merk = merk;
    }

    // Method abstrak (tanpa implementasi)
    public abstract void bergerak();

    // Method biasa (dengan implementasi)
    public void info() {
        System.out.println("Merk Kendaraan: " + merk);
    }
}

class Mobil extends Kendaraan {
    public Mobil(String merk){
        super(merk);
    }

    @Override
    public void bergerak(){
        System.out.println(merk + " bergerak dengan roda.");
    }
}

class Pesawat extends Kendaraan {
    public Pesawat(String merk){
        super(merk);
    }

    @Override
    public void bergerak(){
        System.out.println(merk + " terbang di udara.");
    }
}

class Main {
    public static void main(String[] args){
        Kendaraan mobil = new Mobil("Toyota");
        Kendaraan pesawat = new Pesawat("Boeing");

        mobil.info();
        mobil.bergerak();

        pesawat.info();
        pesawat.bergerak();
    }    
} 