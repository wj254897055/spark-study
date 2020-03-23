package method.singleton.lazy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 单例模式 ：懒汉模式
 * 加载时
 */
public class LazySingleton {

    public static void main(String[] args) {
//
//        President pr1 = President.getInstance();
//        pr1.getName();
//        President pr2=President.getInstance();
//        pr2.getName();



    }
}


class President{

    private static volatile President instance=null;

    private President(){
        System.out.println("产生一个新的实例");
    }

    public static President getInstance() {

        if (instance == null) {
            System.out.println("如果没有，新生成一个实例");
            instance=new President();
        }else {
            System.out.println("如果实例存在，不生成");
        }
        return instance;
    }

    public void getName(){
        System.out.println("实例的名称1");
    }
}
