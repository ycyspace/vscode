package chainPattern;

public class AllRequestHandler extends Handler {
    public AllRequestHandler() {

    }

    @Override
    void handleRequest(Request request) {
        System.out.println("AllRequestHandler: " + request.content);
        process(request);
    }

    @Override
    boolean canHandle(Request request) {
        return true;
    }
}
