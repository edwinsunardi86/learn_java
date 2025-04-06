package LambdaExpression.Halo;
interface Halo {
    void sapa(String nama);
}

public class Main {
    public static void main(String[] args){
        // Halo h = new Halo(){
        //     public void sapa(String nama) {
        //         System.out.println("Halo " + nama);
        //     }
        // };
        Halo h = (nama) -> System.out.println("Halo " + nama);
        h.sapa("Budi");
    }
}
