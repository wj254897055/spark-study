package method.factory.modle3;

public class QQproduce implements produce {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Sender prdouce() {
        return new QQsender(msg);
    }
}
