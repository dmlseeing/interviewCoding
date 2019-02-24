// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。


public class FindInPartiallySortedMatrix {

    boolean Find(int [] matrix, int rows, int columns, int number){

        boolean found = false;

        if (matrix != null && rows > 0 && columns > 0){

            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0){

                if (matrix [row * columns + column] == number){
                    found = true;
                    break;
                }
                else if (matrix [row * columns + column] > number)
                    column--;
                else
                    row++;

            }

        }

        return found;

    }

    public static void main(String [] args){
//      C语言的一维数组和二维数组与Java的运用不同
//      int [][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int [] matrix = {1,2,8,9,2,4,9,12,4,7,10,13,6,8,11,15};
//      int [] matrix = null;
        int number = 7;
//      int number = 16;
        boolean isFind = new FindInPartiallySortedMatrix().Find(matrix, 4, 4, number);
        System.out.println(isFind);

    }

}
