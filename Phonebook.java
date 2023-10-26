import java.util.LinkedList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class PhonebookApp {
    public static void main(String[] args) {
        LinkedList<Contact> phonebook = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhonebook Application Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);
                    phonebook.add(contact);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.println("\nContacts in Phonebook:");
                    for (Contact c : phonebook) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter the name to search for: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Contact c : phonebook) {
                        if (c.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Contact found: " + c);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Phonebook Application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
