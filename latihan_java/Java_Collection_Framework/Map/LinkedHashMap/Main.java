package latihan_java.Java_Collection_Framework.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Scanner;

    public class Main {
        // LinkedHashMap<String, Integer>
        public static LinkedHashMap<String, Integer> frequencyChar(String words){
            char[] arrChars = words.toCharArray();
            LinkedHashMap<String,Integer> mapChars = new LinkedHashMap<>();
            for(char ch: arrChars){
                if(ch != ' '){
                    
                    boolean isExist = false;
                    String strChar = String.valueOf(ch);

                    for(String key : mapChars.keySet()){
                        if(key.equalsIgnoreCase(strChar)){
                            mapChars.put(key, mapChars.get(key) + 1);
                            isExist = true;
                            break;
                        }
                    }

                    if(!isExist){
                        mapChars.put(String.valueOf(ch),1);
                    }
                }
            }
            return mapChars;    
        }

        public static LinkedHashMap<String, Integer> frequencyWord (String words){
            String[] arrWords = words.split(" ");
            LinkedHashMap<String, Integer> mapWords = new LinkedHashMap<>();
            for(String word : arrWords){
                boolean isExist = false;
                
                for(String key : mapWords.keySet()){
                    if(key.equalsIgnoreCase(word)){
                        mapWords.put(key, mapWords.get(key) + 1);
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
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukan kalimat untuk frekuensi karakter: ");
            String words = scanner.nextLine();
            
            // LinkedHashMap<String,Integer> frequencyChar = frequencyChar(words);
            // System.out.println(frequencyChar(words));
            // frequencyChar.forEach((key,value) -> System.out.println(key + " : " + value));
            LinkedHashMap<String,Integer> mapWords = frequencyWord(words);
            System.out.println(mapWords);
            mapWords.forEach((key, value) -> System.out.println(key + " : " + value));

        }
    }
