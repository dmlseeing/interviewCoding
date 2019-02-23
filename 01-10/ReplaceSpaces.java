// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。


public class ReplaceSpaces {

    void ReplaceBlank(char [] string, int length){

        if (string == null || length <= 0)
            return;


//      length 为字符数组str的总容量，大于或等于字符串str的实际长度
        int originalLength = 0;
        int numberOfBlank = 0;
        int i = 0;
//      用于计算新字符串的长度
//      !!C语言字符串有'\0'后缀，Java没有，需要处理
        while (string[i] != '.'){
            originalLength++;

            if (string[i] == ' ')
                numberOfBlank++;

            i++;
        }


//      newLength 为把空格替换成'%20'之后的长度
        int newLength = originalLength + numberOfBlank * 2;
        if (newLength > length)
            return;

//      原来的下标值及新字符串的下标值
        int indexOfOriginal = originalLength;
        int indexOfNew = newLength;

        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){

            if (string[indexOfOriginal] == ' '){
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            }
            else
                string[indexOfNew--] = string[indexOfOriginal];

            indexOfOriginal--;

        }
//      System.out.println(string);

    }

    public static void main(String [] args){

        String s = "We are happy.";
        int length = 20;

        char [] str = new char[length];
        for (int i = 0; i < s.length(); i++)
            str [i] = s.charAt(i);

        ReplaceSpaces rs = new ReplaceSpaces();
        rs.ReplaceBlank(str, length);
//      System.out.println(str);
        for (int i = 0; str[i] != '.'; i++)
            System.out.print(str[i]);
        System.out.println('.');

    }

}
