// 面试题1：赋值运算符函数
// 题目：如下为类型CMyString的声明，请为该类型添加赋值运算符函数。


public class AssignmentOperator {

    public static void main(String[] args){
        CMyString str = new CMyString();
        String s = "Hello world";
        str.pData = new char [s.length()];
        for (int num = 0; num < s.length(); num++){
            str.pData[num] = s.charAt(num);
        }
        System.out.print("The expected result is:");
        System.out.println(str.pData);
        System.out.print("The actual result is:");
        System.out.println(str.operator(str).pData);
    }

}


class CMyString {
    public char [] pData = null;
//  CMyString str = new CMyString();
    static CMyString str = new CMyString();
//  static CMyString operator = str;
//  !!m_pData设为private，则在main函数中不能调用
    private char [] m_pData = null;

    public CMyString operator(CMyString str){
        if(this != str){
//          传入的str赋值给strTemp，所以不改变str的值
            CMyString strTemp = str;

//          交换strTemp.m_pData和m_pData的值，pTemp为临时实例
//          char [] pTemp = strTemp.pData;
            char [] pTemp = strTemp.m_pData;
//          strTemp.pData = m_pData;
            strTemp.m_pData = m_pData;
            m_pData = pTemp;

//          pTemp = null;
        }
        return this;
    }
}


//参考知识点：
//const关键字：https://blog.csdn.net/ls21206022021/article/details/83338859

//参考修改代码：
/*
public class AssignmentOperator {

    public static void main(String[] args){
        AssignmentOperator test = new AssignmentOperator();
        test.Test1();
        System.out.println();
        test.Test2();
        System.out.println();
        test.Test3();
    }

    void Test1(){
        System.out.println("Test1 begins:");

        String str = "Hello world";
        char [] text = new char [str.length()];
        for(int num = 0; num < text.length; num++){
            text[num] = str.charAt(num);
        }

        CMyString str1 = new CMyString();
        char [] str2 = str1.CMS1(text);

        System.out.print("The expected result is: ");
        for(int num = 0; num < text.length; num++) {
            System.out.print(text[num]);
        }

        System.out.println();

        System.out.print("The actual result is: ");
        for(int num = 0; num < str2.length; num++) {
            System.out.print(str2[num]);
        }

        System.out.println();

    }

    // 赋值给自己
    void Test2() {
        System.out.println("Test2 begins:");

        String str = "Hello world";
        char [] text = new char [str.length()];
        for(int num = 0; num < text.length; num++){
            text[num] = str.charAt(num);
        }

        CMyString str1 = new CMyString();
        char [] str2 = str1.CMS1(text);

        System.out.print("The expected result is: ");
        for(int num = 0; num < text.length; num++) {
            System.out.print(text[num]);
        }

        System.out.println();

        System.out.print("The actual result is: ");
        for(int num = 0; num < str2.length; num++) {
            System.out.print(str2[num]);
        }

        System.out.println();

    }

    // 连续赋值
    void Test3(){
        System.out.println("Test3 begins:");

        String str = "Hello world";
        char [] text = new char [str.length()];
        for(int num = 0; num < text.length; num++){
            text[num] = str.charAt(num);
        }

        CMyString str1 = new CMyString();
        char [] str2 = str1.CMS1(text);
        char [] str3 = str2;

        System.out.print("The actual result is: ");
        for(int num = 0; num < str2.length; num++) {
            System.out.print(str2[num]);
        }

        System.out.println();

        System.out.print("The expected result is: ");
        for(int num = 0; num < text.length; num++) {
            System.out.print(text[num]);
        }

        System.out.println();

        System.out.print("The actual result is: ");
        for(int num = 0; num < str3.length; num++) {
            System.out.print(str3[num]);
        }

        System.out.println();

    }

}

class CMyString{
    public char [] pData = null;
    static CMyString str = new CMyString();
    static CMyString operator = str;
    private char [] m_pData = null;

    public char [] CMS1(char [] pData){
        if(pData == null){
            m_pData = new char[1];
            m_pData[0] = '\0';
        }
        else{
            int length = pData.length;
            m_pData = new char[length + 1];
            m_pData = pData;
        }
        return m_pData;
    }

    public void CMS2(CMyString str){
        int length = str.m_pData.length;
        m_pData = new char[length + 1];
        m_pData = str.m_pData;
    }

    public void CMS3(){
        m_pData = null;
    }

    public CMyString CMS4(CMyString str){
        if (this == str)
            return this;

        m_pData = null;

        m_pData = new char[str.m_pData.length + 1];
        m_pData = str.m_pData;

        return this;
    }

    public void Print(){
        String string = null;
        for(int num = 0; num < m_pData.length; num++){
            string += m_pData[num];
        }
        System.out.println(string);
    }
}
*/