import java.io.FileWriter;
import java.io.IOException;

public class OverWrite {
    public static void main(String[] args){
        try {
            FileWriter writer = new FileWriter("data.text",true);
            writer.write("Hallo Dunia!\nBelajar Java itu seru!");
            writer.close();
            System.out.println("Berhasil menulis ke file");
        } catch (IOException e){
            System.out.println("Gagal menulis: " + e.getMessage());
        }
    }
}
