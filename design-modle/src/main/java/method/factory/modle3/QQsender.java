package method.factory.modle3;

public class QQsender implements Sender {
    String  msg;

    public QQsender(String msg) {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void send() {
        System.out.println("--->"+msg);
        System.out.println("QQ消息");
    }
}
