class Kalkulator
{
    //overloading method tambah
    public int tambah(int a, int b){
        return a + b;
    }

    public double tambah(double a, double b){
        return a + b;
    }

    public int tambah(int a, int b, int c){
        return a + b + c;
    }
}

//class utama

class Main
{
    public static void main(String[] args){
        Kalkulator kalkulator = new Kalkulator();
        System.out.println(kalkulator.tambah(5,2));
        System.out.println(kalkulator.tambah(5.242,2.343));
        System.out.println(kalkulator.tambah(6,3,1));
    }
}