package manager;

import entities.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    
    
    public static JTable consultAndInputInTable() {
    	Vector<String> row = new Vector<String>();
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Service Name");
        
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        rowData.addElement(row);
        
        JTable table = new JTable(rowData, columnNames);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < serviceList.size(); i++) {
        	model.addRow(new Object[]{"Service: " + serviceList.get(i).getName()});
        }
    	return table;
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
    
}
