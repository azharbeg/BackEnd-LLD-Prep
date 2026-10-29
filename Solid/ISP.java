  9package Solid;

/* *************************************************

    *****ISP states that a class should not be forced to implement methods it does not need.*****


    ---> Suppose we create one interface containing all bird behaviors

    
interface BirdActions {
    void eat();
    void fly();
    void swim();
}

class Sparrow implements BirdActions {

    public void eat() {
        System.out.println("Sparrow is eating");
    }

    public void fly() {
        System.out.println("Sparrow is flying");
    }

    public void swim() {
        // Sparrow does not need this method!
        throw new UnsupportedOperationException(
            "Sparrow cannot swim"
        );
    }
}

class Penguin implements BirdActions {

    public void eat() {
        System.out.println("Penguin is eating");
    }

    public void fly() {
        // Penguin does not need this method!
        throw new UnsupportedOperationException(
            "Penguin cannot fly"
        );
    }

    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

    Problem kya hai?
- Sparrow ko swim() implement karna pad raha hai, even though it cannot swim.
- Penguin ko fly() implement karna pad raha hai, even though it cannot fly.
- Unnecessary methods ko exceptions se handle karna pad raha hai.

This is an ISP violation because both classes are forced to depend on methods they don't need.
*//////////////////////////////////



interface Eatable{
    void eat();
}

interface Flyable{
   void fly();
}

interface Swimmable{
   void swim();
}

class Sparrow implements Eatable, Flyable{

      public void eat(){
        System.out.println("Sparrow is eating");
      }

      public void fly(){
        System.out.println("Sparrow is flying");
      }
}

class Penguin implements Eatable, Swimmable{

    public void eat(){
        System.out.println("Penguin is eating");
    }

    public void swim(){
        System.out.println("Penguin is swimming");
    }
}

class BirdService{

    public void feedBird(Eatable bird){
        bird.eat();
    }
    public void makeBirdFly(Flyable bird){
        bird.fly();
    }

    public void makeBirdswim(Swimmable bird){
        bird.swim();
    }
}
public class ISP {

    public static void main(String[] args){
    
    BirdService service = new BirdService();

    Sparrow sparrow = new Sparrow();
    Penguin penguin = new Penguin();

    // Both bird can eat
    service.feedBird(sparrow);
    service.feedBird(penguin);

    // Only sparrow can fly
    service.makeBirdFly(sparrow);

    // Only penguin can swim
    service.makeBirdswim(penguin);

  }
}

// ------- Focuses on small, specific interfaces. ---------
