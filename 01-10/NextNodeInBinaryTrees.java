// 面试题8：二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。


public class NextNodeInBinaryTrees {

    class BinaryTreeNode {
        char m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
        BinaryTreeNode m_pParent;
    }

//  需要根据中序遍历序列得到二叉树，先新建单个节点，再根据节点关系连接
    BinaryTreeNode CreateBinaryTreeNode(char value){

        BinaryTreeNode pNode = new BinaryTreeNode();
        pNode.m_nValue = value;
        pNode.m_pLeft = null;
        pNode.m_pRight = null;
        pNode.m_pParent = null;

        return pNode;

    }

    void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft,
                          BinaryTreeNode pRight){

        if (pParent != null){

            pParent.m_pLeft = pLeft;
            pParent.m_pRight = pRight;

            if (pLeft != null)
                pLeft.m_pParent = pParent;

            if (pRight != null)
                pRight.m_pParent = pParent;

        }

    }

//  求下一个节点
    BinaryTreeNode GetNext(BinaryTreeNode pNode){

        if (pNode == null)
            return null;

        BinaryTreeNode pNext = null;
        if (pNode.m_pRight != null){

            BinaryTreeNode pRight = pNode.m_pRight;
            while (pRight.m_pLeft != null)
                pRight = pRight.m_pLeft;

            pNext = pRight;

        }
        else if (pNode.m_pParent != null){

            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.m_pParent;
            while (pParent != null && pCurrent == pParent.m_pRight){
                pCurrent = pParent;
                pParent = pParent.m_pParent;
            }

            pNext = pParent;

        }

        return pNext;
    }

    public static void main(String [] args){

//      获取二叉树
        NextNodeInBinaryTrees tree = new NextNodeInBinaryTrees();
        BinaryTreeNode pNode_a = tree.CreateBinaryTreeNode('a');
        BinaryTreeNode pNode_b = tree.CreateBinaryTreeNode('b');
        BinaryTreeNode pNode_c = tree.CreateBinaryTreeNode('c');
        BinaryTreeNode pNode_d = tree.CreateBinaryTreeNode('d');
        BinaryTreeNode pNode_e = tree.CreateBinaryTreeNode('e');
        BinaryTreeNode pNode_f = tree.CreateBinaryTreeNode('f');
        BinaryTreeNode pNode_g = tree.CreateBinaryTreeNode('g');
        BinaryTreeNode pNode_h = tree.CreateBinaryTreeNode('h');
        BinaryTreeNode pNode_i = tree.CreateBinaryTreeNode('i');

        tree.ConnectTreeNodes(pNode_a, pNode_b, pNode_c);
        tree.ConnectTreeNodes(pNode_b, pNode_d, pNode_e);
        tree.ConnectTreeNodes(pNode_e, pNode_h, pNode_i);
        tree.ConnectTreeNodes(pNode_c, pNode_f, pNode_g);

        char node = 'd';
//      pNode_d与'd'对应
        System.out.println("节点" + node + "的下一个节点是:" + tree.GetNext(pNode_d).m_nValue);

    }

}
