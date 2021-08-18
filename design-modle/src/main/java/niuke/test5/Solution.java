package niuke.test5;


/**
 *现在要求输入一个整数n，请你输出斐波那契数列的第n项
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610
 */
public class Solution {
    public static int Fibonacci(int n) {
        int a=0;
        int b=1;
        int sum=1;
        if (n==0){
            return 0;
        }
        for (int i = 1; i < n; i++) {
            sum= a + b;
            a=b;
            b=sum;
            System.out.println(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
       int res= Fibonacci(10);
        System.out.println("--------------");
        System.out.println(res);
    }
}
