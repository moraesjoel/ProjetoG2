package manager;

import entities.Customer;
import entities.Address;
import enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Views.ModuleCustomerView;
import Views.ScheduleServiceView;
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
    static int addressNumber;
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
    	
    	//readAndSetStatus(customer);
    	
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
        String customerToEdit = reader.nextLine();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCpf().equals(customerToEdit) ) {
            	menuEdit(customerList.get(i));
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
		optionStatus = (String) InsertCustomerView.comboBox.getSelectedItem();
		customer.setStatus(optionStatus);
//		do {
//	    	System.out.println("Define the customer status:  1 - ACTIVE | 2 - INACTIVE ");
//	    	optionStatus = reader.nextInt();
//	        if (optionStatus == 1) {
//	        	customer.setStatus(Status.ACTIVE);
//	        } else if (optionStatus == 2){
//	        	customer.setStatus(Status.INACTIVE);
//	        }
//	    } while (optionStatus > 2 || optionStatus < 1);
	}
	
	protected static void readAndSetAddress(Customer customer){
		//clearBuffer(reader);
		System.out.println("Type the customer address: ");
	    
	    System.out.println("Street: ");
	    addressStreet = InsertCustomerView.textFieldAddressStreet.getText();
	    
	    System.out.println("Number: ");
	    addressNumber = Integer.parseInt(InsertCustomerView.textFieldAddressNumber.getText());
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
	
	private static void menuEdit(Customer customer) throws ParseException {
		 int option = 1;
		 int action = 1;

		 while (option == 1) {
				System.out.println("Choose the option: 1 - Edit name | 2 - Edit CPF | 3 - Edit Phone Number | 4 - Edit birthday | "
						+ "5 - Edit gender | 6 - Edit address | 7 - Edit email | 8 - Edit marital status | 9 - Edit status");
				
				action = reader.nextInt();
				
//				clearBuffer(reader);
				
				switch (action) {
					case 1:
						readAndSetCustomerName(customer);
						break;
						
					case 2:
						readAndSetCustomerCPF(customer);
						break;
						
					case 3:
						readAndSetCustomerPhoneNumber(customer);
						break;
						
					case 4:
						readAndSetCustomerBirthday(customer);
						break;
						
					case 5:
				    	readAndSetCustomerGender(customer);
						break;
						
					case 6:
						readAndSetAddress(customer);
						break;	
						
					case 7:
						readAndSetEmail(customer);
						break;
						
					case 8:
				    	readAndSetMaritalStatus(customer);
						break;
						
					case 9:
				    	readAndSetStatus(customer);
						break;
				    	
				}
				
				System.out.println("Do you want to leave from the edit mode? 1 - NO  2 - YES ");
				option = reader.nextInt();
				
			}
	 }
	
	public static void menuManager() throws ParseException {
        int option = 1;
        int action = 1;

        while (option == 1) {
            System.out.println("\n| 1 - Add Customer \n| 2 - Consult Customer \n| 3 - Remove Customer \n| 4 - Edit Customer \n| "
            		+ "5 - Consult active customers \n| 6 - Consult inactive customers \n| 7 - Consult services related to customer \n");

            action = reader.nextInt();

//            clearBuffer(reader);

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
                    
                case 5:
                    consultActive();
                    break;
                case 6:
                    consultInactive();
                    break;
                case 7:
                	readCpfToconsultServicesRelatedToCustomer();
                	break;

            }

            System.out.println("Do you want to leave from the Customer mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

    }
	}
	    
}
