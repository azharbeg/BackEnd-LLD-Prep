package Solid;

/*
    A class should be open for extension, but closed for modification.   
       - This means we should be able to add new bird types without repeatedly modifying 
        the existing BirdService code.
*/

// OCP: Abstract bird behavior.
// New bird types can extend this class without
// modifying the existing BirdService.


abstract class Bird{

    abstract void eat();

    abstract void fly();
}

// New Bird type :- Sparrow
class Sparrow extends Bird{

    public void eat(){
        System.out.println("Sparrow can eat the seeds");
    }

    public void fly(){
        System.out.println("Sparrow can fly easily");
    }
}

// New Bird type :- Eagle 
class Eagle extends Bird{

    public void eat(){
        System.out.println("Eagle is eating meat");
    }

    public void fly(){
        System.out.println("Eagle is flying high");
    }
}

// Responsibility -> saving bird data
class BirdRepository{

    public void BirdSave(Bird bird){
        System.out.println("Saving" + bird.getClass().getSimpleName() + "to database");
    }
}

// Responsibility: Coordinating the workflow
// OCP: Works with Bird abstraction, so new bird types
// do not require changes to this class.

class BirdService{

    private final BirdRepository repository;

    BirdService(BirdRepository repository){
        this.repository = repository;
    }
    public void processBird(Bird bird){
        bird.eat();
        bird.fly();
        repository.BirdSave(bird);
    }
}


// Main Class
public class OCP {
    
    public static void main(String[] args){

       BirdRepository repository = new BirdRepository();

       BirdService service = new BirdService(repository);

       // Process a Sparrow
        service.processBird(new Sparrow());

        System.out.println("----------------");

        // Process an Eagle
        service.processBird(new Eagle());
    
    }
}
