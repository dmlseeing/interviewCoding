// 面试题2：实现Singleton模式
// 题目：设计一个类，我们只能生成该类的一个实例。
// 这道题目不太懂，特别是lock和get的用法
// 题中public和private的设置原因也尚未理清
// 为什么只有Singleton4会打印An instance of Singleton4 is created？


import static sun.misc.GThreadHelper.lock;

public class Singleton {

    public static void main(String [] args){
//        Singleton1 str = new Singleton1();
//        System.out.println(Singleton1.Print());
//        System.out.println(Singleton1.Instance());

        Singleton1.Print();
        Singleton2.Print();
        Singleton3.Print();
        Singleton4.Print();
        Singleton5.Print();
    }

}


final class Singleton1 {
//public final class Singleton1{

//  public void Singleton1()
    private Singleton1()
    {
        System.out.println("An instance of Singleton1 is created.");
    }

    public static void Print(){
        System.out.println("Singleton1 Print");
    }

    private static Singleton1 instance = null;
    public static Singleton1 Instance(){
        if (instance == null)
            instance = new Singleton1();
        return instance;
    }

}


final class Singleton2 {

    private Singleton2()
    {
        System.out.println("An instance of Singleton2 is created.");
    }

    public static void Print(){
        System.out.println("Singleton2 Print");
    }

    private static Object syncObj = new Object();
//  private static Singleton2 syncObj = new Singleton2();

    private static Singleton2 instance = null;
    public static Singleton2 Instance(){
        lock();
        if (instance == null)
            instance = new Singleton2();

        return instance;
    }

}


final class Singleton3 {

    private Singleton3()
    {
        System.out.println("An instance of Singleton3 is created.");
    }

    public static void Print(){
        System.out.println("Singleton3 Print");
    }

    private static Object syncObj = new Object();

    private static Singleton3 instance = null;
    public static Singleton3 Instance(){
        if (instance == null){
            lock();
            if (instance == null)
                instance = new Singleton3();
        }

        return instance;
    }

}


final class Singleton4 {

    private Singleton4()
    {
        System.out.println("An instance of Singleton4 is created.");
    }

    public static void Print(){
        System.out.println("Singleton4 Print");
    }

    private static Singleton4 instance = new Singleton4();
    public static Singleton4 Instance(){
        return instance;
    }

}


final class Singleton5 {

    Singleton5()
    {
        System.out.println("An instance of Singleton5 is created.");
    }

    public static void Print(){
        System.out.println("Singleton5 Print");
    }

//  public static Singleton5 Instance(){
    public Singleton5 Instance(){
        return Nested.instance;
    }

}


class Nested {

//  static Nested()
    Nested()
    {
    }

//    Singleton5 instance = new Singleton5();
      static Singleton5 instance = new Singleton5();

}


//参考知识点：
//sealed用法（继承）：https://xiaotao-2010.iteye.com/blog/1723038
//C#中Internal关键字的总结:https://www.cnblogs.com/wowoblog/p/6970502.html
//C#中readonly关键字的总结:https://docs.microsoft.com/zh-cn/dotnet/csharp/language-reference/keywords/readonly