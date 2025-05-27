package Java_Collections_Framework.Map.LinkedHashMap;
import java.util.LinkedHashMap;

public class Main{
    public static void main(String[] args){
        LinkedHashMap<Integer, String> mahasiswa = new LinkedHashMap<>();

        mahasiswa.put(103,"Yanti");
        mahasiswa.put(101,"Tiyara");
        mahasiswa.put(102,"Nenenk");

        for(Integer nim : mahasiswa.keySet()){
            System.out.println("NIM: "+ nim + ", Nama: " + mahasiswa.get(nim));
        }   
    }
}