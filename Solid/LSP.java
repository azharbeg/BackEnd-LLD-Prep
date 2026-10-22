package Solid;

/* 
   A child class ka object, parent class ke object ki jagah use kar sakte hain,
    without breaking the expected behavior of the program.

    ** We should separate the common Bird behavior from the ability to fly.
*/   


// Parent class: common behaviour of the bird

class Bird{

    public void eat(){
        System.out.println("Bird is eating");
    }
}

// Only bird that can fly implement this interface ||  Flying capability
interface Flyable{
  
    void fly();
}

// Sparrow is a bird and can fly
class Sparrow extends Bird implements Flyable{

   public void fly(){
     System.out.println("Sparrow is flying ");
   }
}


// Penguin is a Bird but can not Fly
class Penguin extends Bird{

    public void swim(){
        System.out.println("Penguin is swimming");
    }
}


// Saperate class for bird operations
class BirdService{

    // Every bird can eat
    public void feedBird(Bird bird){
        bird.eat();

    }

    // only Flyable objects can be passed
    public void makeBirdFly(Flyable bird){
        bird.fly();
    }
}


public class LSP {
    
    public static void main(String[] args){

        BirdService service = new BirdService();

        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        // both bird can be substitued for Bird Class (Base class)
        service.feedBird(sparrow);
        service.feedBird(penguin);

        // Only a flying bird can be passed here
        service.makeBirdFly(new Sparrow());


        // service.makeBirdFly(new penguin);
        // compile time error: Penguin is not Flyable
    }
}
