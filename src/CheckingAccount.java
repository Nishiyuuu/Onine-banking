public class CheckingAccount extends Account {
    
    public CheckingAccount(int numberAccount) {
        super(numberAccount);
    }
    
    public String getAccountType() {
        return "Checking";
    }
}
