import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        manege_system man = new manege_system();
        man.add_employee("A");
        man.add_employee("B");
        man.add_employee("C");
        man.print_info();
        man.remove_employee("B");
        man.print_info();

        man.add_employee("D");
        man.print_info();
    }
}

class employee{
    int age;
    String name;

    public employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public employee(String name){
        this.name = name;
        this.age = 20;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        employee other = (employee) obj;
        return age == other.age && Objects.equals(name, other.name);
    }
}

class manege_system{
    ArrayList<employee> employees;

    public manege_system(){
        this.employees = new ArrayList<employee>();
    }

    public void add_employee(String name) {
        this.employees.add(new employee(name));
    }

    public void remove_employee(String name){
        // find the employee
        for(employee emp : this.employees){
            if(emp.name.equals(name)){
                this.employees.remove(emp);
                break;
            }
        }
    }

    public void print_info(){
        // sort by alphabet
        this.employees.sort(Comparator.comparing(emp -> emp.name));
        //print current time
        System.out.println(
            new java.util.Date().toString()
        );
        for(employee emp : this.employees){
            System.out.println("-------------------");
            System.out.println("Age: "+emp.age);
            System.out.println("Name: "+emp.name);
        }
        System.out.println("-------------------");
    }
}