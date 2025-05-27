package latihan_java.Exception_Handling;

public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int[] data = { 1,3,4,5,6,7,8,9,10};
            System.out.print(data[12]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            String angka = null;
            System.out.println(angka.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
