    package Abstraction;

    import java.util.Arrays;
    import java.util.List;

    abstract class Kendaraan {
        private String merek;
        
        public Kendaraan(String merek){
            this.merek = merek;
        }

        public void info(){
            System.out.println("Merek :" + merek);
        }
        public abstract void bunyi();
    }

    class Mobil extends Kendaraan {
        public Mobil(String merek){
            super(merek);
        }

        @Override
        public void bunyi(){
            System.out.println("Mobil: Vroooom!");
        }
    }

    class Motor extends Kendaraan {
        public Motor(String merek){
            super(merek);
        }

        @Override
        public void bunyi(){
            System.out.println("Motor: Ngeeng Ngeeng!");
        }
    }

    public class Main {
        public static void main(String[] args){
            List<Kendaraan> kendaraan = Arrays.asList(new Mobil("Toyota"), new Motor("Honda"));
            kendaraan.forEach(n -> {
                n.info();
                n.bunyi();
                System.out.println();
            });
        }
    }
