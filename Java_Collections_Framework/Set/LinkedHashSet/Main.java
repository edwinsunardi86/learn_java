import java.util.LinkedHashSet;

public class Main{
    public static void main(String[] args){
        LinkedHashSet<String> warna = new LinkedHashSet<>();
        warna.add("Merah");
        warna.add("Biru");
        warna.add("Hijau");
        warna.add("Merah");

        for(String b:warna) {
            System.out.println(b);
        }
    }
}