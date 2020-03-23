package niuke.test1;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

        String s1="hello";
        String s2="hel"+new String("llo");
        System.out.println(s1==s2);
    }

}
