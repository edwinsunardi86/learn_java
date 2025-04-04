import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        // membuat object arrayList
        ArrayList<Integer> noUrut = new ArrayList<>();

        // menambahkan elemen
        for(int i = 1; i <= 50; i++){
            noUrut.add(i);    
        }

        // menambahkan beberapa elemen yang pernah dibuat berarti List bisa diduplikat
        noUrut.add(3);
        noUrut.add(5);
        noUrut.add(20);

        // Sort secara ascending (menaik)
        // Collections.sort(noUrut);

        // Sebelumnya harus di sort dulu lalu reserve
        //Collections.reverse(noUrut);

        // lambda expression untuk descending
        noUrut.sort((a, b) -> b - a);

        // Hapus salah satu element
        noUrut.remove(2);

        for (int no: noUrut){
            System.out.println(no);
        }
    }   
}
