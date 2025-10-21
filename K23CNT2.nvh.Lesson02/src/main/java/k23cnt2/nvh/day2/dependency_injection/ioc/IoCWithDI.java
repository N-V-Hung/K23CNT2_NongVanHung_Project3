package k23cnt2.nvh.day2.dependency_injection.ioc;

class IoCService {
    public void serve() {
        System.out.println("Service is serving");
    }
}

class IoCClient {
    private IoCService service;

    public IoCClient(IoCService service) {
        this.service = service;
    }

    public void doSomething() {
        service.serve();
    }
}

public class IoCWithDI {
    public static void main(String[] args) {
        IoCService service = new IoCService();
        IoCClient client = new IoCClient(service);
        client.doSomething();
    }
}

