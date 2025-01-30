import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Scanner scanner = new Scanner(System.in);

        bankSystem.registerUser("user1", "pass1", false);
        bankSystem.registerUser("admin", "adminpass", true);

        System.out.println("Enter login:");
        String login = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();

        User user = bankSystem.getUserByLogin(login);
        if (user == null || !user.validatePassword(password)) {
            System.out.println("Invalid login or password");
            return;
        }
        System.out.println("Login successful!");

        System.out.println("Select account type (Savings/Checking):");
        String accountType = scanner.next();
        bankSystem.createAccount(user, accountType);

        if (user.getAccounts().isEmpty()) {
            System.out.println("You have no accounts.");
            return;
        }

        System.out.println("Enter account number:");
        String accountNumber = scanner.next();
        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        bankSystem.deposit(user, accountNumber, amount);

        System.out.println("Balance: " + user.getAccounts().get(0).getBalance());

        scanner.close();
    }
}
