package latihan_java.Java_Collection_Framework.Set.TreeSet;

import java.util.Scanner;
import java.util.TreeSet;

class DataPeserta{
    private static TreeSet<String> daftarPeserta = new TreeSet<>();
    public static void menuInput(){
        Scanner scanner = new Scanner(System.in);
        
        boolean backToInputName = true;
        
        while(backToInputName){
            clearScreen();
            System.out.print("Input nama peserta : ");
            String namaPeserta = scanner.nextLine();

            System.out.print("Apakah anda ingin input kembali? (y/n)");
            String inputAgain = scanner.nextLine();

            daftarPeserta.add(namaPeserta);
            if(inputAgain.equalsIgnoreCase("n")){
                    backToInputName = false;
            }
        }
    }

    public static void menuDataPeserta(){
        Scanner scanner = new Scanner(System.in);
        boolean isShow = true;
        while(isShow){
            System.out.println(daftarPeserta);
            System.out.print("Apakah anda sudah bosan?(y/n)");
            String itsBoring = scanner.nextLine();
            if(itsBoring.equalsIgnoreCase("y")){
                isShow = false;
            }
        }
    }

    static void clearScreen() {
        for (int i = 0; i < 50; i++) System.out.println(); // simulasi clear
    }
}
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearScreen();
            System.out.println("-----------MENU------------");
            System.out.println("1. Input Nama Peserta");
            System.out.println("2. Tampilkan Daftar Peserta");
            System.out.print("Pilih Menu No :");
            int menu = scanner.nextInt();
            if(menu == 1){
                DataPeserta.menuInput();
            }else if(menu == 2){
                DataPeserta.menuDataPeserta();
            }
        }
    }

    static void clearScreen() {
        for (int i = 0; i < 50; i++) System.out.println(); // simulasi clear
    }
}
