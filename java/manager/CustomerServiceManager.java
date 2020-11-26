package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Views.ModuleServiceScheduleView;
import Views.ModuleServiceView;
import Views.ScheduleServiceView;
import Views.InsertNewModules.InsertNewCustomer;
import Views.InsertNewModules.InsertNewEmployee;
import Views.InsertNewModules.InsertNewService;
import Views.ModuleCustomerActionsView.InsertCustomerView;
import Views.ModuleEmployeeActionsView.InsertEmployeeView;
import Views.ModuleScheduleActionsView.EditScheduleView;
import Views.ModuleScheduleActionsView.RemoveServiceScheduleView;
import Views.ModuleScheduleActionsView.ScheduleServiceDateHourView;
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
        
    	readAndSetCustomerServiceStatus(customerService);

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
    
    public static JTable consultAndInputInTable() {
    	Vector<String> row = new Vector<String>();
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Date");
        columnNames.addElement("Hour");
        columnNames.addElement("Description");
        columnNames.addElement("Status");
        columnNames.addElement("Customer");
        columnNames.addElement("Employee");
        
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        rowData.addElement(row);
        
        JTable table = new JTable(rowData, columnNames);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < customerServiceList.size(); i++) {
        	model.addRow(new Object[]{
        			sdf.format(customerServiceList.get(i).getDateOfService()),
        			sdf2.format(customerServiceList.get(i).getHourOfService()),
        			customerServiceList.get(i).getDescription().getName(),
        			customerServiceList.get(i).getStatus(),
        			customerServiceList.get(i).getCustomer().getName(),
        			customerServiceList.get(i).getEmployee().getName()
        			});
        }
    	return table;
    }
    
    public static void remove() throws ParseException {		
       
    	String customerServiceDateToRemove = RemoveServiceScheduleView.textFieldDate.getText();	
        customerServiceDateFormattedToRemove = sdf.parse(customerServiceDateToRemove);
	    
	    String customerServiceHourToRemove = RemoveServiceScheduleView.textFieldHour.getText();	
	    customerServiceHourFormattedToRemove = sdf2.parse(customerServiceHourToRemove);
        
        removeCustomerService(customerServiceDateFormattedToRemove, customerServiceHourFormattedToRemove);
        
    }
    
    public static void edit() throws ParseException{
        String serviceDateToEdit = ScheduleServiceDateHourView.textFieldDate.getText();
        customerServiceDateFormattedToEdit = sdf.parse(serviceDateToEdit);
        
        String serviceHourToEdit = ScheduleServiceDateHourView.textFieldHour.getText();
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
    		ModuleServiceScheduleView.main(null);
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
			customerService.setStatus(optionStatus);
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
    	readAndSetcustomerServiceDateEdit(customerService);

        readAndSetcustomerServiceHourEdit(customerService);

        readAndSetcustomerServiceDescriptionNumberEdit(customerService);

        readAndSetcustomerServiceStatusEdit(customerService);
        
        readAndSetcustomerServiceCustomerEdit(customerService);
        
        readAndSetcustomerServiceEmployeeEdit(customerService);
        
        addServiceToServiceListforCustomerFromEdit(customerService);
        
        consult();
        
	 }
    
    protected static void readAndSetcustomerServiceDateEdit(CustomerService customerService) throws ParseException{
	    String customerServiceDateEdit = EditScheduleView.textFieldDate.getText();	
	    Date customerServiceDateFormattedEdit = sdf.parse(customerServiceDateEdit);
	    	   
	    customerService.setDateOfService(customerServiceDateFormattedEdit);
	}
    
    protected static void readAndSetcustomerServiceHourEdit(CustomerService customerService) throws ParseException{
	    String customerServiceHourEdit = EditScheduleView.textFieldHour.getText();	
	    Date customerServiceHourFormattedEdit = sdf2.parse(customerServiceHour);
	    	   
	    customerService.setDateOfService(customerServiceHourFormatted);
	}
    
    protected static void readAndSetcustomerServiceDescriptionNumberEdit(CustomerService customerService) throws ParseException{
    	serviceDescription = EditScheduleView.textFieldDescription.getText();
    	
	    int j;
	    for (j = 0; j < ServiceManager.serviceList.size(); j++) {
            if (ServiceManager.serviceList.get(j).getName().equals(serviceDescription)) {
            	customerService.setDescription(ServiceManager.serviceList.get(j));
            } 
        }
	}
    
    protected static void readAndSetcustomerServiceStatusEdit(CustomerService customerService) throws ParseException{
    	try {
    		optionStatus = (String) EditScheduleView.comboBox.getSelectedItem();
    		customerService.setStatus(optionStatus);
    	} catch (NullPointerException e) {
    		e.printStackTrace();
    	}
	}
    
    protected static void readAndSetcustomerServiceCustomerEdit(CustomerService customerService) throws ParseException{
    	customerServiceCpf = EditScheduleView.textFieldCustomerCpf.getText();	
	    
	    int i;
	    for (i = 0; i < CustomerManager.customerList.size(); i++) {
            if (CustomerManager.customerList.get(i).getCpf().equals(customerServiceCpf)) {
            	customerService.setCustomer(CustomerManager.customerList.get(i));
            }
        }
	}
    
    protected static void readAndSetcustomerServiceEmployeeEdit(CustomerService customerService) throws ParseException{
	    employeeServiceCpf = EditScheduleView.textFieldEmployeeCpf.getText();	
	    int j;
	    for (j = 0; j < EmployeeManager.employeeList.size(); j++) {
            if (EmployeeManager.employeeList.get(j).getCpf().equals(employeeServiceCpf)) {
            	customerService.setEmployee(EmployeeManager.employeeList.get(j));
            } 
        }
	  
	}
    
    
    protected static void addServiceToServiceListforCustomerFromEdit(CustomerService customerservice) {
    	Customer.serviceListForCustomer.add(customerservice.getDescription());
    	
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
