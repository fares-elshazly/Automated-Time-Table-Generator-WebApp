package automated.time.table.generator;
import java.util.Scanner;

public class Teacher {

    private int ID;
    private String PhoneNumber;
    private String Email;
    Scanner Scan;

    Teacher() {
        ID = -1;
        PhoneNumber = new String();
        Email = new String();
        Scan = new Scanner(System.in);
    }

    Teacher(int ID, String PhoneNumber, String Email) {
        this.ID = ID;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        Scan = new Scanner(System.in);
    }
    
    public void GetTeacherDetails() {
        System.out.print("Please Enter The Teacher ID : ");
        this.ID = Scan.nextInt();
        System.out.print("Please Enter The Teacher Phonenumber : ");
        this.PhoneNumber = Scan.next();
        System.out.print("Please Enter The Teacher Email : ");
        this.Email = Scan.next();
    }

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public String GetPhoneNumber() {
        return PhoneNumber;
    }

    public void SetPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String GetEmail() {
        return Email;
    }

    public void SetEmail(String Email) {
        this.Email = Email;
    }

}
