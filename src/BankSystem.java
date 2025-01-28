import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private static ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Account> accountsList;

    public static boolean login(String login){
            for(int i = 0; i < userList.size(); i++){
                if(login.equals(userList.get(i).getLogin())){
                    return true;
                }
            }
            return false;
    }

    public static void registerUser() throws UserException{
        try (Scanner scan = new Scanner(System.in)) {
            boolean loginbool = true;
            boolean passwordbool = true;
            boolean typebool = true;

            String login = "";
            String password = "";

            while (loginbool) {
                System.out.println("Plese write login: ");
                login = scan.nextLine();
                if(login(login)){   
                    throw new UserException("Such login already exists: " + login);
                }
                loginbool = false;
            }

            while(passwordbool){
                System.out.println("Plese write password: ");
                boolean passwordCorrect = false;
                String password1;
                while (!passwordCorrect) {
                    password = scan.nextLine();
                    System.out.println("Plese confirm your password: ");
                    password1 = scan.nextLine();
                    if(password.equals(password1)){
                        passwordCorrect = true;
                    } else {
                        throw new UserException("Passwords are different!");
                    }
                }
                passwordbool = false;
            }

            System.out.println("Plese enter your account type: ");
            boolean type = Boolean.parseBoolean(scan.nextLine());
            while (typebool) {
                if(type == true && userList.size() > 0){
                    System.out.println("To do this, triple the administrator password, ");
                    System.out.println("Enter the administrator login: ");
                    String loginType = scan.nextLine();
                    boolean adminFound = false;
                    for(int i = 0; i < userList.size(); i++){
                        if(loginType.equals(userList.get(i).getLogin())){
                            adminFound = true;
                            System.out.println("Plese write password: ");
                            String passwordType = scan.nextLine();
                            if(passwordType.equals(userList.get(i).getPassword())){
                                System.out.println("Correct!");
                                userList.add(new User(login, password, type));
                                typebool = false;
                            } else {
                                throw new UserException("Incorrect password!");
                            }
                        } 
                    }
                    if (!adminFound) {
                        throw new UserException("This is not an administrator!");
                    }
                } else{
                    typebool = false;
                    userList.add(new User(login, password, type));
                }
            } 
            scan.close();
        } 
    }

    public static boolean loginUser() throws UserException{
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Plese write login User: ");
            String login = scan.nextLine();
            boolean userFound = false;
            for(int i = 0; i < userList.size(); i++){
                if(login.equals(userList.get(i).getLogin())){
                    userFound = true;
                    System.out.println("Plese write password: ");
                    String password = scan.nextLine();
                    if(password.equals(userList.get(i).getPassword())){
                        return true;
                    } else {
                        throw new UserException("Incorrect password!");
                    }
                }
            }
            if (!userFound) {
                throw new UserException("Incorrect login");
            }
            scan.close();
        }
        return false;
    }

    public static void createAccount(){
        try (Scanner scan = new Scanner(System.in)){
            
        }
    }


    public static void main(String[] args) throws UserException {
        registerUser();
        System.out.println(loginUser());
    }
}
