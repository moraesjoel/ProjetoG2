package manager;

import entities.Employee;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Views.ModuleEmployeeActionsView.ConsultEmployeeView;
import Views.ModuleEmployeeActionsView.EditEmployeeView;
import Views.ModuleEmployeeActionsView.EmployeeEditMenuView;
import Views.ModuleEmployeeActionsView.InsertEmployeeView;
import Views.ModuleEmployeeActionsView.RemoveEmployeeView;
import Views.ModuleServiceActionsView.ConsultView;

public class EmployeeManager {

    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    static String employeeCpf;
    static String employeeName;
    static String employeeEmail;
    static String employeePhoneNumber;

    static Scanner reader = new Scanner(System.in);

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void insert() throws ParseException {
        Employee employee = new Employee();

        readAndSetEmployeeName(employee);

        readAndSetEmployeeCPF(employee);

        readAndSetEmployeePhoneNumber(employee);

        readAndSetEmail(employee);
        
        employeeList.add(employee);
        

    }
    
    public static void menuToEdit(Employee employee) throws ParseException {
        readAndSetEmployeeNameEdit(employee);

        readAndSetEmployeeCPFEdit(employee);

        readAndSetEmployeePhoneNumberEdit(employee);

        readAndSetEmailEdit(employee);
        
        consult();
    }

    public static void consult() {
        String employeeNameFromList = "";
    	//List<String> snl = new ArrayList<>();
        if(employeeList.isEmpty()) {
        	employeeNameFromList = "Lista de funcionarios vazia!";
        } else {
        	for (int i = 0; i < employeeList.size(); i++) {
                System.out.println("\nService: " + employeeList.get(i).getName());
                employeeNameFromList += "\n" + employeeList.get(i).getName() + " " + employeeList.get(i).getCpf() + " ";
                //snl.add(serviceList.get(i).getName());
            }
        }
        ConsultEmployeeView.labelTextConsult.setText(employeeNameFromList);
//        for (int j = 0; j < snl.size(); j++) {
//        	ConsultView.labelTextConsult.setText(snl.get(j));
//        }
        
    }

    public static void remove() {
        String cpfEmployeeToRemove = RemoveEmployeeView.textFieldEmployeeCpfToRemove.getText();

        removeCustomer(cpfEmployeeToRemove);

    }

    public static void edit() throws ParseException {
        String customerToEdit = EditEmployeeView.textFieldEmployeeCpfEdit.getText();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
            	menuToEdit(employeeList.get(i));
            }
        }
    }

    protected static void readAndSetEmployeeName(Employee employee) {
        employeeName = InsertEmployeeView.textFieldEmployeeName.getText();
        employee.setName(employeeName);
    }
    
    protected static void readAndSetEmployeeNameEdit(Employee employee) {
        employeeName = EmployeeEditMenuView.textFieldEmployeeName.getText();
        employee.setName(employeeName);
    }
    public static void editOnlyName() throws ParseException {
        String customerToEdit = EditEmployeeView.textFieldEmployeeCpfEdit.getText();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
            	readAndSetEmployeeNameEdit(employeeList.get(i));
            }
        }
    }

    protected static void readAndSetEmployeeCPF(Employee employee){
        employeeCpf = InsertEmployeeView.textFieldEmployeeCpf.getText();
        employee.setCpf(employeeCpf);
    }
    
    protected static void readAndSetEmployeeCPFEdit(Employee employee){
        employeeCpf = EmployeeEditMenuView.textFieldEmployeeCpf.getText();
        employee.setCpf(employeeCpf);
    }

    public static void editOnlyCpf() throws ParseException {
        String customerToEdit = EditEmployeeView.textFieldEmployeeCpfEdit.getText();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
            	readAndSetEmployeeCPFEdit(employeeList.get(i));
            }
        }
    }
    
    protected static void readAndSetEmployeePhoneNumber(Employee employee){
        employeePhoneNumber = InsertEmployeeView.textFieldEmployeePhone.getText();
        employee.setPhoneNumber(employeePhoneNumber);
    }
    
    protected static void readAndSetEmployeePhoneNumberEdit(Employee employee){
        employeePhoneNumber = EmployeeEditMenuView.textFieldEmployeePhone.getText();
        employee.setPhoneNumber(employeePhoneNumber);
    }
    
    public static void editOnlyPhoneNumber() throws ParseException {
        String customerToEdit = EditEmployeeView.textFieldEmployeeCpfEdit.getText();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
            	readAndSetEmployeePhoneNumberEdit(employeeList.get(i));
            }
        }
    }

    protected static void readAndSetEmail(Employee employee){
        employeeEmail = InsertEmployeeView.textFieldEmployeeEmail.getText();
        employee.setEmail(employeeEmail);
    }
    
    protected static void readAndSetEmailEdit(Employee employee){
        employeeEmail = EmployeeEditMenuView.textFieldEmployeeEmail.getText();
        employee.setEmail(employeeEmail);
    }
    
    public static void editOnlyEmail() throws ParseException {
        String customerToEdit = EditEmployeeView.textFieldEmployeeCpfEdit.getText();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
            	readAndSetEmailEdit(employeeList.get(i));
            }
        }
    }

    private static void removeCustomer(String cpfToRemove) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(cpfToRemove)) {
                employeeList.remove(i);
            }
        }
    }

    /*private static void menuEdit(Employee employee) throws ParseException {
        int option = 1;
        int action = 1;

        while (option == 1) {
            System.out.println("Choose the option: 1 - Edit name | 2 - Edit CPF | 3 - Edit Phone Number | 4 - Edit email");

            action = reader.nextInt();

            clearBuffer(reader);

            switch (action) {
                case 1:
                    readAndSetEmployeeName(employee);
                    break;

                case 2:
                    readAndSetEmployeeCPF(employee);
                    break;

                case 3:
                    readAndSetEmployeePhoneNumber(employee);
                    break;

                case 4:
                    readAndSetEmail(employee);
                    break;

            }

            System.out.println("Do you want to leave from the edit mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

        }
    }*/
        public static void menuManager() throws ParseException {
            int option = 1;
            int action = 1;

            while (option == 1) {
                System.out.println("Choose the option: 1 - Add employee | 2 - Consult employees | 3 - Remove employee | 4 - Edit employee");

                action = reader.nextInt();

                switch (action) {
	                case 1:
	                    insert();
	                    break;
	
	                case 2:
	                    consult();
	                    break;
	
	                case 3:
	                    remove();
	                    break;
	
	                case 4:
	                    edit();
	                    break;

                }

                System.out.println("Do you want to leave from the Employee mode? 1 - NO  2 - YES ");
                option = reader.nextInt();

        }
    }

}
