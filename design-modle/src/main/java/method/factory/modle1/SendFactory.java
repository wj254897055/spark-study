package method.factory.modle1;


/**
 *创建一个 发送消息的工厂
 *
 *  创建一个方法 实现发送消息
 */
public class SendFactory {

    public Sender SendMsg(String type){
        if ("sms".equals(type)){
            return new SmsSend();
        }else {
            return new MailSend();
        }
    }


    public static void main(String[] args) {

        SendFactory sendFactory = new SendFactory();

        //Sender sender = sendFactory.SendMsg("sms");
        Sender sender = sendFactory.SendMsg("msg");

        sender.sendMsg();

    }
}
