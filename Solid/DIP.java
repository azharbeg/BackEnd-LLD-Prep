package Solid;

/*.   The key improvement is that BirdService should not depend directly on a concrete database 
        repository. Instead, it should depend on an abstraction, and the concrete repository 
        should implement that abstraction.

    ***** High-level classes should not depend directly on low-level classes. Both should
     depend on abstractions.


     1. The problem DIP solves
        Imagine BirdService directly creates its repository:
          class BirdService {
            private final BirdRepository repository =
            new BirdRepository();
        }


    ** Now BirdService is tightly coupled to BirdRepository. Replacing the database implementation 
     or using a mock repository for unit tests becomes harder.

    ** DIP addresses this by introducing a BirdRepository abstraction that both the service and 
    concrete implementations can depend on.
*/


///////////////      Complete Java code — SRP + OCP + LSP + DIP     /////////////////


interface Flyable{
    void fly();
}

// Common abstraction for every bird
abstract class Bird{
    public abstract void eat();
}

// Sparrow can eat and Fly also
class Sparrow extends Bird implements Flyable{

    public void eat(){
        System.out.println("Sparrow is eating");
    }

    public void fly(){
        System.out.println("Sparrow can Fly ");
    }
}

// Eagle can ea and Fly also
class Eagle extends Bird implements Flyable{

    public void eat(){
        System.out.println("Eagle is eating");
    }
    public void fly(){
        System.out.println("Eagle can fly alse");
    }
}

// Penguin is a Bird but it's can't Fly
class Penguin extends Bird{

    public void eat(){
        System.out.println("Penguin is eating");
    }
}

// DIP : High level code depend on this abstracion
interface BirdRepository{
    void save(Bird bird);
}

// Low - level implementation : database storage
class DatabaseBirdRepository implements BirdRepository{

    public void save(Bird bird){
        System.out.println("Saving" + bird.getClass().getSimpleName() + " to database ");
    }
}

// High - level business logic
class BirdService{

    private final BirdRepository repository;

    // Dependency Injection through the Constructor;
    BirdService(BirdRepository repository){
        this.repository = repository;
    }

    public void processBird(Bird bird){
        bird.eat();
        repository.save(bird);
    }
    public void makeBirdFly(Flyable bird){
        bird.fly();
    }
}

public class DIP {
    
    public static void main(String[] args){

        // Create the Concrete implementation
        BirdRepository repository = new DatabaseBirdRepository();

        // inject it into the BirdService
        BirdService service = new BirdService(repository);

        Sparrow sparrow = new Sparrow();
        Eagle eagle = new Eagle();
        Penguin penguin = new Penguin();

        service.processBird(sparrow);
        service.processBird(eagle);
        service.processBird(penguin);

        System.out.println("----------");

        service.makeBirdFly(sparrow);
        service.makeBirdFly(eagle);

    }
}
