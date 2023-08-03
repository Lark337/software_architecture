package d3.ISP;

public class HumanWorker implements Work, Eat {

    public void work() {
        System.out.println("Человек работает");
    }
        
    public void eat() {
        System.out.println("Человек ест");
    }

    
    
}
