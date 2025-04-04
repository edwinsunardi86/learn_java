import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList<String> nama = new LinkedList<>();

        // Menambahkan element
        nama.add("Andi");
        nama.add("Budi");
        nama.add("Cici");

        //menambahkan di awal dan terakhir
        nama.addFirst("Zara");
        nama.addLast("Dina");

        // Menampilkan isi
        System.out.println("Isi LinkedList: ");
        for(String n : nama){
            System.out.println(n);
        }

        //Menghapus elemen
        nama.removeFirst();
        nama.removeLast();

        System.out.println("\nSetelah penghapusan:");
        System.out.println(nama);

    }
}
