// 面试题3（二）：不修改数组找出重复的数字
// 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
// 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
// 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
// 输出是重复的数字2或者3。


public class DuplicationInArrayNoEdit {

    int getDuplication(int [] numbers, int length){

        if (numbers == null || length <= 0)
            return -1;

        int start = 1;
        int end = length - 1;
        while (end >= start){
            int middle = (end - start) / 2 + start;
            int count = countRange(numbers, length, start, middle);

            if (end == start){
//              count大于1说明至少有两个值numbers[i]为start，即至少有一个重复值为start
                if(count > 1)
                    return start;
                else
                    break;
            }

//          说明前半部分有重复，则继续减半
            if (count > (middle - start + 1))
                end = middle;
//          说明前半部分无重复，则测试后半部分
            else
                start = middle + 1;

        }
        return -1;

    }

    int countRange(int [] numbers, int length, int start, int end){

        if (numbers == null)
            return 0;

        int count = 0;
        for (int i = 0; i < length; i++)
            if (numbers[i] >= start && numbers[i] <= end)
                count++;

        return count;

    }

//  比较笨的方法；二分法性能较优
    int getDup(int [] numbers){

        if (numbers == null || numbers.length <= 0)
            return -1;

        for (int tag = 0; tag < numbers.length; tag++)
            for (int i = 0; i < numbers.length; i++)
                if (tag != i && numbers[tag] == numbers[i])
                    return numbers[tag];

        return -1;
    }

    public static void main(String [] args){

//      利用二分法，将这串数字分为1～4和5～7两个区间进行测试；
//      若全部数字落在某一区间的数量比该区间长度大，则说明该区间内有重复数字
        int [] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        DuplicationInArrayNoEdit obj = new DuplicationInArrayNoEdit();
        System.out.println(obj.getDuplication(numbers, numbers.length));
        System.out.println(obj.getDup(numbers));

    }

}
