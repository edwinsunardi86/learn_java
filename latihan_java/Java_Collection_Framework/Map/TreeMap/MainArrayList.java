package latihan_java.Java_Collection_Framework.Map.TreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class MainArrayList {

    public static TreeMap<String,Integer> frequencyChar(String word){
        TreeMap<String,Integer> mapChars = new TreeMap<>();
        char[] arrChar = word.toCharArray();

        for(char ch : arrChar){
            String strChar = String.valueOf(ch);
            boolean isExist = false;
            for(String key : mapChars.keySet()){
                if(key.equalsIgnoreCase(strChar)){
                    mapChars.put(key, mapChars.get(key) + 1);
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                mapChars.put(strChar,1);
            }
        }

        return mapChars;
    }

    public static TreeMap<String, Integer> frequencyWord(String[] arrWord){
        TreeMap<String, Integer> mapWords = new TreeMap<>();

        for(String word : arrWord){
            boolean isExist = false;
            for(String key : mapWords.keySet()){
                if(key.equalsIgnoreCase(word)){
                    mapWords.put(word, mapWords.get(key) + 1);
                    isExist = true;
                    break;
                }
            }

            if(!isExist){
                mapWords.put(word, 1);
            }
        }

        return mapWords;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // // word 
        // System.out.print("Input word: ");
        // String word = scanner.nextLine();
        // TreeMap<String, Integer> mapChars = frequencyChar(word);
        // mapChars.forEach((key,value) -> System.out.println(key + " : " + value));

        // // sales
        // String[] sales = {"apple", "banana", "apple", "orange", "banana", "apple"};
        // TreeMap<String,Integer> frequencyWords = frequencyWord(sales);
        // frequencyWords.forEach((key,value) -> System.out.println(key + " : " +value));

        // Nilai Mahasiswa
        Map<String, Integer> nilaiMahasiswa = new TreeMap<>();
        System.out.print("Jumlah mahasiswa : ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= jumlahMahasiswa; i++){
            System.out.print("Nama Mahasiswa : ");
            String nama = scanner.nextLine();

            System.out.print("Nilai : ");
            int nilai = scanner.nextInt();
            scanner.nextLine();

            nilaiMahasiswa.put(nama,nilai);
        }

        // nilaiMahasiswa.forEach((key, value) -> System.out.println(key + " : " + value));

        List<Map.Entry<String, Integer>> listSortHighest = new ArrayList<>(nilaiMahasiswa.entrySet());
        listSortHighest.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));
        //opsi
        // listSortHighest.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        System.out.println("Rank Tertinggi: ");
        for(Map.Entry<String, Integer> highest : listSortHighest){
            System.out.println(highest.getKey() +" : "+ highest.getValue());
        }
    }
}
