package pattren.chain;

public class ImageHandler extends Handler {
    public ImageHandler() {
    }

    @Override
    void handleRequest(Request request) {
        System.out.println("ImagerHandler: " + request.content);
        request.status = 1;
        process(request);
    }

    @Override
    boolean canHandle(Request request) {
        return "image".equals(request.type);
    }
}
