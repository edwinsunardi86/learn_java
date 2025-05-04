package latihan_java.Java_Collection_Framework.Vector;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> students = new Vector<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan jumlah siswa: ");
        int countSiswa = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < countSiswa; i++){
            System.out.print("Tambah siswa: ");
            String namaSiswa = scanner.nextLine();
            students.add(namaSiswa);
        }

        System.out.println("Daftar Siswa");
        
        for(String siswa : students){
            System.out.println(" - " + siswa);
        }

        System.out.print("Nama siswa yang ingin dihapus:");
        String removeStudent = scanner.nextLine();

        boolean isDeleted = false;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).equalsIgnoreCase(removeStudent)){
                students.remove(i);
                isDeleted = true;
            }
        }

        if(isDeleted){
            System.out.println("Siswa yang bernama " + removeStudent + " sudah dihapus.");
        }else{
            System.out.println("Tidak ada nama " + removeStudent + "sebagai siswa.");
        }
    }
}
