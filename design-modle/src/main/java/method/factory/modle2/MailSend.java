package method.factory.modle2;

public class MailSend implements Sender {
    @Override
    public void sendMsg() {
        System.out.println("  邮件   消息  发送 ");
    }
}
