# Banking System Documentation

## Overview
This banking system allows users to register, log in, create accounts, deposit, withdraw, and transfer money. It includes functionality for both regular users and administrators.

## Classes and Interfaces

### Account (Abstract Class)
- `private final int numberAccount;` - Unique account number.
- `private double balance;` - Account balance.
- `public Account(int numberAccount);` - Constructor.
- `public void deposit(double amount);` - Adds funds.
- `public void withdraw(double amount) throws UserException;` - Withdraws funds.
- `public double getBalance();` - Returns balance.
- `public int getNumberAccount();` - Returns account number.
- `public List<Transaction> getTransactions();` - Retrieves transactions.
- `public abstract String getAccountType();` - Returns account type.

### CheckingAccount (Extends Account)
- `public CheckingAccount(int numberAccount);` - Constructor.
- `public String getAccountType();` - Returns "Checking".

### SavingsAccount (Extends Account)
- `public SavingsAccount(int numberAccount);` - Constructor.
- `public String getAccountType();` - Returns "Savings".

### BankSystem
- `private List<User> users;` - List of users.
- `private ArrayList<Account> accounts;` - List of accounts.
- `public BankSystem();` - Constructor initializes lists.
- `public void registerUser(String login, String password, boolean isAdmin);` - Registers a user.
- `public void loginUsers(String login, String password);` - Authenticates a user.
- `public void createAccount(User user, String accountType);` - Creates an account for a user.
- `public void deposit(User user, String accountNumber, double amount);` - Deposits money.
- `public void withdraw(User user, String accountNumber, double amount);` - Withdraws money.
- `public void transfer(User sender, String fromAccount, String toAccount, double amount);` - Transfers money.
- `public void viewTransactionHistory(User user, String accountNumber);` - Displays transaction history.
- `public User getUserByLogin(String login);` - Finds user by login.
- `public void deleteUser(String login);` - Deletes a user and their accounts.

### User
- `private String login;` - User login.
- `private String password;` - User password.
- `private List<Account> accounts;` - User's accounts.
- `private boolean isAdmin;` - Admin flag.
- `public User(String login, String password, boolean isAdmin);` - Constructor.
- `public void addAccount(Account account);` - Adds an account.
- `public List<Account> getAccounts();` - Retrieves accounts.
- `public boolean validatePassword(String password);` - Validates password.
- `public String getLogin();` - Returns login.
- `public void setLogin(String login);` - Sets login.
- `public String getPassword();` - Returns password.
- `public void setPassword(String password);` - Sets password.
- `public void setAccounts(List<Account> accounts);` - Sets accounts.
- `public boolean isAdmin();` - Returns admin status.
- `public void setAdmin(boolean isAdmin);` - Sets admin status.

### Transaction
- `private String type;` - Transaction type.
- `private double amount;` - Amount involved.
- `private String date;` - Date of transaction.
- `private Account accountSender;` - Sender's account.
- `private Account accountReceive;` - Receiver's account.
- `public Transaction(String type, double amount, String date, Account accountSender, Account accountReceive);` - Constructor.
- `public void getTransactionDetails();` - Displays transaction details.

### AdminAccount (Interface)
- `public void blockAccount(String accountNumber);` - Blocks an account.
- `public void deleteUser(String login);` - Deletes a user.

### UserAction (Interface)
- `public void viewAccount();` - Views account.
- `public void performTransaction();` - Performs a transaction.

### UserException (Custom Exception)
- `public UserException(String message);` - Handles exceptions.

## Main Class
- Initializes `BankSystem`.
- Registers default users.
- Allows login and account creation.
- Supports deposits and balance display.
- Handles user interaction through the console.

## Usage
1. Register a user.
2. Log in.
3. Create a "Checking" or "Savings" account.
4. Deposit money.
5. Withdraw, transfer, and view transactions.
6. Admin can delete users.

This documentation covers the structure and usage of the banking system, ensuring clarity in implementation and modification.