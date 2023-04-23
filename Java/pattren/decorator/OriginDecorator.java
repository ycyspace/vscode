package pattren.decorator;

public abstract class OriginDecorator implements Print{
    Print print;
    
    public OriginDecorator(Print print) {
        this.print = print;
    }

    @Override
    public void printStr() {
        // TODO Auto-generated method stub
        print.printStr();
        
    }

    @Override
    public void printLen() {
        // TODO Auto-generated method stub\
        print.printLen();
        
    }
    
}
