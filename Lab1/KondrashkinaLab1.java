package kondrashkinalab1;
/**
 *
 * @author Ksenya Kondrashkina
 */
public class KondrashkinaLab1 {
//0. Создать main класс
    public static void main(String[] args) { 
        int size = 5, border_down = 0, border_up = 9;
    /* Task 1
    1. Работа с массивами:
        а)Создать массив целочисленных чисел длинной в 5 единиц
        б)Создать зеркальную копию массива с помощью цикла for 
        в)Вывести массив на экран. */      
        int [] arr = new int [size];
        for (int i =0; i < size; ++i){
            arr[i] = (int)(Math.random() * (border_up-border_down) + border_down);
        }
        Task1(arr);
        
    /* Task 2
    2. Работа с матрицами:
        а) Создать матрицу 5х5
        б)Посчитать сумму диагоналей
        в)Посчитать сумму цифр по периметру. */
        int [][] matrix = new int [size][size];
        for (int i =0; i < size; ++i){
            for (int j=0; j < size; ++j){
                matrix[i][j] = (int)(Math.random() * (border_up-border_down) + border_down);
            }
        }
        Task2(matrix);
    
    /*Task 3
    3. Создать шахматную доску из символов 'X', 'Y' и
       вывести её на экран, номеруя каждую строчку и столбец. */
        Task3(15);
    }
    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }
    public static void PrintMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i =0; i < n; ++i){
            int nTemp = matrix[i].length;
            for (int j = 0; j < nTemp; ++j){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void PrintMatrix(char[][] matrix) {
        int n = matrix.length + 1;
        int sizeForChess =0, dimension=n;
        while (dimension > 0) {
            dimension/=10;
            sizeForChess++;
        }
        for (int i =0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                int sizeJ = 0, sizeI = 0, tempJ = j, tempI = i;
                while (tempJ > 0) {
                    tempJ/=10;
                    sizeJ++;
                }
                while (tempI > 0) {
                    tempI/=10;
                    sizeI++;
                }
                if (i == 0 && j == 0) {
                    System.out.print(String.format(" %s", ' '));
                    for (int z = 0; z < sizeForChess; ++z){
                        System.out.print(" ");
                    }
                } else if (i == 0) {
                    System.out.print(String.format(" %s", j));
                    for (int z = 0; z < (sizeForChess-sizeJ); ++z){
                        System.out.print(" ");
                    }
                } else if (j == 0) {
                    System.out.print(String.format(" %s", i));
                    for (int z = 0; z < (sizeForChess-sizeI); ++z){
                        System.out.print(" ");
                    }
                } else {
                    for (int z = 0; z < sizeForChess-1; ++z){
                        System.out.print(" ");
                    }
                    System.out.print(String.format(" %s", matrix[i-1][j-1]));
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[] Task1(int[] arr) {
        int n =arr.length;
        int [] arrCopy = new int [n];
        for (int i = 0; i < n; ++i){
            arrCopy[i] = arr[n - i - 1];
        }
        System.out.println("Task 1.\nNormal massive:");
        PrintArr(arr);
        System.out.println("\nMirror massive:");
        PrintArr(arrCopy);
        return arr;
    }
    public static void Task2(int[][] matrix) {
        System.out.println("\n\nTask2.\nMatrix: ");
        PrintMatrix(matrix);
        int sum = 0, n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                //если символы стоят в диагонали верхний правый угол - нижний левый угол
                if (i + j == n - 1) {
                    sum += matrix[i][j];
                }
                //если символы стоят в диагонали нижний правый угол - верхний левый угол
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("Sum of the diagonals: " + sum);
        int sum2 = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                //если символы стоят в "граничных" клетках
                if (i == 0 | i == n - 1 | j == 0 | j == n - 1) {
                    sum2 += matrix[i][j];
                }
            }
        }
        System.out.println("Sum around the perimeter: " + sum2);
    }
    public static void Task3(int size) {
       
        char [][] board = new char [size][size];
        //заполняем таблицу символами: X, Y
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                //сначала ставим в первую непронумерованную ячейку доски символы
                //Х на нечётные строки, Y на чётные строки
                //затем заполняем строку чередующимися символами
                if (j == 0 && i%2 == 0) {
                    board[i][j] = 'X';
                }else if (j ==0){
                    board[i][j] = 'Y';
                } else if (board[i][j-1] == 'X'){
                    board[i][j] = 'Y';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println("\nTask 3.\nChess board: ");
        PrintMatrix(board);
    }
}