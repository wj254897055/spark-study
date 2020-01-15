package method.factory.modle2;


/**
 *创建一个 发送消息的工厂
 *
 *  创建一个方法 实现发送消息
 */
public class SendFactory {

    public  Sender SendMailMsg(){
        return new MailSend();
    }
    public static   Sender SendMail2Msg(){
        return new MailSend();
    }

    public Sender SendSmsMsg(){
        return new SmsSend();
    }


    public static void main(String[] args) {
//
//        SendFactory sendFactory = new SendFactory();
//        Sender sender = sendFactory.SendMailMsg();
//        sender.sendMsg();
        Sender sender = SendFactory.SendMail2Msg();

        sender.sendMsg();

    }
}
