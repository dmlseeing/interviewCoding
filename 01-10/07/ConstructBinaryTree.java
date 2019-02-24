// 面试题7：重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
// 图2.6所示的二叉树并输出它的头结点。


import java.util.HashMap;

public class ConstructBinaryTree {
/*
    BinaryTreeNode Construct(int [] preorder, int [] inorder, int length){

        if (preorder == null || inorder == null || length <= 0)
            return null;

        return null;

    }

    BinaryTreeNode ConstructCore(int [] startPreorder, int [] endPreorder,
                                 int [] startInorder, int [] endInorder){

         int rootValue = startPreorder[0];
         BinaryTreeNode root = new BinaryTreeNode();
         root.m_nValue = rootValue;
         root.m_pLeft = root.m_pRight = null;

         if (startPreorder == endPreorder){
             if (startInorder == endInorder && startPreorder == startInorder)
                 return root;
             else
                 System.out.println("Invalid input.");
         }

         int ri = 0;
         int sin = 0;
         int spr = 0;
         int [] rootInorder = startInorder;
         while (rootInorder[ri] <= endInorder[ri] && rootInorder[ri] != rootValue)
             ri++;

         if (rootInorder[ri] == endInorder[ri] && rootInorder[ri] != rootValue)
             System.out.println("Invalid input");

//         C语言中有*做引用，但Java没有，只能用数组，报错
//         int [] leftLength = rootInorder - startInorder;
//         int leftLength = rootInorder - startInorder;
//         int [] leftPreorderEnd = spr + leftLength;
//         int leftLength = ri - sin;
//         int [] leftPreorderEnd = spr + leftLength;

         return root;

    }
*/

    private BinaryTreeNode ConstructCore(int [] pre, int [] in){

        if (pre == null || in == null)
            return null;

        HashMap map = new HashMap();
        for (int i = 0; i < in.length; i++)
            map.put(in [i], i);
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);

    }

    private BinaryTreeNode preIn(int [] p, int pi, int pj, int [] n, int ni,
                         int nj, HashMap map){

        if (pi > pj)
            return null;

        BinaryTreeNode head = new BinaryTreeNode(p[pi]);
        int index = (int)map.get(p[pi]);
        head.m_pLeft = preIn(p, pi + 1, pi + (index - ni), n, ni, index - 1, map);
        head.m_pRight = preIn(p, pi + (index - ni) + 1, pj, n, index + 1, nj, map);
        return head;

    }

    private void preorder(BinaryTreeNode t){
        if (t != null){
            System.out.print(t.m_nValue + "\t");
            preorder(t.m_pLeft);
            preorder(t.m_pRight);
        }
    }

    private void inorder(BinaryTreeNode t){
        if (t != null){
            inorder(t.m_pLeft);
            System.out.print(t.m_nValue + "\t");
            inorder(t.m_pRight);
        }
    }

    private void postorder(BinaryTreeNode t){
        if (t != null){
            postorder(t.m_pLeft);
            postorder(t.m_pRight);
            System.out.print(t.m_nValue + "\t");
        }
    }

    public static void main(String [] args){

        int [] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int [] in = {4, 7, 2, 1, 5, 3, 8, 6};
        ConstructBinaryTree tree = new ConstructBinaryTree();
        BinaryTreeNode tr = tree.ConstructCore(pre, in);
        System.out.println("该树的前序遍历为：");
        tree.preorder(tr);
        System.out.println();
        System.out.println("该树的中序遍历为：");
        tree.inorder(tr);
        System.out.println();
        System.out.println("该树的后序遍历为：");
        tree.postorder(tr);

    }

}

class BinaryTreeNode {
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;

    public BinaryTreeNode(int data){
        this.m_nValue = data;
        this.m_pLeft = null;
        this.m_pRight = null;
    }
}


//参考知识点：
//Map总结：https://www.cnblogs.com/skywang12345/p/3311126.html
//HashMap的常用操作：https://blog.csdn.net/u013398759/article/details/77679632