import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args){
        try {
            File file = new File("data.text");
            if( file.createNewFile()){
                System.out.println("File berhasil dibuat: "+ file.getName());
            }else{
                System.out.println("File sudah ada.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi error:" + e.getMessage());
        }
    }
}