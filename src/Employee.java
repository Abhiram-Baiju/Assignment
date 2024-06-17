//3. Implement a simple class hierarchy with a base class 'Employee' and derived classes 'Engineer'
//and 'Manager'. Use method overriding to display different details for each class.
public class Employee {
    void name(){
        System.out.println("Employee name");

    }
    void id(){
        System.out.println(" Employee id");
    }

}
class Engineer{
    void name(){
        System.out.println("Engineer name");

    }
    void id(){
        System.out.println("Engineer id");

    }

}
class Manager{
    void name(){
        System.out.println("Manager name");
    }
    void id(){
        System.out.println("Manager id");

    }
}
class call{
    public static void main(String[] args) {
        Engineer C = new Engineer();
        Manager M = new Manager();
        C.name();
        C.id();
        M.name();
        M.id();
    }
}
