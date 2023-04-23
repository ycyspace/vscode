package pattren.decorator;

public class Client {
    // 与代理模式的区别在于装饰器模式暴露了原生对象，而代理模式不暴露原生对象
    public static void main(String[] args) {
        Print print = new Origin();
        Print decoratorPrint = new CustomDecorator(print);
        decoratorPrint.printStr();
    }
}
