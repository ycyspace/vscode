package chainPattern;

public abstract class Handler {
    Handler nextHandler;

    public Handler() {

    }

    /**
     * 建造者模式构建责任链
     */
    public static class Builder{
        /**
         * 链表头节点
         */
        private  final Handler baseHandler = new Handler() {
            @Override
            void handleRequest(Request request) {
            }

            @Override
            boolean canHandle(Request request) {
                return false;
            }
        };
        public Builder() {
        }
        // 当前指针
        private Handler curr = baseHandler;
        public Builder addHandler (Handler baseHandler){
            curr.nextHandler = baseHandler;
            curr = curr.nextHandler;
            return this;
        }

        public Handler build(){
            return baseHandler.nextHandler;
        }
    }

    /**
     * 传递责任链
     *
     * @param request
     */
    void process(Request request){
        if(nextHandler != null){
            nextHandler.handle(request);
//            nextHandler = nextHandler.nextHandler;
        }
    }

    /**
     * 处理Request
     *
     * @param request
     */
    abstract void handleRequest(Request request);

    /**
     * 启动责任链
     * @param request
     * @return
     */
     final void handle(Request request){
//         nextHandler = Builder.baseHandler;
        System.out.println(this.getClass().getSimpleName());
        if(canHandle(request)){
            handleRequest(request);
        }else {
            process(request);
        }
    }

    /**
     * 判断是否处理
     * @param request
     * @return
     */
    abstract boolean  canHandle(Request request);

}
