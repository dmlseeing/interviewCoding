// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。


import java.util.Stack;

public class QueueWithTwoStacks {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    private void appendTail(int node){
        stack1.push(node);
    }

    private int deleteHead(){

        if (stack2.empty()){
            while (!stack1.empty())
                stack2.push(stack1.pop());
        }

        if (stack2.size() == 0)
            System.out.println("queue is empty");

        return stack2.pop();

    }

//  生成代码快捷键:psvm
    public static void main(String [] args){

        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
/*
        queue.appendTail('a');
        queue.appendTail('b');
        queue.appendTail('c');
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail('d');
        System.out.println(queue.deleteHead());
*/
    }

}

//参考知识点：https://www.cnblogs.com/gleesu/p/6751322.html