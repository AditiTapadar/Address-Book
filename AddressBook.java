import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact{
    public String name;
    public String phoneNumber;
    public String address;
    
    public Contact(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
}

public class AddressBook {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Address Book");
        System.out.println("------------");
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using the Address Book. Goodbye!");
                    return;
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println();
        }
    }
    
    public static void addContact() {
        System.out.println("Enter the contact's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the contact's address: ");
        String address = scanner.nextLine();
        
        Contact contact = new Contact(name, phoneNumber, address);
        contacts.add(contact);
        
        System.out.println("Contact added successfully!");
    }
    
    public static void searchContact() {
        System.out.println("Enter the contact's name to search: ");
        String name = scanner.nextLine();
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Details");
                System.out.println("---------------");
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Address: " + contact.getAddress());
                return;
            }
        }
        
        System.out.println("Contact not found.");
    }
    
    public static void updateContact() {
        System.out.println("Enter the contact's name to update: ");
        String name = scanner.nextLine();
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter the new phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter the new address: ");
                String address = scanner.nextLine();
                
                contact.phoneNumber = phoneNumber;
                contact.address = address;
                
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        
        System.out.println("Contact not found.");
    }
    
    public static void deleteContact() {
        System.out.println("Enter the contact's name to delete: ");
        String name = scanner.nextLine();
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        
        System.out.println("Contact not found.");
    }
}