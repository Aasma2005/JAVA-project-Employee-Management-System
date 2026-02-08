import java.util.*;

class Employee {

    String name;
    long id;
    String designation;
    int experience;
    int age;

    // Constructor
    Employee(String name, long id, String designation, int experience, int age) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.experience = experience;
        this.age = age;
    }
}

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> empList = new ArrayList<>();

    // Insert Employee
    static void insertEmployee() {
        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Employee ID: ");
        long id = sc.nextLong();

        System.out.print("Enter Designation: ");
        String designation = sc.next();

        System.out.print("Enter Experience: ");
        int exp = sc.nextInt();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        empList.add(new Employee(name, id, designation, exp, age));
        System.out.println("✅ Employee Added Successfully\n");
    }

    // Search Employee
    static void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        long id = sc.nextLong();

        for (Employee e : empList) {
            if (e.id == id) {
                System.out.println("\nEmployee Found");
                System.out.println("Name: " + e.name);
                System.out.println("ID: " + e.id);
                System.out.println("Designation: " + e.designation);
                System.out.println("Experience: " + e.experience);
                System.out.println("Age: " + e.age + "\n");
                return;
            }
        }
        System.out.println("❌ Employee Not Found\n");
    }

    // Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to Delete: ");
        long id = sc.nextLong();

        Iterator<Employee> it = empList.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.id == id) {
                it.remove();
                System.out.println("✅ Employee Deleted Successfully\n");
                return;
            }
        }
        System.out.println("❌ Employee Not Found\n");
    }

    // Display All Employees
    static void displayAll() {
        if (empList.isEmpty()) {
            System.out.println("❌ No Employees Available\n");
            return;
        }

        System.out.println("\nEmployee List:");
        for (Employee e : empList) {
            System.out.println("----------------------");
            System.out.println("Name: " + e.name);
            System.out.println("ID: " + e.id);
            System.out.println("Designation: " + e.designation);
            System.out.println("Experience: " + e.experience);
            System.out.println("Age: " + e.age);
        }
        System.out.println();
    }

    // Menu
    static void menu() {
        while (true) {
            System.out.println("------ Employee Management System ------");
            System.out.println("1. Insert Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    System.out.println("✅ Exiting Application");
                    return;
                default:
                    System.out.println("❌ Invalid Choice\n");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
