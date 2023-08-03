package d3.ISP;



public class Main {
    public static void main(String[] args) {
    HumanWorker worker1 = new HumanWorker();
    RobotWorker worker = new RobotWorker();
    worker1.work();
    worker1.eat();
    worker.work();
    worker.eat(); // Здесь возникнет исключение UnsupportedOperationException
}
}


