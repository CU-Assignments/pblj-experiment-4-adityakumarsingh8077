import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Show All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    String salary = scanner.nextLine();
                    employees.add(id + " - " + name + " - " + salary);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    String updateId = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < employees.size(); i++) {
                        String[] details = employees.get(i).split(" - ");
                        if (details[0].equals(updateId)) {
                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter New Salary: ");
                            String newSalary = scanner.nextLine();
                            employees.set(i, updateId + " - " + newName + " - " + newSalary);
                            System.out.println("Employee updated successfully.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Remove: ");
                    String removeId = scanner.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < employees.size(); i++) {
                        String[] details = employees.get(i).split(" - ");
                        if (details[0].equals(removeId)) {
                            employees.remove(i);
                            System.out.println("Employee removed successfully.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Search: ");
                    String searchId = scanner.nextLine();
                    boolean foundEmp = false;
                    for (String emp : employees) {
                        String[] details = emp.split(" - ");
                        if (details[0].equals(searchId)) {
                            System.out.println("Employee Found: " + emp);
                            foundEmp = true;
                            break;
                        }
                    }
                    if (!foundEmp) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 5:
                    if (employees.isEmpty()) {
                        System.out.println("No employees available.");
                    } else {
                        System.out.println("Employee List:");
                        for (String emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
