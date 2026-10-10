package OOPs.Abstraction;

/* 
    Define the abstraction:-

    Imagine a customer clicks Place Order. The checkout service shouldn't need to know 
    the internal steps of UPI, credit cards, or other payment methods.
   It should only know that a payment can be processed.
*/

 interface PaymentGateway{  // This interface defines what the system can do, not how it does it.

  abstract boolean pay(double amount);
}

class CreditCardGateway implements PaymentGateway{

    public boolean pay(double amount){
        System.out.println("Validate card details");
        System.out.println("Contactiong card payment provider...");
        System.out.println("Charging Credit Card : " + amount);

        return true;
    }
};

class UPIGateway implements PaymentGateway{

    public boolean pay(double amount){
        System.out.println("Validate upi ID ");
        System.out.println("Sending UPI Payment request...");
        System.out.println("Processing UPI Payment " + amount);

        return true;
    }
};
// Each implementation has its own internal steps. The caller doesn't need to know them.



//CheckoutService ->.  This is where abstraction becomes clear.
 class CheckOutService{

    private final PaymentGateway payGateway;

    public CheckOutService(PaymentGateway payGateway){
        this.payGateway = payGateway;
    }
    public void checkout(double amount){
        boolean success = payGateway.pay(amount);

        if(success){
            System.out.println("Order placed successfully");
        }
        else{
            System.out.println("Payment failed!");
        }
    }
}




public class AbstractionMain {
    
    public static void main(String[] args){
        PaymentGateway gateway = new UPIGateway();

        CheckOutService checkout =   new CheckOutService(gateway);

        checkout.checkout(2500);
    }

}
