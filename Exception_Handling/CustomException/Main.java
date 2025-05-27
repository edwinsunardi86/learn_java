class UmurTidakValidException extends Exception {
    public UmurTidakValidException(String pesan){
        super(pesan);
    }
}

public class Main {
    static void cekUmur(int umur) throws UmurTidakValidException {
        if(umur < 0){
            throw new UmurTidakValidException("Umur tidak boleh negatif!");
        }else{
            System.out.println("Umur valid: " + umur);
        }

    }

    public static void main(String[] args){
        try {
            cekUmur(-5);
        }catch(UmurTidakValidException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}