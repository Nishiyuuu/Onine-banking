public class Transaction {
    private String type; // "deposit" or "withdraw or "transfer"
    private double amount;
    private String date;
    private Account accountSender;
    private Account accountReceive;

    public Transaction(String type, double amount, String date, Account accountSender, Account accountReceive) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.accountSender = accountSender;
        this.accountReceive = accountReceive;
    }

    public void getTransactionDetails() {
        System.out.println("Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
        System.out.println("Sender: " + accountSender.getAccountType());
        System.out.println("Receiver: " + accountReceive.getAccountType());
    }


}
