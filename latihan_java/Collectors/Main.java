package latihan_java.Collectors;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Pegawai {
    private String name;
    private String department;
    private int salary;
    public Pegawai(String name, String department, int salary){
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

    public int getSalary(){
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return name +  " - " + department + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Pegawai> pegawaiList = List.of(
            new Pegawai("Edwin","IT",7000),
            new Pegawai("Yudi", "Sales", 4000),
            new Pegawai("Chintia", "Legal", 4500),
            new Pegawai("Yanti", "GA", 3000),
            new Pegawai("Nadya","Audit",10000),
            new Pegawai("Radith","IT",5000),
            new Pegawai("Merry", "Sales", 4000),
            new Pegawai("Yuniar", "Legal", 2500),
            new Pegawai("Mantis", "GA", 6000),
            new Pegawai("Ceppy","Audit",1000)
            );
        Map<String,List<Pegawai>> groupDepartment = pegawaiList.stream().collect(Collectors.groupingBy(n -> n.getDepartment()));
        // System.out.println(groupDepartment);
        Map<String,Double> avgSalaryPerDepartment = pegawaiList.stream().collect(Collectors.groupingBy(n->n.getDepartment(),Collectors.averagingDouble(n -> n.getSalary())));
        
        Map<String, Optional<Pegawai>> maxPerDepartment= pegawaiList.stream().collect(Collectors.groupingBy(n -> n.getDepartment(), Collectors.reducing((m1, m2) -> m1.getSalary() > m2.getSalary() ? m1 : m2)));

        String strNamePegawai = pegawaiList.stream().map(m -> m.getName()).collect(Collectors.toList()).stream().collect(Collectors.joining(", "));
        
        Map<Boolean,List<Pegawai>> groupSalary = pegawaiList.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 6000));
        System.out.println(groupSalary);

    }
}
