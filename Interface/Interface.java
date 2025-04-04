// Interface
interface Kendaraan {
    void bergerak();
    void berhenti();   
}

// class yang mengimplementasikan Interface
class Mobil implements Kendaraan{
    @Override
    public void bergerak(){
        System.out.println("Mobil bergerak dengan roda.");
    }

    @Override
    public void berhenti(){
        System.out.println("Mobil berhenti");
    }
}

// class utama

class Main {
    public static void main(String[] args){
        Kendaraan mobil = new Mobil();
        mobil.bergerak();
        mobil.berhenti();
    }
}