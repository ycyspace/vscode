package chainPattern;

public class TextHandler extends Handler {

    public TextHandler() {
    }

    @Override
    void handleRequest(Request request) {
        System.out.println("TextHandler: " + request.content);
        request.status = 1;
        process(request);
    }


    @Override
    boolean canHandle(Request request) {
        return "text".equals(request.type);
    }
}
