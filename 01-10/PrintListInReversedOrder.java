// 面试题6：从尾到头打印链表
// 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。


import java.util.LinkedList;

public class PrintListInReversedOrder {

    //通过尾插法建立单链表
    private ListNode LinkedList(){
        char ch;
        ListNode p, t;
        ListNode h = new ListNode();
        h.m_pNext = null;
        t = h;
//      String str = "123";
//      String str = "1234";
        String str = "123456789";
        int i = 0;
        while (i < str.length()){
            ch = str.charAt(i);
            p = new ListNode();
            p.m_nkey = ch;
            p.m_pNext = null;
            t.m_pNext = p;
            t = p;
            i++;
        }
        return h;
    }

    private class stack {

        int maxSize = 100;
        int tag;
        int [] arr;

        private stack(){
            tag = -1;
            arr = new int [maxSize];
        }

        private void push(int key){
            arr[++tag] = key;
        }

        private void pop(){
            tag--;
        }
/*
        private int pop(){
            return arr[tag--];
        }
*/
        private int top(){
            return arr[tag];
        }

        private boolean empty(){
            return tag == -1;
        }

    }

    private void PrintListReversingly_Iteratively(ListNode pHead){

        stack nodes = new stack();

        ListNode pNode = pHead;
//      Object pNode = pHead;
        while (pNode != null){
            nodes.push(pNode.m_nkey);
            pNode = pNode.m_pNext;
        }

        int key;
        while (!nodes.empty()){
            key = nodes.top();
            System.out.printf("%d\t", key);
            nodes.pop();
        }

    }

/*
//  Object和ListNode无法调节
    private void PrintListReversingly_Iteratively(ListNode pHead){

        stack nodes = new stack();

        ListNode pNode = pHead;
//      Object pNode = pHead;
        while (pNode != null){
            nodes.push(pNode);
            pNode = pNode.m_pNext;
        }

        while (!nodes.empty()){
            pNode = nodes.top();

        }

    }

    class stack {

        LinkedList nodes = new LinkedList();

        public void push(Object o){
            nodes.addFirst(o);
        }

        public Object pop(){
            return nodes.removeFirst();
        }

        public Object top(){
            return nodes.getFirst();
        }

        public boolean empty(){
            return nodes.isEmpty();
        }

    }
*/

    private void PrintListReversingly_Recursively(ListNode pHead){

        if (pHead != null){
            if (pHead.m_pNext != null){
                PrintListReversingly_Recursively(pHead.m_pNext);
            }

            System.out.printf("%d\t", pHead.m_nkey);
        }

    }

    public static void main(String [] args){

        //建立单链表（list）
        PrintListInReversedOrder link = new PrintListInReversedOrder();
        ListNode list = link.LinkedList();
        //头结点的m_pNext值为空，不取
        list = list.m_pNext;
        System.out.println("从尾到头打印链表");
//      栈的方法
        link.PrintListReversingly_Iteratively(list);
        System.out.println();
//      递归的方法
        link.PrintListReversingly_Recursively(list);
        System.out.println();
        System.out.println("从头到尾打印链表");
        while (list != null){
            System.out.print(list.m_nkey + "\t");
            list = list.m_pNext;
        }

    }

}

class ListNode {
    int m_nkey;
    ListNode m_pNext;
}
