package niuke.test1;

/**
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 */
public class Solution {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {


        int len = pre.length;
        TreeNode tn = new TreeNode(pre[0]);//根节点
        if(len==1){
            return tn;
        }
        int j;
        for(j = 0; j<len;j++){//遍历中序节点
            if(pre[0] == in[j]){
                break;
            }
        }
        //左子树
        if(j>0){
            int[] lpre = new int[j];
            int[] lin = new int[j];
            for(int i =0;i<j;i++){
                lpre[i] = pre[i+1];
                lin[i] = in[i];
            }
            tn.left = reConstructBinaryTree(lpre, lin);
        }else{
            tn.left = null;
        }
            //右子树
        if(len-j-1>0) {
            int[] rpre = new int[len-j-1];
            int[] rin = new int[len-j-1];
            for(int i =j+1;i<len;i++){
                rpre[i-j-1] = pre[i];
                rin[i-j-1] = in[i];
            }
            tn.right = reConstructBinaryTree(rpre, rin);
        }else{
            tn.right = null;
        }
        return tn;
    }
}
