package k23cnt2.nvh.day2.dependency_injection.ioc;

// Không dùng IoC
class Service {
    public void serve() {
        System.out.println("Service is serving");
    }
}

class Client {
    private Service service = new Service();
    public void doSomething() {
        service.serve();
    }
}

public class NonIoC {
    public static void main(String[] args) {
        new Client().doSomething();
    }
}
