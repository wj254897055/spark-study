package method.factory.modle3;

public class Test {

    public static void main(String[] args) {
//        SmsProduce smsProduce = new SmsProduce();
//        Sender sender = smsProduce.prdouce();
//        sender.send();
        QQproduce qQproduce = new QQproduce();
        qQproduce.setMsg("你好，我是QQ");
        Sender sender = qQproduce.prdouce();
        sender.send();
    }
}
