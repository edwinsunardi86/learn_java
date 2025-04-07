package Stream_API;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        List<Integer> angka = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> nama = Arrays.asList("budi", "Siska", "rudi", "santi", "andri", "citra");
        // Filter
        angka.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // Map (biasanya untuk mengubah isi data)
        nama.stream().map(n -> n.toUpperCase()).forEach(System.out::println);

        // Reduce (Menggabungkan nilai jadi satu (akumulasi))
        int total = angka.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Total: " + total);

        // Collect() (Mengubah stream menjadi list lagi)
        List<String> kapital = nama.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(kapital);

        // Kombinasi filter + map + collect
        List<String> hasil = nama.stream().filter(n -> n.startsWith("b")).map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(hasil);

        // Count() (Menghitung element setelah filter)
        long jumlahGenap = angka.stream().filter(n -> n % 2 == 0).count();
        System.out.println(jumlahGenap);

        // Stream dari angka
        int totalSum = IntStream.range(1, 6).sum();
        System.out.println("Total: " + totalSum);
    }
}
