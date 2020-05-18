import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public void menu(ContactManager cm) {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc danh bạ từ file");
        System.out.println("7. Ghi danh bạ vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");

        Scanner input = new Scanner(System.in);
        String choice = input.next();

        Scanner userText = new Scanner(System.in);

        switch (choice) {
            case "1": // show all
                cm.showContact();
                break;
            case "2": // create
                System.out.print("Số số điện thoại: ");
                String number = userText.next();
//                Pattern p1 = Pattern.compile("^[0-9]{10}$");
//                Matcher m1 = p1.matcher(number);
                System.out.print("Nhóm: ");
                String group = userText.next();
                System.out.print("Họ tên: ");
                String name = userText.next();
                System.out.print("Giới tính: ");
                String gender = userText.next();
                System.out.print("Địa chỉ: ");
                String address = userText.next();
                System.out.print("Ngày sinh: ");
                String dob = userText.next();
                System.out.print("Email: ");
                String email = userText.next();
                cm.createContact(number,group,name,gender,address,email,dob);
                break;
            case "3": // edit
                System.out.print("Nhập số điện thoại muốn sửa: ");
                String editNumber = userText.next();

//                if (editNumber.equalsIgnoreCase("")){
//                    menu(cm);
//                }else {
//                    for (int i = 0; i<cm.contactList.size(); i++){
//                        if (!editNumber.equals(cm.contactList.get(i).getMobileNumber())){
//                            System.out.println("Không tìm thấy số điện thoại này");
//                        }
//                    }
//                }

                System.out.print("Nhóm: ");
                String edGroup = userText.next();
                System.out.print("Họ tên: ");
                String edName = userText.next();
                System.out.print("Giới tính: ");
                String edGender = userText.next();
                System.out.print("Địa chỉ: ");
                String edAddress = userText.next();
                System.out.print("Ngày sinh: ");
                String edDob = userText.next();
                System.out.print("Email: ");
                String edEmail = userText.next();
                cm.editContact(editNumber, edGroup, edName, edGender, edAddress, edDob, edEmail);
                break;
            case "4": //delete
                System.out.print("Nhập số điện thoại muốn xóa: ");
                String deleteNumber = userText.next();
                cm.deleteContact(deleteNumber);
                break;
            case "5":
                System.out.println("1. Tìm kiếm theo tên");
                System.out.println("2. Tìm kiếm theo số điện thoại");
                System.out.print("Chọn chức năng: ");
                String tk = input.next();
                switch (tk){
                    case "1":
                        System.out.print("Nhập tên: ");
                        String findName = userText.next();
                        cm.findContactByName(findName);
                        break;
                    case "2":
                        System.out.print("Nhập số điện thoại: ");
                        String findNumber = userText.next();
                        cm.findContactByNumber(findNumber);
                        break;
                }
                break;
            case "6":
                System.out.println("Đọc dữ liệu từ file sẽ xóa toàn bộ danh bạ hệ thống hiện tại, xác nhận (y/n): ");
                String accept1 = userText.next();
                if (accept1.equalsIgnoreCase("y")){
                    cm.readCSV();
                }
                break;
            case "7":
                System.out.println("Ghi dữ liệu vào file sẽ xóa toàn bộ danh bạ trong file hiện tại, xác nhận (y/n): ");
                String accept2 = userText.next();
                if (accept2.equalsIgnoreCase("y")){
                    cm.writeCSV();
                }
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("Không có lựa chọn này, xin hãy nhập lại !");
        }
        menu(cm);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        ContactManager cm = new ContactManager();
        Contact ct1 = new Contact("0913231197", "Codegym", "Trung", "nam", "HN");
        Contact ct2 = new Contact("0913231198", "Codegym1", "Hiếu", "nam", "HN");
        Contact ct3 = new Contact("0913231199", "Codegym2", "Huân", "nam", "HN");
        Contact ct4 = new Contact("0913231190", "Codegym3", "Vinh", "nam", "HN");
        Contact ct5 = new Contact("0913231196", "Codegym4", "Kiều Anh", "nữ", "HN");
        Contact ct6 = new Contact("0913231197", "Codegym", "Trung", "nam", "HN");
        Contact ct7 = new Contact("0913231198", "Codegym1", "Hiếu", "nam", "HN");
        Contact ct8 = new Contact("0913231199", "Codegym2", "Huân", "nam", "HN");
        Contact ct9 = new Contact("0913231190", "Codegym3", "Vinh", "nam", "HN");
        Contact ct10 = new Contact("0913231196", "Codegym4", "Kiều Anh", "nữ", "HN");
        cm.contactList.add(ct1);
        cm.contactList.add(ct2);
        cm.contactList.add(ct3);
        cm.contactList.add(ct4);
        cm.contactList.add(ct5);
        cm.contactList.add(ct6);
        cm.contactList.add(ct7);
        cm.contactList.add(ct8);
        cm.contactList.add(ct9);
        cm.contactList.add(ct10);

        menu.menu(cm);
    }
}
