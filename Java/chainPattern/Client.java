package chainPattern;

public class Client {
    public static void main(String[] args) {
        Request request1 = new Request("text", "this is  text");
        Request request2 = new Request("image", "this is image");
        Request request3 = new Request("video", "this is video");
        Handler handlerChain = new Handler.Builder()
                .addHandler(new MyHandler())
                .addHandler(new TextHandler())
                .addHandler(new ImageHandler())
                .addHandler(new AllRequestHandler())
                .build();
        handlerChain.handle(request1);
//        System.out.println(request1.status);
//        handlerChain.handle(request2);
//        System.out.println(request2.status);
//        handlerChain.handle(request3);
//        System.out.println(request3.status);
    }

    public static class MyHandler extends Handler{

        @Override
        void handleRequest(Request request) {
            process(request);
        }

        @Override
        boolean canHandle(Request request) {
            return true;
        }
    }
}
