import java.util.Vector;

public class Main {
    public static void main(String[] args){
        Vector<String> nama = new Vector<>();

        // Menambahkan element
        nama.add("Andi");
        nama.add("Budi");
        nama.add("Cici");

        // Menyisipkan elemen di index tertentu
        nama.add(1, "Dina"); //masuk di index ke - 1

        // Menampilkan isi vector
        System.out.println("Isi vector");
        for (String n : nama) {
            System.out.println(n);
        }

        // Menghapus elemen
        nama.remove("Budi");

        System.out.println("\nSetelah penghapusan");
        System.out.println(nama);
    }
}