//Sorting Employees by Salary
// Write a program that stores a list of employees using an ArrayList and sorts them by their salary in descending order. Each employee has a name and a salary.
import java.util.*;
import java.util.Comparator;

class Employee1 {
    String name;
    int salary;

    public Employee1(String name, int salary) {
        this.name = name;
        this.salary = salary;

    }

    public String getname() {
        return name;

    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee - " + "name=" + name + ", Salary=" + salary;

    }
}
class Employeesalarycomparitor implements Comparator<Employee1> {
    @Override
    public int compare(Employee1 emp1, Employee1 emp2) {
        return Integer.compare(emp2.getSalary(), emp1.getSalary());
    }

    public static Comparator<Employee1> reverseOrder() {
        return Comparator.comparingInt(Employee1::getSalary).reversed();
    }
}
class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee1> obj_emp = new ArrayList<>();
        obj_emp.add(new Employee1("Hari", 20000));
        obj_emp.add(new Employee1("Akshay", 30000));
        obj_emp.add(new Employee1("Rahul", 17000));
        obj_emp.add(new Employee1("Ajith", 66000));

        Collections.sort(obj_emp, Employeesalarycomparitor.reverseOrder());


        System.out.println("Employee sorted list");
        for (Employee1 emp : obj_emp) {
            System.out.println(emp);
        }
    }

}
