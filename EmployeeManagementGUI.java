import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementGUI {
    private static String[][] employees = new String[10][4]; // assuming max 10 employees
    private static int employeeCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Management");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        JLabel titleLabel = new JLabel("Employee Management System", SwingConstants.CENTER);
        frame.add(titleLabel);

        JButton addButton = new JButton("Add Employee");
        JButton removeButton = new JButton("Remove Employee");
        JButton displayButton = new JButton("Display Employees");
        JButton modifyButton = new JButton("Modify Employee");
        JButton exitButton = new JButton("Exit");

        frame.add(addButton);
        frame.add(removeButton);
        frame.add(displayButton);
        frame.add(modifyButton);
        frame.add(exitButton);

        // Add Employee
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (employeeCount < 10) {
                    JTextField idField = new JTextField();
                    JTextField nameField = new JTextField();
                    JTextField ageField = new JTextField();
                    JTextField salaryField = new JTextField();

                    Object[] inputFields = {
                            "Employee ID:", idField,
                            "Employee Name:", nameField,
                            "Employee Age:", ageField,
                            "Employee Salary:", salaryField
                    };

                    int option = JOptionPane.showConfirmDialog(frame, inputFields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        employees[employeeCount][0] = idField.getText();
                        employees[employeeCount][1] = nameField.getText();
                        employees[employeeCount][2] = ageField.getText();
                        employees[employeeCount][3] = salaryField.getText();
                        employeeCount++;
                        JOptionPane.showMessageDialog(frame, "Employee added successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Maximum number of employees reached!");
                }
            }
        });

        // Remove Employee
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeId = JOptionPane.showInputDialog(frame, "Enter Employee ID to remove:");

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
                    JOptionPane.showMessageDialog(frame, "Employee removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee not found!");
                }
            }
        });

        // Display Employees
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder employeeList = new StringBuilder("List of Employees:\n");
                for (int i = 0; i < employeeCount; i++) {
                    employeeList.append("ID: ").append(employees[i][0])
                            .append(", Name: ").append(employees[i][1])
                            .append(", Age: ").append(employees[i][2])
                            .append(", Salary: ").append(employees[i][3])
                            .append("\n");
                }
                JOptionPane.showMessageDialog(frame, employeeList.toString());
            }
        });

        // Modify Employee
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modifyId = JOptionPane.showInputDialog(frame, "Enter Employee ID to modify:");

                boolean foundModify = false;
                for (int i = 0; i < employeeCount; i++) {
                    if (employees[i][0].equals(modifyId)) {
                        JTextField nameField = new JTextField(employees[i][1]);
                        JTextField ageField = new JTextField(employees[i][2]);
                        JTextField salaryField = new JTextField(employees[i][3]);

                        Object[] modifyFields = {
                                "New Employee Name:", nameField,
                                "New Employee Age:", ageField,
                                "New Employee Salary:", salaryField
                        };

                        int option = JOptionPane.showConfirmDialog(frame, modifyFields, "Modify Employee", JOptionPane.OK_CANCEL_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            employees[i][1] = nameField.getText();
                            employees[i][2] = ageField.getText();
                            employees[i][3] = salaryField.getText();
                            JOptionPane.showMessageDialog(frame, "Employee modified successfully!");
                        }
                        foundModify = true;
                        break;
                    }
                }
                if (!foundModify) {
                    JOptionPane.showMessageDialog(frame, "Employee not found!");
                }
            }
        });

        // Exit Application
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
