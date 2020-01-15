package method.factory.modle3;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("短信");
    }
}
