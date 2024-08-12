import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String[][] employees = new String[10][4]; // assuming max 10 employees
        int employeeCount = 0;

        while (choice != 5) {
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Modify Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (employeeCount < 10) {
                        System.out.print("Enter Employee ID: ");
                        employees[employeeCount][0] = sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        employees[employeeCount][1] = sc.nextLine();
                        System.out.print("Enter Employee Age: ");
                        employees[employeeCount][2] = sc.nextLine();
                        System.out.print("Enter Employee Salary: ");
                        employees[employeeCount][3] = sc.nextLine();
                        employeeCount++;
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Maximum number of employees reached!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    String removeId = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < employeeCount; i++) {
                        if (employees[i][0].equals(removeId)) {
                            for (int j = i; j < employeeCount - 1; j++) {
                                employees[j] = employees[j + 1];
                            }
                            employeeCount--;
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 3:
                    System.out.println("List of Employees:");
                    for (int i = 0; i < employeeCount; i++) {
                        System.out.println("ID: " + employees[i][0] + ", Name: " + employees[i][1] + ", Age: " + employees[i][2] + ", Salary: " + employees[i][3]);
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID to modify: ");
                    String modifyId = sc.nextLine();
                    boolean foundModify = false;
                    for (int i = 0; i < employeeCount; i++) {
                        if (employees[i][0].equals(modifyId)) {
                            System.out.print("Enter new Employee Name: ");
                            employees[i][1] = sc.nextLine();
                            System.out.print("Enter new Employee Age: ");
                            employees[i][2] = sc.nextLine();
                            System.out.print("Enter new Employee Salary: ");
                            employees[i][3] = sc.nextLine();
                            foundModify = true;
                            System.out.println("Employee modified successfully!");
                            break;
                        }
                    }
                    if (!foundModify) {
                        System.out.println("Employee not found!");
                    }
                    break;
            }
        }
    }
}