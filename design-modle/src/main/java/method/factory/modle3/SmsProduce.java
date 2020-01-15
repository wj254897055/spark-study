package method.factory.modle3;

public class SmsProduce implements produce {
    @Override
    public Sender prdouce() {
        return new SmsSender();
    }
}
