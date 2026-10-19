package Solid;

/* Single-responsibility Principle (SRP) states:
   -A class should have one and only one reason to change, meaning that a class should have only one job.

*/


// Responsibility 1 -> Bird behavior
class Bird{
  
     public void eat(){
        System.out.println("Bird is eating");
     }

     public void fly(){
        System.out.println("Bird is flying");
     }
}

// Responsibility 2 -> Saving Bird data

class BirdRepository{

    public void save(Bird bird){
        System.out.println("Saving bird to database");
    }
}

// Responsibility 3 -> Coordinating the workflow (BirdService ka kaam hai alag-alag tasks ko sahi order mein karwana. Isi ko workflow coordinate karna kehte hain)

class BirdService{
    private final BirdRepository repository;

    public BirdService(BirdRepository repository){
        this.repository = repository;
    }

    public void processBird(Bird bird){
        bird.eat();
        bird.fly();
        repository.save(bird);
    }
}
  
public class SRP{

    public static void main(String[] agrs){
        Bird bird = new Bird();

        BirdRepository repository = new BirdRepository();

        BirdService service = new BirdService(repository);

        service.processBird(bird);
    }
}