package method.factory.modle3;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("邮件");
    }
}
