import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        TreeSet<String> nama = new TreeSet<>();

        nama.add("Andi");
        nama.add("Cici");
        nama.add("Budi");
        nama.add("Andi");

        System.out.println("Isi TreeSet: ");
        for(String n : nama.descendingSet()){
            System.out.println(n);
        }
    }
}
