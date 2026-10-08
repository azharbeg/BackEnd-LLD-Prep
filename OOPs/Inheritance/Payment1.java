/*.  Definition:,
            Inheritance allows a child class to reuse and specialize the behavior of a parent class, 
            representing an IS-A relationship.
*/

package OOPs.Inheritance;

 abstract class Payment{

        private final String transationId;
        private final double amount;

        public Payment(String transationId, double amount){

            if(amount <= 0){
                throw new IllegalArgumentException(
                       "Payment amount must be positive");
            }   
            this.transationId = transationId;
            this.amount = amount;    
         }

      // make the common behavior of payment
      public void printRepeipt(){
        System.out.println("Transation : " + transationId + "Amount : " + amount);
      }

      // child class must provide their own implementation
      public abstract void processPayment();     
};

class CreditCardPayment extends Payment{

    private final String cardNumber;

    public CreditCardPayment(String transationId, double amount, String cardNumber){
        
        super(transationId,amount);
        this.cardNumber = cardNumber;
        
    }
    @Override
    public void processPayment(){
        System.out.println("Process done by Cradit Card");
    }

};


class UPIPayment extends Payment {

    private final String upiId;

    public UPIPayment(
            String transactionId,
            double amount,
            String upiId) {

        super(transactionId, amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println(
            "Processing UPI payment..."
        );
    }
};

public class Payment1 {

    public static void main(String[] agrs){

        Payment p1 = new CreditCardPayment("TXN-01DC",5000,"12345-98760");
        Payment p2 = new UPIPayment("AXEEAR-WECW", 10000, " 0099887771122");

        p1.processPayment();
        p2.processPayment();

        p1.printRepeipt();
        p2.printRepeipt();
    }
}

