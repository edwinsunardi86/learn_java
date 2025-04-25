package latihan_java.Java_Collection_Framework.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListName {
    private final List<String> arrName = new ArrayList<>();

    public void insertList(String name){
        arrName.add(name);
    }

    public void getName(String name){
        // var isExists = arrName.contains(name);
        var isExists = false;

        for(int i = 0; i < arrName.size(); i++){
            if(arrName.get(i).equalsIgnoreCase(name)){
                isExists = true;
                break;
            }
        }

        if(isExists){
            System.out.println(name +" ditemukan di dalam daftar");
        }else{
            System.out.println("Tidak terdaftar");
        }
    }

    public void removeName(String name){
        // Case Sensitive
        // var isDeleted = arrName.remove(name);

        boolean isDeleted = false;

        for(int i = 0; i < arrName.size(); i++){
            if(arrName.get(i).equalsIgnoreCase(name)){
                arrName.remove(i);
                isDeleted = true;
                break;
            }
        }
        if(isDeleted){
            System.out.println(name + " berhasil dihapus");
        }else{
            System.out.println(name + " tidak terdaftar");
        }
    }

    public void showNames(){
        for(int i = 0; i < arrName.size(); i++){
            System.out.println((i+1) + ". " + arrName.get(i));
        }
    }
}

public class Main{
    public static void main(String[] args){
        ListName listName = new ListName();
        // ArrayList<String> arrName = new ArrayList<>();
        // Scanner scanner = new Scanner(System.in);
        // for(int i = 1; i <= 5; i++){
        //     System.out.print("Masukan Nama ke-" + i + ": ");
        //     String name = scanner.nextLine();
        //     arrName.add(name);
        // }

        // Kalau mau jumlah nama tidak flexible
        // while (true) {
        //     System.out.print("Masukkan nama (ketik 'selesai' untuk berhenti): ");
        //     String name = scanner.nextLine();
        //     if (name.equalsIgnoreCase("selesai")) break;
        //     arrName.add(name);
        // }
        // scanner.close();

        try ( 
            Scanner scanner = new Scanner(System.in)
        ){
            System.out.println("Daftar Nama : ");
            for(int i = 1; i <= 5; i++){
                System.out.print("Masukan Nama ke-" + i + ": ");
                String name = scanner.nextLine();
                listName.insertList(name);
            }
            listName.showNames();

            System.out.print("Cari nama yang bersangkutan: ");
            String findName = scanner.nextLine();

            listName.getName(findName);
            
            System.out.print("Nama yang ingin dihapus: ");
            String removeName = scanner.nextLine();

            listName.removeName(removeName);
            listName.showNames();

            scanner.close();
        }
            
    }
}

