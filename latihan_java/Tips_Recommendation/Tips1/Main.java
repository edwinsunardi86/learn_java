package latihan_java.Tips_Recommendation.Tips1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pegawai {
    private String name;
    private String department;
    private double salary;

    public Pegawai(String name, String department, Double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public double getSalary(){
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String infoPegawai(){
        return name + " - " + department + " - " + salary;
    }
}
public class Main {
    public static void main(String[] args){
        
        List<Pegawai> pegawai = List.of(
            new Pegawai("Edwin","IT",78000.00),
            new Pegawai("Rudi","Sales",68000.00),
            new Pegawai("Yanti","Audit",45000.00),
            new Pegawai("Supri","Legal",55000.00),
            new Pegawai("Ranggi","AR",65500.00)
        );
        
        List<String> names = pegawai.
    }
}
