package manager;

import entities.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Views.ScheduleServiceView;
import Views.InsertNewModules.InsertNewService;
import Views.ModuleServiceActionsView.ConsultView;
import Views.ModuleServiceActionsView.EditView;
import Views.ModuleServiceActionsView.InsertView;
import Views.ModuleServiceActionsView.RemoveView;

public class ServiceManager {

    public static ArrayList<Service> serviceList = new ArrayList<Service>();
    static String serviceName;
    static Scanner reader = new Scanner(System.in);

    public static void insert() {
        Service service = new Service();

        readAndSetServiceName(service);
        
        serviceList.add(service);

        //consult();
    }

    public static void insertNew() {
        Service service = new Service();

        readAndSetNewServiceName(service);
        
        serviceList.add(service);

    }
    public static void consult() {
        String serviceNameFromList = "";
    	//List<String> snl = new ArrayList<>();
        if(serviceList.isEmpty()) {
        	serviceNameFromList = "Lista de seriços vazia!";
        } else {
        	for (int i = 0; i < serviceList.size(); i++) {
                System.out.println("\nService: " + serviceList.get(i).getName());
                serviceNameFromList += "\n" + serviceList.get(i).getName() + " ";
                //snl.add(serviceList.get(i).getName());
            }
        }
        ConsultView.labelTextConsult.setText(serviceNameFromList);
//        for (int j = 0; j < snl.size(); j++) {
//        	ConsultView.labelTextConsult.setText(snl.get(j));
//        }
        
    }

    public static void remove() {
        System.out.println("Type the service name to remove it: ");
        //String serviceNameToRemove = reader.nextLine();
        String serviceNameToRemove = RemoveView.textFieldServiceNameToRemove.getText();

        removeService(serviceNameToRemove);
    }

    public static void edit(){
    	System.out.println("Editing... ");
        //String serviceNameToEdit = reader.nextLine();
		String serviceNameToEdit = EditView.textFieldServiceNameToEdit.getText();
		editServiceName(serviceNameToEdit);
		System.out.println("Success");
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    private static void readAndSetServiceName(Service service) {
    	System.out.println("Type the service name: ");
        //serviceName = reader.nextLine();
    	serviceName = InsertView.textFieldServiceName.getText();
    	System.out.println("Service Inserted.");
        service.setName(serviceName);
    }
    
    private static void readAndSetNewServiceName(Service service) {
    	System.out.println("Type the service name: ");
        //serviceName = reader.nextLine();
    	serviceName = InsertNewService.textFieldServiceName.getText();
    	System.out.println("Service Inserted.");
        service.setName(serviceName);
    }
    
    private static void editServiceName(String name) {
    	for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getName().equals(name)) {

                System.out.println("New service name: ");
                //String newServiceName = reader.nextLine();
                String newServiceName = EditView.textFieldNewServiceName.getText(); 

                serviceList.get(i).setName(newServiceName);
                
                System.out.println("Service edited.");

            }
        }
    }
    
    private static void removeService(String nameToRemove) {
    	for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getName().equals(nameToRemove)) {
                serviceList.remove(i);
                System.out.println("Service removed.");
            }
        }
    }
    
    public static void menuManager() throws ParseException {
        int option = 1;
        int action = 1;

        while (option == 1) {
            System.out.println("Choose the option: 1 - Add Service | 2 - Consult Service | 3 - Remove Service | 4 - Edit Service");

            action = reader.nextInt();

            clearBuffer(reader);

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

            System.out.println("Do you want to leave from the Service mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

    }
    
    }
    
    
}
