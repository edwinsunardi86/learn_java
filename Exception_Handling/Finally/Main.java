public class Main {
    public static void main(String[] args){
        try {
            int hasil = 10 / 2;
            System.out.println("Hasil: "+ hasil);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("BLok finally selalu dijalankan");
        }
    }
}