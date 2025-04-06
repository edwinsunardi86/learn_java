import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        // Membuat HashMap
        HashMap<Integer, String> mahasiswa = new HashMap<>();
        mahasiswa.put(101, "Alice");
        mahasiswa.put(102, "Bob");
        mahasiswa.put(103, "Charlie");

        // Menampilkan HashMap
        System.out.println(mahasiswa);

        // Mengakseskan nilai berdasarkan Key
        System.out.println("Mahasiswa dengan NIM 102: " + mahasiswa.get(102));

        //Menghapus key-value
        mahasiswa.remove(101);
        System.out.println(mahasiswa);

        //Iterasi menggunakan for-Each
        for(Integer nim : mahasiswa.keySet()){
            System.out.println("NIM: " + nim + ", Nama: " + mahasiswa.get(nim));
        }
    }
}
