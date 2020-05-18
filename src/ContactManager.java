import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    public ArrayList<Contact> contactList = new ArrayList<>();

    public ContactManager() {

    }

    // Hiển thị danh bạ và cho phép người dùng thêm sửa xóa các mục trong danh bạ
    public void showContact() {
        for (int i = 0; i < this.contactList.size(); i++) {
            System.out.println(this.contactList.get(i).toString());
        }
//        int i = 0;
//        while (i < this.contactList.size()) {
//            for (int j = i; j < i + 5; j++) {
//                System.out.println(this.contactList.get(j).toString());
//            }
//            i += 5;
//            Scanner newline = new Scanner(System.in);
//            String nl = newline.nextLine();
//        }
    }

    public void createContact(String number, String group, String name, String gender, String address, String email, String dob) {
        Contact newContact = new Contact();

        newContact.setAddress(address);
        newContact.setMobileNumber(number);
        newContact.setName(name);
        newContact.setGroup(group);
        newContact.setGender(gender);
        newContact.setAddress(address);
        newContact.setEmail(email);
        newContact.setDob(dob);

        this.contactList.add(newContact);
    }

    public void editContact(String number, String group, String name, String gender, String address, String email, String dob) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (number.equals(this.contactList.get(i).getMobileNumber())) {
                this.contactList.get(i).setGroup(group);
                this.contactList.get(i).setName(name);
                this.contactList.get(i).setGender(gender);
                this.contactList.get(i).setAddress(address);
                this.contactList.get(i).setEmail(email);
                this.contactList.get(i).setDob(dob);
            }
        }
    }

    public void deleteContact(String number) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (number.equals(this.contactList.get(i).getMobileNumber())) {
                this.contactList.remove(i);
            }
        }
    }

    public void findContactByName(String name) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (this.contactList.get(i).getName().contains(name)) {
                System.out.println(this.contactList.get(i).toString());
            }
        }
    }

    public void findContactByNumber(String number) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (this.contactList.get(i).getMobileNumber().contains(number)) {
                System.out.println(this.contactList.get(i).toString());
            }
        }
    }

    public void readCSV() {
        String csvFile = "data\\contacts.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] contact = line.split(cvsSplitBy);
                System.out.println("Contact{ mobileNumber= " + contact[0]
                        + ", group= " + contact[1]
                        + " , name= " + contact[2] +
                        ", gender= " + contact[3]
                        + ", address= " + contact[4]
                        + ", email= " + contact[5]
                        + ", dob= " + contact[6] + "}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeCSV() {
        try {
            FileWriter writer = new FileWriter("data\\contacts.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < this.contactList.size(); i++) {
                Contact updateContact = this.contactList.get(i);
                String content = updateContact.getMobileNumber() + ", "
                        + updateContact.getGroup() + ", "
                        + updateContact.getName() + ", "
                        + updateContact.getGender() + ", "
                        + updateContact.getAddress() + ", "
                        + updateContact.getEmail();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
