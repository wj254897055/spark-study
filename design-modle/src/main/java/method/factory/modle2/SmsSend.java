package method.factory.modle2;

public class SmsSend implements Sender {
    @Override
    public void sendMsg() {
        System.out.println("发送     短信   ");
    }
}
