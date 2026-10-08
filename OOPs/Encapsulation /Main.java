/*
Definition:
      Encapsulation means keeping an object's data and the operations 
      that modify that data together, while preventing direct uncontrolled 
      access to its internal state.
 */

 class BankAccount {  
    
    // Internal state is hidden from the outside world
    private final String accountNumber;
      private double balance;

      public BankAccount(String accountNumber, double initialBalance){

        // Check balance is not negative 
        if(initialBalance < 0){
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
      }
      // read only 
      public String getAccount(){
        return accountNumber;
      }
      // read only
      public double getBalance(){
        return balance;
      }

      // business logic operations
      public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("deposit ammount must be positive");
        }
        balance += amount;
      }
      // business logic operations
      public void withdraw(double amount){

        if(amount <= 0){
            throw new IllegalArgumentException("withdraw amount must be positive");
        }
         if(amount > balance){
            throw new IllegalArgumentException("You have insufficient balance");
         }
         balance -= amount;
      }
};

public class Main{
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("ACC1234567889765", 100000.00);
        account1.deposit(5000.00);
        account1.withdraw(2000.00);
        System.out.println("Account Number: " + account1.getAccount());
        System.out.println("Current Balance: " + account1.getBalance());
    }
}
 
/*
 -> Encapsulation = Data Hiding + Controlled Access + Validation + Maintaining Invariants

 --> Encapsulation vs Data Hiding

   They are related but not exactly the same.
        •Data Hiding → internal data ko directly accessible nahi hone dena.
        •Encapsulation → data + related behavior ko ek unit/class mein bundle karke controlled access provide karna.


For SDE-2, a good one-liner is:

   Encapsulation is the practice of hiding an object's internal state and exposing only controlled operations 
to modify or access that state, while ensuring the object remains in a valid state.

*/