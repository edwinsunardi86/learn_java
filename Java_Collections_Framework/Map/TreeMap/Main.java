import java.util.TreeMap;
public class Main {
    public static void main(String[] args){
        TreeMap<Integer, String> mahasiswa = new TreeMap<>();

        mahasiswa.put(103, "Ani");
        mahasiswa.put(101, "Budi");
        mahasiswa.put(102, "Cici");     

        for(Integer nim : mahasiswa.keySet()){
            System.out.println("NIM: " + nim + ", Nama: " + mahasiswa.get(nim));
        }
    }
}