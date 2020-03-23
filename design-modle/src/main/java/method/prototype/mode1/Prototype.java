package method.prototype.mode1;

/**
 * 原型模式
 * 用一个已经创建的实例作为原型，
 * 通过复制该原型对象来创建一个和原型相同或相似的新对象
 */
public class Prototype implements Cloneable {

    Prototype(){
        System.out.println("--初始化---");
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        System.out.println("复制模型");
        return (Prototype)super.clone();
    }
}

class ProtypeTest{

    public static void main(String[] args) throws CloneNotSupportedException {

        Prototype obj1 = new Prototype();
        Prototype obj2 = obj1.clone();
        System.out.println(obj1==obj2);
    }


}
