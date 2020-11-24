package manager;

import entities.Customer;
import entities.Address;
import enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JTextField;

import Views.ModuleCustomerView;
import Views.ScheduleServiceView;
import Views.ModuleCustomerActionsView.EditCustomerMenuView;
import Views.ModuleCustomerActionsView.EditCustomerView;
import Views.ModuleCustomerActionsView.InsertCustomerView;

public class CustomerManager {

    public static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static String customerName;
    static String customerCPF;
    static String customerPhoneNumber;
    static String customerEmail;
    static Date customerBirthday;
    static String customerBirthdayString;
    static String customerGender;
    static String customerMaritalStatus;
    static String addressStreet;
    static String addressNumber;
    static String addressCity;
    static String addressState;
    static String optionStatus;
    static String customerServiceCpf;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    static Scanner reader = new Scanner(System.in);

    public static void insert() throws ParseException {
    	Customer customer = new Customer();
    	
    	readAndSetCustomerName(customer);
    	
    	readAndSetCustomerCPF(customer);
    	
    	readAndSetCustomerPhoneNumber(customer);
    	
    	readAndSetCustomerBirthday(customer);
    	
    	readAndSetCustomerGender(customer);
    	
    	readAndSetEmail(customer);
    	
    	readAndSetMaritalStatus(customer);
    	
    	readAndSetStatus(customer);
    	
    	readAndSetAddress(customer);
    	
    	customerList.add(customer);
    	
    	
       // clearBuffer(reader);
    }
    
    public static void consult() {
    	
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("\nName: " + customerList.get(i).getName());
            System.out.println("CPF: " + customerList.get(i).getCpf());
            System.out.println("Phone Number: " + customerList.get(i).getPhoneNumber());
            System.out.println("Email: " + customerList.get(i).getEmail());
            System.out.println("Birthday: " + sdf.format(customerList.get(i).getBirthday()));
            System.out.println("Gender: " + customerList.get(i).getGender());
            System.out.println("Marital Status: " + customerList.get(i).getMaritalStatus());
            System.out.println("Status: " + customerList.get(i).getStatus());
            System.out.println("Address: ");
            System.out.println("	City: " + customerList.get(i).getAddress().getCity());
            System.out.println("	State: " + customerList.get(i).getAddress().getState());
            System.out.println("	Street: " + customerList.get(i).getAddress().getStreet());
            System.out.println("	Number: " + customerList.get(i).getAddress().getNumber());
            System.out.println("\n -------------------------------------");

        }
        
        
    }
    
    public static void remove() {
		//clearBuffer(reader);
        System.out.println("Type the customer CPF to remove it: ");
        String costumerToRemove = reader.nextLine();

        removeCustomer(costumerToRemove);
        
    }
    
    public static void edit() throws ParseException{
        System.out.println("Type the customer CPF to edit it: ");

        String customerToEdit = EditCustomerView.textFieldCpfToEdit.getText();
        
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEdit) ) {
            	editAction(customerList.get(i));
            }
        }
    }
    
//    private static void clearBuffer(Scanner scanner) {
//        if (scanner.hasNextLine()) {
//            scanner.nextLine();
//        }
//    }
    
    private static void removeCustomer(String cpfToRemove) {
    	for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(cpfToRemove)) {
            	customerList.remove(i);
            }
        }
    }
    
    protected static void readAndSetCustomerName(Customer customer) {
    	customerName = InsertCustomerView.textFieldName.getText();
        customer.setName(customerName);
    }
    
	protected static void readAndSetCustomerCPF(Customer customer){
        customerCPF = InsertCustomerView.textFieldCpf.getText();
        customer.setCpf(customerCPF);
	}
	
	protected static void readAndSetCustomerPhoneNumber(Customer customer){
	    customerPhoneNumber = InsertCustomerView.textFieldPhoneNumber.getText();
        customer.setPhoneNumber(customerPhoneNumber);
	}
	
	protected static void readAndSetCustomerBirthday(Customer customer) throws ParseException{
	    customerBirthdayString = InsertCustomerView.textFieldBirthday.getText();
        customerBirthday = sdf.parse(customerBirthdayString);
        customer.setBirthday(customerBirthday);
	}
	
	protected static void readAndSetCustomerGender(Customer customer){
        customerGender = InsertCustomerView.textFieldGender.getText();
        customer.setGender(customerGender);
	}
	
	protected static void readAndSetEmail(Customer customer){
	    customerEmail = InsertCustomerView.textFieldEmail.getText();
        customer.setEmail(customerEmail);
	}
	
	protected static void readAndSetMaritalStatus(Customer customer){
	    customerMaritalStatus = InsertCustomerView.textFieldMaritalStatus.getText();
        customer.setMaritalStatus(customerMaritalStatus);
	}
	
	protected static void readAndSetStatus(Customer customer){
		try {
			optionStatus = (String) InsertCustomerView.comboBox.getSelectedItem();
			customer.setStatus(optionStatus);
		} catch (NullPointerException e) {
			System.out.println("Exception!!!" + e);
		}
	}
	
	protected static void readAndSetAddress(Customer customer){
		//clearBuffer(reader);
		System.out.println("Type the customer address: ");
	    
	    System.out.println("Street: ");
	    addressStreet = InsertCustomerView.textFieldAddressStreet.getText();
	    
	    System.out.println("Number: ");
	    addressNumber = InsertCustomerView.textFieldAddressNumber.getText();
//		clearBuffer(reader);

	    System.out.println("City: ");
	    addressCity = InsertCustomerView.textFieldAddressCity.getText();
	    
	    System.out.println("State: ");
	    addressState = InsertCustomerView.textFieldAddressState.getText();
	    
	    Address customerAddress = new Address(addressStreet, addressNumber, addressCity, addressState);
        customer.setAddress(customerAddress);

	}
	
	public static void readCpfToconsultServicesRelatedToCustomer() {
		System.out.println("Insert the customer CPF to consult his/her services: ");
		customerServiceCpf = reader.nextLine();
		consultServicesRelatedToCustomer(customerServiceCpf);
	}
	
	public static void consultServicesRelatedToCustomer(String customerServiceCpf) {
    	
        for (int i = 0; i < customerList.size(); i++) {
        	
        	if (customerList.get(i).getCpf().equals(customerServiceCpf)) {
        		
        		Customer temporaryCustomer = customerList.get(i);
        		
        		for (int j = 0; j < temporaryCustomer.serviceListForCustomer.size(); j++) {
        			System.out.println(temporaryCustomer.serviceListForCustomer.get(j).getName());
        		}
        	}

        }
    }
	
	public static void consultActive() {
    	
        for (int i = 0; i < customerList.size(); i++) {
        	if(customerList.get(i).getStatus().equals("ACTIVE")) {
        		System.out.println("\nName: " + customerList.get(i).getName());
                System.out.println("CPF: " + customerList.get(i).getCpf());
                System.out.println("Phone Number: " + customerList.get(i).getPhoneNumber());
                System.out.println("Email: " + customerList.get(i).getEmail());
                System.out.println("Birthday: " + sdf.format(customerList.get(i).getBirthday()));
                System.out.println("Gender: " + customerList.get(i).getGender());
                System.out.println("Marital Status: " + customerList.get(i).getMaritalStatus());
                System.out.println("Status: " + customerList.get(i).getStatus());
                System.out.println("Address: ");
                System.out.println("	City: " + customerList.get(i).getAddress().getCity());
                System.out.println("	State: " + customerList.get(i).getAddress().getState());
                System.out.println("	Street: " + customerList.get(i).getAddress().getStreet());
                System.out.println("	Number: " + customerList.get(i).getAddress().getNumber());
                System.out.println("\n -------------------------------------");
        	}
        }
    }
	
	public static void consultInactive() {
    	
        for (int i = 0; i < customerList.size(); i++) {
        	if(customerList.get(i).getStatus().equals("INACTIVE")) {
        		System.out.println("\nName: " + customerList.get(i).getName());
                System.out.println("CPF: " + customerList.get(i).getCpf());
                System.out.println("Phone Number: " + customerList.get(i).getPhoneNumber());
                System.out.println("Email: " + customerList.get(i).getEmail());
                System.out.println("Birthday: " + sdf.format(customerList.get(i).getBirthday()));
                System.out.println("Gender: " + customerList.get(i).getGender());
                System.out.println("Marital Status: " + customerList.get(i).getMaritalStatus());
                System.out.println("Status: " + customerList.get(i).getStatus());
                System.out.println("Address: ");
                System.out.println("	City: " + customerList.get(i).getAddress().getCity());
                System.out.println("	State: " + customerList.get(i).getAddress().getState());
                System.out.println("	Street: " + customerList.get(i).getAddress().getStreet());
                System.out.println("	Number: " + customerList.get(i).getAddress().getNumber());
                System.out.println("\n -------------------------------------");
        	}
        }
    }
	
	public static void editAction(Customer customer) {
		
		
		String newName = EditCustomerMenuView.textFieldName.getText();
		String newCpf = EditCustomerMenuView.textFieldCpf.getText();
		String newPhoneNumber = EditCustomerMenuView.textFieldPhoneNumber.getText();
		
		String newBirthday = EditCustomerMenuView.textFieldBirthday.getText();
		 try {
			 customerBirthday = sdf.parse(newBirthday);
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
	
		String newGender = EditCustomerMenuView.textFieldGender.getText();
		String newEmail = EditCustomerMenuView.textFieldEmail.getText();
		String newMaritalStatus = EditCustomerMenuView.textFieldMaritalStatus.getText();
		String newAddressStreet = EditCustomerMenuView.textFieldAddressStreet.getText();
		String newAddressNumber = EditCustomerMenuView.textFieldAddressNumber.getText();
		String newAddressCity = EditCustomerMenuView.textFieldAddressCity.getText();
		String newAddressState = EditCustomerMenuView.textFieldAddressState.getText();		
		
		customer.setName(newName);
		customer.setCpf(newName);
		customer.setPhoneNumber(newName);
		customer.setBirthday(customerBirthday);
		customer.setGender(newGender);
		customer.setEmail(newEmail);
		customer.setMaritalStatus(newMaritalStatus);
		
		Address newAddress = new Address(newAddressStreet, newAddressNumber, newAddressCity, newAddressState);
		customer.setAddress(newAddress);
	}
	
	public static void readAndSetEditName() {
		String customerToEditCpf = EditCustomerView.textFieldCpfToEdit.getText();
		String customerNewName = EditCustomerMenuView.textFieldName.getText();
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEditCpf) ) {
            	customerList.get(i).setName(customerNewName);
            }
        }
	}
	
	public static void readAndSetEditCpf() {
		String customerToEditCpf = EditCustomerView.textFieldCpfToEdit.getText();
		String customerNewCpf = EditCustomerMenuView.textFieldCpf.getText();
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEditCpf) ) {
            	customerList.get(i).setCpf(customerNewCpf);
            }
        }
	}
	
	public static void readAndSetEditPhoneNumber() {
		String customerToEditCpf = EditCustomerView.textFieldCpfToEdit.getText();
		String customerNewPohneNumber = EditCustomerMenuView.textFieldCpf.getText();
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEditCpf) ) {
            	customerList.get(i).setPhoneNumber(customerNewPohneNumber);
            }
        }
	}
	
	public static void readAndSetEditPhoneBirthday() {
		String customerToEditCpf = EditCustomerView.textFieldCpfToEdit.getText();
		String customerNewBirthday = EditCustomerMenuView.textFieldBirthday.getText();
		
		try {
			 customerBirthday = sdf.parse(customerNewBirthday);
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
		
		
		for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEditCpf) ) {
            	customerList.get(i).setBirthday(customerBirthday);
            }
        }
	}
	    
}
