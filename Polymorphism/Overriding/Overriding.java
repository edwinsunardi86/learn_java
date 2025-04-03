// Superclass (Mobil)
class Mobil {
    protected String merk;

    public Mobil(String merk){
        this.merk = merk;
    }

    // Method yang akan di-override
    public void suara(){
        System.out.println(merk + " berbunyi: Brooom Broom...");
    }
}

//Subclass (MobilSport)
class MobilSport extends Mobil {
    public MobilSport(String merk){
        super(merk);    
    }

    //overriding method suara()
    @Override
    public void suara(){
        System.out.println(merk + " berbunyi: VROOOOOM");
    }
}

class Main{
    public static void main(String[] args){
        Mobil mobilBiasa = new Mobil("Toyota");
        MobilSport ferrari = new MobilSport("Ferrari");

        mobilBiasa.suara();
        ferrari.suara(); 
    }
}