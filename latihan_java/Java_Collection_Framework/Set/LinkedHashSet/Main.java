package latihan_java.Java_Collection_Framework.Set.LinkedHashSet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        // // Soal 1
        // String numbers = "1 2 3 4 3 5 6 7 7 8 9 8 9 10";
        // String[] arrNumber = numbers.split("\\s+");
        // Set<Integer> numberUnique = new LinkedHashSet<>();
        // for(String num : arrNumber){
        //     numberUnique.add(Integer.valueOf(num));
        // }
        // System.out.println(numberUnique);

        // // opsi ke 2
        // System.out.println(String.join(" ", numberUnique.stream()
        // .map(String::valueOf)
        // .toArray(String[]::new)));

        // // Soal 2
        // String words = "saya makan nasi dan saya minum air";
        // String[] arrWord = words.split("\\s+");
        // Set<String> wordUnique= new LinkedHashSet<>();
        // String firstWordDuplicate = "";
        
        // for(String word : arrWord){
        //     boolean isExist = false;
            
        //     for(String setString : wordUnique){
        //         if (setString.equalsIgnoreCase(word)) {
        //             isExist = true;
        //             firstWordDuplicate = word;
        //             break;
        //         }
        //     }

        //     if(!isExist){
        //         wordUnique.add(word);
        //     }else{
        //         break;
        //     }
        // }
        
        // System.out.println("Kata duplicate pertama: " + firstWordDuplicate);

        // // Soal 3
        // String words1 = "Saya suka makan ayam goreng dan saya suka minum sprite";
        // String words2 = "Dia makan ayam rebus";

        // String[] arrWords1 = words1.split("\\s+");
        // String[] arrWords2 = words2.split("\\s+");

        // List<String>arrDuplicateWord1 = new ArrayList<>();
        // List<String>arrDuplicateWord2 = new ArrayList<>();
        // List<String>arrDuplicateWord12 = new ArrayList<>();

        // Set<String> wordUnique1 = new LinkedHashSet<>();
        // Set<String> wordUnique2 = new LinkedHashSet<>();

        // for(String word : arrWords1){
        //     boolean isExist = false;
        //     for(String el : wordUnique1){
        //         if(el.equalsIgnoreCase(word)){
        //             arrDuplicateWord1.add(word);
        //             isExist = true;
        //             break;
        //         }
        //     }
        //     if(!isExist){
        //         wordUnique1.add(word);
        //     }
        // }

        // for(String word : arrWords2){
        //     boolean isExist = false;
        //     for(String el : wordUnique2){
        //         if(el.equalsIgnoreCase(word)){
        //             arrDuplicateWord2.add(word);
        //             isExist = true;
        //             break;
        //         }
        //     }
        //     if(!isExist){
        //         wordUnique2.add(word);
        //     }
        // }

        // System.out.println(arrDuplicateWord1);
        // System.out.println(arrDuplicateWord2);

        // for(String el1 : wordUnique1){
        //     for(String el2 : wordUnique2){
        //         if(el1.equalsIgnoreCase(el2)){
        //             arrDuplicateWord12.add(el2);
        //         }
        //     }
        // }

        // System.out.println(arrDuplicateWord12);
        // String hasilDuplicate = String.join(" ",arrDuplicateWord12);
        // System.out.println(hasilDuplicate);


        int[] arrNumbers = {1,2,3,4,4,5,6,6,6,7,8,9,10,10};
        List<Integer> listNumbers = Arrays.stream(arrNumbers).boxed().collect(Collectors.toList()); // arrNumbers tersebut dikemas dahulu kedalam Integer baru ditampung kedalam Object List
        Set<Integer> setNumber = new LinkedHashSet<>(listNumbers);


        List<Map.Entry<String,Integer>> listMapNilai = Arrays.asList(Map.entry("Edwin", 30), Map.entry("Rina", 45), Map.entry("Yudi", 60));
        //opsi 1
        // List<Integer> listNilai = new ArrayList<>();
        // Set<List<Integer>> setNilai = new LinkedHashSet<>();
        // for(Map.Entry<String,Integer> nilai : listMapNilai){
        //     System.out.println(nilai.getValue());
        //     listNilai.add(nilai.getValue());
        // }
        // setNilai.add(listNilai);

        //opsi 2
        List<Integer> listNilai = listMapNilai.stream().map(Map.Entry::getValue).collect(Collectors.toList());
        // Set<List<Integer>> setListNilai = Set.of(listNilai);
        Set<List<Integer>> setListNilai = new LinkedHashSet<>();
        setListNilai.add(listNilai);
        System.out.println(setListNilai);
    }
}
