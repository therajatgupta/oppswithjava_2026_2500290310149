public class UseCase4 {
    public static void main(String[] args) throws InsufficientBalanceException {
        double balance = 5000.0;
        double withdrawAmount = 7500.0;
        
        try {
            if(withdrawAmount > balance) throw new InsufficientBalanceException("Insufficient Balance");
                
                withdraw(balance, withdrawAmount);
            
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
 
    static void withdraw(double balance, double amount) /* complete signature */ {
        //  throw InsufficientBalanceException if amount > balance
        // otherwise print "Withdrawal successful. New balance: " + (balance - amount)
            balance = balance -amount;
            System.out.println("withdrawal successfull with balance "+balance);
        
    }

}
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}

