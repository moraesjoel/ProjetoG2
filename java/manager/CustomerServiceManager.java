package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Views.ModuleServiceView;
import Views.ScheduleServiceView;
import Views.InsertNewModules.InsertNewCustomer;
import Views.InsertNewModules.InsertNewEmployee;
import Views.InsertNewModules.InsertNewService;
import Views.ModuleCustomerActionsView.InsertCustomerView;
import Views.ModuleEmployeeActionsView.InsertEmployeeView;
import Views.ModuleServiceActionsView.InsertView;

import java.util.Date;

import entities.Address;
import entities.Customer;
import entities.CustomerService;
import entities.Employee;
import entities.Service;
import enums.CustomerServiceStatus;
import enums.Status;

public class CustomerServiceManager {
	
    static ArrayList<CustomerService> customerServiceList = new ArrayList<CustomerService>();
    
    static Scanner reader = new Scanner(System.in);
    static String optionStatus;
    static String customerServiceDate;
    static String customerServiceHour;
    static Date customerServiceDateFormatted;
    static Date customerServiceDateFormattedToRemove;
    static Date customerServiceDateFormattedToEdit;
    static Date customerServiceHourFormattedToEdit;
    static Date customerServiceHourFormattedToRemove;
    static Date customerScheduledDateFormatted;
    static Date customerServiceHourFormatted;
    static String serviceDescription;
    static String customerServiceCpf;
    static String employeeServiceCpf;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); 

   
    public static void insert() throws ParseException {
      
    	/*Date date = new Date(01/03/2000);

    	Employee employee = new Employee("11", "joel", "11", "joel@");

    	Address address = new Address("Taq", 99, "Taq", "RS");

    	Customer customer1 = new Customer("22", "schein", "22", "schein@", date, "m", "c", "ACTIVE", address);

    	Customer customer2 = new Customer("33", "otavio", "33", "otavio@", date, "m", "c", "ACTIVE", address);

    	Customer customer3 = new Customer("43", "otávio", "43", "otavio@", date, "m", "c", "INACTIVE", address);

    	Service service1 = new Service("arrumar");

    	EmployeeManager.employeeList.add(employee);
    	CustomerManager.customerList.add(customer1);
    	CustomerManager.customerList.add(customer2);
    	CustomerManager.customerList.add(customer3);

    	ServiceManager.serviceList.add(service1);*/
    	
    	////////////
    	
        CustomerService customerService = new CustomerService();

        readAndSetCustomerServiceDate(customerService);
        
        readAndSetCustomerServiceHour(customerService);
        
        readAndSetCustomerServiceDescription(customerService);
        
    	//readAndSetCustomerServiceStatus(customerService);

    	readAndSetCustomerServiceCustomerName(customerService);

    	readAndSetCustomerServiceEmployee(customerService);

    	addServiceToServiceListforCustomer(customerService);

        customerServiceList.add(customerService);
        
        consult();
        
    }
    
    public static void consult() {
        for (int i = 0; i < customerServiceList.size(); i++) {
            System.out.println("\nDate: " + sdf.format(customerServiceList.get(i).getDateOfService()));
            System.out.println("Hour: " + sdf2.format(customerServiceList.get(i).getHourOfService()));
            System.out.println("Customer: " + customerServiceList.get(i).getCustomer().getName());
            System.out.println("Employee: " + customerServiceList.get(i).getEmployee().getName());
            //System.out.println("Status: " + customerServiceList.get(i).getStatus());
            System.out.println("Description: " + customerServiceList.get(i).getDescription().getName());
        }
    }
    
    public static void remove() throws ParseException {
    	System.out.println("\nRemove a customer service \n ");
		
        System.out.println("Type the customer service date: ");
        String costumerServiceDateToRemove = reader.nextLine();
        customerServiceDateFormattedToRemove = sdf.parse(costumerServiceDateToRemove);
       
        System.out.println("Type the customer service hour: ");
        String costumerServiceHourToRemove = reader.nextLine();
        customerServiceHourFormattedToRemove = sdf2.parse(costumerServiceHourToRemove);
        
        removeCustomerService(customerServiceDateFormattedToRemove, customerServiceHourFormattedToRemove);
        
    }
    
    public static void edit() throws ParseException{
        System.out.println("Type the customer service date to edit it: ");
        String serviceDateToEdit = reader.nextLine();
        customerServiceDateFormattedToEdit = sdf.parse(serviceDateToEdit);
        
        System.out.println("\nType the customer service hour to edit it: ");
        String serviceHourToEdit = reader.nextLine();
        customerServiceHourFormattedToEdit = sdf2.parse(serviceHourToEdit);

        for (int i = 0; i < customerServiceList.size(); i++) {
        	if (customerServiceList.get(i).getDateOfService().equals(customerServiceDateFormattedToEdit) && 
        			customerServiceList.get(i).getHourOfService().equals(customerServiceHourFormattedToEdit)) {
            			menuEdit(customerServiceList.get(i));
            }
        }
    }
    
    private static void removeCustomerService(Date serviceDateToRemove, Date serviceHourToRemove) throws ParseException {
    	boolean validate = false;
    	for (int i = 0; i < customerServiceList.size(); i++) {
            if (customerServiceList.get(i).getDateOfService().equals(serviceDateToRemove) &&
            		customerServiceList.get(i).getHourOfService().equals(serviceHourToRemove)) {
            			customerServiceList.remove(i);
            			validate = true;
            }
        }
    	
    	if (validate == false) {
    		System.out.println("Customer service at this time does not exist! Try again.");
    		remove();
    	}
    }
    
    protected static void readAndSetCustomerServiceDate(CustomerService customerService) throws ParseException{
	    customerServiceDate = ScheduleServiceView.textFieldDate.getText();	
	    customerServiceDateFormatted = sdf.parse(customerServiceDate);
	    	   
	    customerService.setDateOfService(customerServiceDateFormatted);
	    
	}
    
    protected static void readAndSetCustomerServiceHour(CustomerService customerService) throws ParseException{

    	boolean validationHourRange;
	    boolean validationScheduled;
	    
	    do {
	    	customerServiceHour = ScheduleServiceView.textFieldHour.getText();	
		    customerServiceHourFormatted = sdf2.parse(customerServiceHour);
		    
		    validationHourRange = validateHourRange(customerServiceHourFormatted);
		    
		    validationScheduled = isAlreadyScheduled(customerServiceHourFormatted);
		    
	    } while (validationHourRange == false || validationScheduled == true);
	   
	    customerService.setHourOfService(customerServiceHourFormatted);
	}
    
    protected static boolean validateHourRange(Date hourSelected) throws ParseException{

    	boolean state = false;
	    
    	if (hourSelected.equals(sdf2.parse("08:00")) || hourSelected.equals(sdf2.parse("10:00")) || 
    			hourSelected.equals(sdf2.parse("14:00"))|| hourSelected.equals(sdf2.parse("16:00"))){
    		
    		state = true;
    	} else {
    		System.out.println("Hour selected does not match parameters. Type again.");
    	}
    	return state;
    }
    
    protected static boolean isAlreadyScheduled(Date hourSelected) throws ParseException{

    	boolean state = false;
	    
    	for (int i = 0; i < customerServiceList.size(); i++) {
            if (customerServiceList.get(i).getHourOfService().equals(hourSelected) && customerServiceList.get(i).getDateOfService().equals(customerServiceDateFormatted) ) {
            	System.out.println("There is already a Customer Service scheduled for this time. Type again.");
            	state = true;
            }
    	}
    	return state;
    }
    	
    protected static void readAndSetCustomerServiceDescription(CustomerService customerService){
	    serviceDescription = ScheduleServiceView.textFieldDescription.getText();
	
	    boolean verification = false;
	    int j;
	    for (j = 0; j < ServiceManager.serviceList.size(); j++) {
            if (ServiceManager.serviceList.get(j).getName().equals(serviceDescription)) {
            	customerService.setDescription(ServiceManager.serviceList.get(j));
            	verification = true;
            } 
        }
	    
	}
    
    public static void readAndSetCustomerServiceDescriptionVerify(){
	    serviceDescription = ScheduleServiceView.textFieldDescription.getText();
	
	    boolean verification = false;
	    int j;
	    for (j = 0; j < ServiceManager.serviceList.size(); j++) {
            if (ServiceManager.serviceList.get(j).getName().equals(serviceDescription)) {
            	verification = true;
            } 
        }
	    if (verification == false) {
	    	InsertNewService.main(null);
	    }
	    
	}
    
    
    protected static void readAndSetCustomerServiceStatus(CustomerService customerService) throws NullPointerException{
		try {
			optionStatus = (String) ScheduleServiceView.comboBoxStatus.getSelectedItem();
		} catch (NullPointerException e) {
			System.out.println("Exception!!!" + e);
		}
		System.out.println("Inseriu status");
	        	
	    
	}
    
    protected static void readAndSetCustomerServiceCustomerName(CustomerService customerService) throws ParseException{
	    customerServiceCpf = ScheduleServiceView.textFieldCustomerCpf.getText();	
	    boolean verification = false;
	    int i;
	    for (i = 0; i < CustomerManager.customerList.size(); i++) {
            if (CustomerManager.customerList.get(i).getCpf().equals(customerServiceCpf)) {
            	customerService.setCustomer(CustomerManager.customerList.get(i));
            	verification = true;
            }
        }
	    
    }
    
    public static void readAndSetCustomerServiceCustomerNameVerify() throws ParseException{
	    customerServiceCpf = ScheduleServiceView.textFieldCustomerCpf.getText();	
	    boolean verification = false;
	    int i;
	    for (i = 0; i < CustomerManager.customerList.size(); i++) {
            if (CustomerManager.customerList.get(i).getCpf().equals(customerServiceCpf)) {
            	verification = true;
            }
        }
	    
	    if (verification == false) {
	    	InsertNewCustomer.main(null);
	    }
	    
    }
    
    protected static void addServiceToServiceListforCustomer(CustomerService customerservice) {
    	Customer.serviceListForCustomer.add(customerservice.getDescription());
    	
    }
    
    protected static void readAndSetCustomerServiceEmployee(CustomerService customerService) throws ParseException{
	    employeeServiceCpf = ScheduleServiceView.textFieldEmployeeCpf.getText();	
	    boolean verification = false;
	    int j;
	    for (j = 0; j < EmployeeManager.employeeList.size(); j++) {
            if (EmployeeManager.employeeList.get(j).getCpf().equals(employeeServiceCpf)) {
            	customerService.setEmployee(EmployeeManager.employeeList.get(j));
            	verification = true;
            } 
        }
	  
	}
    
    public static void readAndSetCustomerServiceEmployeeVerify() throws ParseException{
	    employeeServiceCpf = ScheduleServiceView.textFieldEmployeeCpf.getText();	
	    boolean verification = false;
	    int j;
	    for (j = 0; j < EmployeeManager.employeeList.size(); j++) {
            if (EmployeeManager.employeeList.get(j).getCpf().equals(employeeServiceCpf)) {
            	verification = true;
            } 
        }
	    if (verification == false) {
	    	InsertNewEmployee.main(null);
	    }
	}

    public static void consultSchedule() throws ParseException {
    	System.out.println("\nEnter the date to consult the schedule: ");
        String costumerScheduleDate = reader.nextLine();
        customerScheduledDateFormatted = sdf.parse(costumerScheduleDate);
        
        showSchedule(customerScheduledDateFormatted);
        
    }
    
    
    public static void showSchedule(Date customerScheduledDateFormatted) {

    	for (int i = 0; i < customerServiceList.size(); i++) {
            if (customerServiceList.get(i).getDateOfService().equals(customerScheduledDateFormatted)) {
                System.out.println("\nHour: " + sdf2.format(customerServiceList.get(i).getHourOfService()));
                System.out.println("Customer: " + customerServiceList.get(i).getCustomer().getName());
                System.out.println("Employee: " + customerServiceList.get(i).getEmployee().getName());
                System.out.println("Status: " + customerServiceList.get(i).getStatus());
                System.out.println("Description: " + customerServiceList.get(i).getDescription().getName());	
                System.out.println("------------------------------------------------");
            }
        }
       
    }
    
    
    private static void menuEdit(CustomerService customerService) throws ParseException {
		 int option = 1;
		 int action = 1;

		 while (option == 1) {
				System.out.println("Choose the option: 1 - Edit date | 2 - Edit hour | 3 - Edit description | 4 - Edit Status | 5 - Edit customer name | "
						+ "6 - Edit customer service employee");
				
				action = reader.nextInt();
				
				
				switch (action) {
					case 1:
						readAndSetCustomerServiceDate(customerService);
						break;
						
					case 2:
						readAndSetCustomerServiceHour(customerService);
						break;
						
					case 3:
						readAndSetCustomerServiceDescription(customerService);
						break;
						
					case 4:
						readAndSetCustomerServiceStatus(customerService);
						break;
						
					case 5:
						readAndSetCustomerServiceCustomerName(customerService);
						break;
						
					case 6:
						readAndSetCustomerServiceEmployee(customerService);
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
            System.out.println("Choose the option: 1 - Add Customer Service schedule | 2 - Consult Customer Service schedule | 3 - Remove Customer Service schedule | 4 - Edit Customer Service schedule");

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

            System.out.println("Do you want to leave from the Customer Service mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

    }
        
    }
}
