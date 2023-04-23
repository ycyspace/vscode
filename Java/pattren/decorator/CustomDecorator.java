package pattren.decorator;

public class CustomDecorator extends OriginDecorator{

    public CustomDecorator(Print print) {
        super(print);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void printStr() {
        // TODO Auto-generated method stub
        super.printStr();
        System.out.println("装饰器 printStr");
    }
    
    
}
