 package OOPs.Polymorphism;

abstract class Payment {

    protected final String transationId;
    protected final double amount;

      Payment(String transationId, double amount){

        if(amount < 0){
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        this.transationId = transationId;
        this.amount = amount;
    }
    void printRecipt(){
        System.out.println("transation Id is : " + transationId + ", Amount is : " + amount);
    }

    public abstract void paymentProcess(); // it's differen for every class
};

class CreditCardPayement extends Payment{

    private final String cardNumber;

  public CreditCardPayement(String transationId, double amount, String cardNumber){

        super(transationId, amount);
        this.cardNumber = cardNumber;
    }

     
   public void paymentProcess(){
        System.out.println("This payment done By Credit Card :) ");
    }
};

class UpiPayment extends Payment{

    private final String upiID;

    UpiPayment(String transationId, double amount, String upiID){

        super(transationId, amount);
        this.upiID = upiID;
    }

    @Override
    public void paymentProcess(){
        System.out.println("This payment done by UPI :) ");
    }
};

public class Polymorphism1{

    public static void main(String[] args){

        Payment p1;
        p1 = new CreditCardPayement("XXX00890CV",10000, "5467890123");

        p1.paymentProcess();

        p1 = new UpiPayment("WWWV7892", 20000, "22023467189");
        p1.paymentProcess();
    }
}
