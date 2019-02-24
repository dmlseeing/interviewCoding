// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。


import java.util.Scanner;

public class Fibonacci {

    long Fibonacci(int n){

        int [] result = {0, 1};
        if (n < 2)
            return result[n];

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++){

            fibN = fibNMinusOne + fibNMinusTwo;

            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;

        }

        return fibN;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String n = input.next();
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(Integer.parseInt(n)));

    }

}
