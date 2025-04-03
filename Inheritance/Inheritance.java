// Superclass (Induk)

class Mobil {
    protected String merk;
    protected int tahun;

    public Mobil(String merk, int tahun){
        this.merk = merk;
        this.tahun = tahun;
    }

    public void info(){
        System.out.println("Merk: " + merk + ", Tahun: " + tahun);
    }
}

// subclass (Anak) - Inherits from Mobil
class MobilSport extends Mobil {
    private int topSpeed;

    //constructor untuk MobilSport
    public MobilSport(String merk, int tahun, int topSpeed){
        super(merk, tahun);
        this.topSpeed = topSpeed;
    }

    public void showSpeed(){
        System.out.println(merk + " memiliki kecepatan maksimum " + topSpeed + "km/jam");
    }
}

//class Utama
class Main{
    public static void main(String[] args){
        MobilSport ferrari = new MobilSport("Ferrari", 2023, 350);

        ferrari.info(); // Memanggil method dari superclass;
        ferrari.showSpeed(); // Method dari subclass;
    }
}