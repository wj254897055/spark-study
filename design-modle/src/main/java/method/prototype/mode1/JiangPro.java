package method.prototype.mode1;

/**
 * 模拟一个 原型模式
 * 学校发奖状
 *
 */
public class JiangPro {

    public static void main(String[] args) throws CloneNotSupportedException {
        Jiang jiang1 = new Jiang("张三","三好学生","江苏附小");
        System.out.println(jiang1.toString());
        Jiang jiang2 = jiang1.clone();
        jiang2.setName("李四");
        System.out.println(jiang2.toString());

    }
}


class Jiang implements Cloneable{

    private String name;
    private String rang;
    private String school;

    public Jiang(String name, String rang,String school) {
        System.out.println("创建奖状");
        this.name = name;
        this.rang = rang;
        this.school=school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Jiang{" +
                "name='" + name + '\'' +
                ", rang='" + rang + '\'' +
                ", school='" + school + '\'' +
                '}';
    }


    @Override
    protected Jiang clone() throws CloneNotSupportedException {
        System.out.println("复制奖状");
        return (Jiang) super.clone();
    }
}
