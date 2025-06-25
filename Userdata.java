 
import java.util.*;
import java.util.ArrayList;


class Userdata extends User   {
    public ArrayList<User> users ;

    public Userdata() {

        this.users = new ArrayList<>(); //array list where user data will save
    }

    public Userdata(String username, String phoneNumber, String password, String email) {
        super(username, phoneNumber, password, email);

    }

    public int login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {   // It checks weather the user already exist or not in the arraylist using username and passwords.
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Welcome "+user.getUsername());
                return users.indexOf(user);
            }
        }
        System.out.println("Wrong Username or Password");
        return -1;
    }



    public void signup(Userdata ob) { // registration of new user
        String phoneNumber="00000000000";
        String email="abc@gmale.com";
        String checkstr = "@gmail.com";
        String password="";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        boolean check = true;
        while((phoneNumber.length() != 10) || check) { // will check weather length is correct or not
            System.out.print("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            if(phoneNumber.length() == 10 ){
          check= ob.isNumeric(phoneNumber);
            }
            else System.out.println("Enter the valid Phone Number(length=10)");
            if(check && phoneNumber.length()==10) System.out.println("Enter the valid format of phone number");
        }

       while(email.length()<10||!email.substring(email.length()-10,email.length()).equals(checkstr)) { // check gmail
            System.out.print("Enter G-mail: ");
             email = scanner.nextLine();
             if(email.length()<10||!email.substring(email.length()-10,email.length()).equals(checkstr))
                 System.out.println("Enter the valid G-mail Account(it should be in @gmail.com format) ");
       }

        boolean isValidPassword = false;
        while (!isValidPassword) { // check passwords
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if (ob.isValidPassword(password)) {
                isValidPassword = true;
            } else {
                System.out.println("Invalid password!(It should contain at least 8 characters with Small,Capital and Numeric letters )\n");
            }
         }
        ob.setUsername(username);  // these will be used for printing the user details
        ob.setPhoneNumber(phoneNumber);
        ob.setEmail(email);
        ob.setPassword(password);

        Userdata newUser = new Userdata(username, phoneNumber, password, email);  // Using User class constructor new user is added to the users array list.
        users.add(newUser);  // Addition of user in the User's arraylist.

        System.out.println("User created successfully!");

    }

    
}