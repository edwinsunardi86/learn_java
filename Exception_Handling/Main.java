public class Main {
    public static void main(String[] args){
        // Pembagian bilangan
        try {
            int hasil = 10 / 0;
            System.out.println("Hasil: "+ hasil);   
        } catch(ArithmeticException e){
            System.out.println("Terjadi error: " + e.getMessage());
        }

        System.out.println("Program tetap lanjut");

        // Array index out of bounds
        try {
            int[] data = {1, 2, 3};
            System.out.println(data[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Kesalahan index array: " + e.getMessage());
        }
    }
}