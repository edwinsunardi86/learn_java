import java.io.File;

public class DeleteFile {
    public static void main(String[] args){
        File file = new File("data.text");
        if (file.delete()) {
            System.out.println("File " + file.getName() + " berhasil dihapus.");
        }else{
            System.out.println("Gagal menghapus file");
        }
    }            
}
