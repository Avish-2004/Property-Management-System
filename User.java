import java.util.*;
import java.util.ArrayList;
interface Userdatainterface{ // This interface provides 4 functions in which 2 are default functions so that there should be no need to implement them in class
    
   default public boolean isNumeric(String strNum) { // this will check the phone no. is numeric or not
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
    default public boolean isValidPassword(String password) { // this will check the validity of the passwords
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        boolean isValidLength = password.length() >= 8;
        return hasLowercase && hasUppercase && hasDigit && isValidLength;
    }
    void signup(Userdata ob);
    int login();
}
 abstract class User implements Userdatainterface{
    private String username;
    private String phoneNumber;
    private String password;
    private String email;

     User(String username, String phoneNumber, String password, String email) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
    }
   User(){

   }
// here is geters and seters functions of all variables
     protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

     protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

protected String getPassword() {
        return password;
    }
protected void setPassword(String password){
         this.password = password;
    }

    //Userdetail_Edit() method will help user to change its detail like Password,phone number and Email id
    void Userdetail_Edit() {
        Scanner scanner = new Scanner(System.in);
        String nemail = "abc@gmale.com";
        String nphoneNumber = "00000000000";
        String npassword = "";
        boolean loop = true;
        String pass;
        do {   // here we are taking the current passwords first for verification of user
            try {
                System.out.print("Enter your current password : ");
                pass = scanner.nextLine();
                if (pass.equals(getPassword())) {
                    loop = false;
                } else {
                    System.out.println("Please enter correct password");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter in Correct format");
            }
        } while (loop);
        int choice =0;
        boolean check1 = true; //loop for changing any details
        while (check1) {
            System.out.println("Change detail :\n1. Phone number\n2. Email id \n3. Password");//
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 3) {

                    System.out.println("Enter your choice in given range");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter in Crorrect format");
                scanner.nextLine();
            }
            int choice1;
            switch (choice) {
                case 1:
                    boolean check = true; // changing phone number by applying all restrictions
                    while ((nphoneNumber.length() != 10) || check) {
                        System.out.print("Enter new phone number: ");
                        nphoneNumber = scanner.nextLine();
                        if (nphoneNumber.length() == 10) {
                            check = isNumeric(nphoneNumber);
                        } else System.out.println("Enter the valid Phone Number(length=10)");
                        if (check && nphoneNumber.length() == 10)
                            System.out.println("Enter the valid format of phone number");
                        System.out.println();
                    }
                    setPhoneNumber(nphoneNumber);;
                     choice1=0;
                    while(choice1!=1 && choice1!=2){// this loop is for if you wants to edit more or not
                        System.out.println("For further edits press 1 else 2");
                        try{
                            choice1 = scanner.nextInt();
                            scanner.nextLine();
                            if (choice1 < 1 || choice1 > 2) {

                                System.out.println("Enter your choice in given range");
                            }
                        }catch(InputMismatchException e) {
                            System.out.println("Enter the correct format of data");
                        }
                        if(choice1==2){
                            check1=false;
                        }
                    }

                    break;
                case 2: // editing in gmail
                    String checkstr = "@gmail.com";
                    while (nemail.length() < 10 || !nemail.substring(nemail.length() - 10, nemail.length()).equals(checkstr)) {
                        System.out.print("Enter New G-mail: ");
                        nemail = scanner.nextLine();
                        if (nemail.length() > 10 && nemail.substring(nemail.length() - 10, nemail.length()).equals(checkstr)) {
                            setEmail(nemail);;
                            break;
                        } else {
                            System.out.println("Enter the valid G-mail Account(it should be in @gmail.com format) ");
                        }
                    }
                    choice1=0;
                    while(choice1!=1 && choice1!=2){// this loop is for if you wants to edit more or not
                        System.out.println("For further edits press 1 else 2");
                        try{
                            choice1 = scanner.nextInt();
                            scanner.nextLine();
                            if (choice1 < 1 || choice1 > 2) {

                                System.out.println("Enter your choice in given range");
                            }
                        }catch(InputMismatchException e) {
                            System.out.println("Enter the correct format of data");
                        }
                        if(choice1==2){
                            check1=false;
                        }
                    }
                    break;
                case 3: // editing in passwords
                    boolean isValidPassword = false;

                    while (!isValidPassword) {
                        System.out.print("Enter new password: ");
                        npassword = scanner.nextLine();
                        if (isValidPassword(npassword)) {
                            setPassword(npassword);
                            isValidPassword = true;
                        } else {
                            System.out.println("Invalid password!\n");
                        }
                    }
                    choice1=0;
                    while(choice1!=1 && choice1!=2){  // this loop is for if you wants to edit more or not
                        System.out.println("For further edits press 1 else 2");
                        try{
                            choice1 = scanner.nextInt();
                            scanner.nextLine();
                            if (choice1 < 1 || choice1 > 2) {

                                System.out.println("Enter your choice in given range");
                            }
                        }catch(InputMismatchException e) {
                            System.out.println("Enter the correct format of data");
                        }
                        if(choice1==2){
                            check1=false;
                        }
                    }
                default:
                    break;
            }
            System.out.println("Changes Saved Successfully !!");
        }
    }

 }