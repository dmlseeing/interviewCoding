// 面试题3（一）：找出数组中重复的数字
// 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
// 那么对应的输出是重复的数字2或者3。


public class DuplicationInArray {

//  duplication的作用是什么？
//  存储任意一个重复的数字，需要借助数组；若定义成普通变量，无法获得所求值
    boolean duplicate(int [] numbers, int length, int [] duplication){

//      int tag = 0;

        if (numbers == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++){
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }

        for (int i = 0; i < length; i++){
            while (numbers[i] != i){
//              表示重复，值为numbers[i]，返回true
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
//                  duplication[tag++] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    public static void main(String [] args){
//      int [] numbers = {2, 3, 1, 0, 2, 5, 3};
        int [] numbers = {2, 3, 0, 3, 2, 5, 1};
        int [] duplication = new int [1];
        DuplicationInArray obj = new DuplicationInArray();
        System.out.println(obj.duplicate(numbers, numbers.length, duplication));
        System.out.println(duplication[0]);
    }
}
