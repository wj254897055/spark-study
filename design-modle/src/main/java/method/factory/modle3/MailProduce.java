package method.factory.modle3;

public class MailProduce implements produce {
    @Override
    public Sender prdouce() {
       return new MailSender();
    }
}
