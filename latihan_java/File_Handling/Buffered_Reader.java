
package latihan_java.File_Handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Buffered_Reader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("latihan_java/File_Handling/lorem_ipsum.txt"));
            String line;
            String data = "";
            while((line = reader.readLine()) != null){
                data += line + "\n";
            }
            
            // hitung jumlah baris
            String[] splitRow = data.split("\\n");
            int countRow = splitRow.length;

            // hitung jumlah kata
            String[] splitWord = data.split("\\s");
            int countWord = splitWord.length;
            
            // hitung jumlah karakter
            int countChar = data.length();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
