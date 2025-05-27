package latihan_java.Java_Collection_Framework.Map.LinkedHashMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

    class LRUCache {
        private final int limit;
        private int count = 1;
        
        public LRUCache(int limit){
            this.limit = limit;
        }

        LinkedHashMap<Object, Object> cache = new LinkedHashMap<>();

        private boolean isAllowedType(Object data){
            return data instanceof Integer || data instanceof String;
        }
        
        public void put(Object key, Object value){
            
            if(isAllowedType(key) && isAllowedType(value)){
                
                cache.put(key, value);
                

                if(count > limit){
                    Object firstKey = cache.entrySet().iterator().next().getKey();
                    cache.remove(firstKey);
                }

                count = count + 1;

            }
            else
            {
                throw new IllegalArgumentException("Hanya String dan Integer");
            }
        }

        public void show(){
            cache.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }

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
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Masukan kalimat untuk frekuensi karakter: ");
                String words = scanner.nextLine();
                
                //char
                LinkedHashMap<String,Integer> frequencyChar = frequencyChar(words);
                // System.out.println(frequencyChar(words));
                // frequencyChar.forEach((key,value) -> System.out.println(key + " : " + value));
                // Step 1: Convert entrySet jadi List dan sort by value desc
                List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyChar.entrySet());
                entryList.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));
                // Step 2: Masukkan ke LinkedHashMap baru untuk menjaga urutan
                LinkedHashMap<String, Integer> descFrequencyChar = new LinkedHashMap<>();
                for(Map.Entry<String,Integer> entry : entryList){
                    descFrequencyChar.put(entry.getKey(), entry.getValue());
                }

                // Cetak hasil
                for(Map.Entry<String, Integer> entry : descFrequencyChar.entrySet()){
                    System.out.println(entry.getKey() + " => " + entry.getValue());
                }

                // //word
                // LinkedHashMap<String,Integer> mapWords = frequencyWord(words);
                // System.out.println(mapWords);
                // mapWords.forEach((key, value) -> System.out.println(key + " : " + value));
                
                // LRUCache
                // System.out.print("Masukan jumlah limit cache: ");
                // int count = scanner.nextInt();
                // scanner.nextLine();
                // LRUCache lruCache = new LRUCache(count);
                
                // System.out.print("Jumlah store data yang dimasukan: ");
                // int countStoreData = scanner.nextInt();
                // scanner.nextLine();
                
                // for(int i = 1; i <= countStoreData; i++){
                //     System.out.println("Store data ke-" + i);
                //     System.out.print("Masukan key : ");
                //     int key = scanner.nextInt();
                //     scanner.nextLine();
                //     System.out.print("Masukan value : ");
                //     String value = scanner.nextLine();
                //     lruCache.put(key, value);
                // }
                
                // lruCache.show();
            }
        }
    }
