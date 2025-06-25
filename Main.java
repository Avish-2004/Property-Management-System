 
import java.util.*;
 class history extends Userdata {
     static void UserDetails( User o){  // It is used to print the user credentials
        System.out.println("Your Details");
        System.out.println("Name: "+o.getUsername());
        System.out.println("Mobil NO.: "+o.getPhoneNumber());
        System.out.println("Email: "+o.getEmail());
        System.out.println();
    }
}
public class Main {
     // this function will provide after login functions
    static void Afterlogin(Propertydata propdata,Userdata userdata,int User_index){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("1. List your Property\n2. Purchase Property\n3. View your details\n4. Edit Credentials\n5. Go back");
            int choice=0;
            try {
                 choice = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("enter the correct format of data");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    propdata.listproperty(); // will list the property that user wants to sell
                    break;
                case 2:
                    propdata.Searchproperty(); // give the list of the properties according to the user's requirement
                    break;
                case 3:
                    history.UserDetails(userdata.users.get(User_index)); //show credentials
                    break;
                case 4:
                    userdata.users.get(User_index).Userdetail_Edit(); //Edit credentials
                case 5:
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Userdata userData = new Userdata();
        Propertydata propdata = new Propertydata();
        System.out.println("***Welcome to Estate Express***");
        while (true) {
            System.out.println("1. Login \n2. Signup \n3. Exit");   //options given for user to login or signup or exit the program.
            System.out.print("Enter your choice: ");
            int choice =0;
            try {
                 choice = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Enter the correct format of data");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    int User_index=userData.login();//index of user in user data Arraylist
                    if(User_index!=-1){  // In class userdata program will check that the user is already exist or not.
                    Afterlogin(propdata,userData,User_index);  // if login successfully then program jump to the static function Afterlogin.
                    }
                    break;
                case 2:
                    userData.signup(userData);     // it will create the new user by entering the all details.
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    System.exit(0);   
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
