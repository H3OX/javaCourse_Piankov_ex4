import java.util.*;
import java.util.stream.Stream;


public class task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите три элемента первой строки через пробел:");
        String[] firstLine = s.nextLine().split(" ");
        Integer[] firstLineInt = Stream.of(firstLine).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        System.out.println("Введите три элемента второй строки через пробел:");
        String[] secondLine = s.nextLine().split(" ");
        Integer[] secondLineInt = Stream.of(secondLine).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(secondLineInt));

        System.out.println("Введите три элемента третьей строки через пробел:");
        String[] thirdLine = s.nextLine().split(" ");
        Integer[] thirdLineInt = Stream.of(thirdLine).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        System.out.println("Введите три элемента четвертой строки через пробел:");
        String[] fourthLine = s.nextLine().split(" ");
        Integer[] fourthLineInt = Stream.of(fourthLine).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Integer[][] twoDimArr = new Integer[][]{firstLineInt, secondLineInt, thirdLineInt, fourthLineInt};
        sumOfLine(twoDimArr);
        sumOfColumn(twoDimArr);
        avg(twoDimArr);
        flattenFlip(twoDimArr);

    }
    // Программа, которая выводит номера строк и суммы их элементов
    public static void sumOfLine(Integer[][] arr) {
        for (int x=0; x < 4; x++) {
            System.out.println("Line: " + x + " Sum:" + Arrays.stream(arr[x]).mapToInt(i -> i).sum());
        }
    }
    // Программа, которая выводит номера столбцов и суммы их элементов
    public static void sumOfColumn(Integer[][] arr) {
        for (int x=0; x < 4; x++) {
            int sumCol = 0;
            for (int y=0; y < 3; y++) {
                sumCol += arr[y][x];
            }
            System.out.println("Sum of column " + x + ": " + sumCol);
        }
    }
    // Программа, которая заменяет все нечётные элементы массива на 1, а чётные на 0 и выводит его на экран.
    public static void intSwap(Integer[][] arr) {
        for (int x=0; x < 4; x++) {
            for (int y=0; y<3; y++) {
                if (arr[x][y] % 2 == 0) {
                    arr[x][y] = 0;
                }
                else {
                    arr[x][y] = 1;
                }
            }
        }
    }
    // Программма, которая находит среднее арифметическое для каждой строки
    public static void avg(Integer[][] arr) {
        for (int x=0; x < 4; x++) {
            System.out.println("Line " + x + " average = " + Arrays.stream(arr[x]).mapToDouble(a -> a).average().getAsDouble());
        }
    }
    // Программа, которая преобразует двумерный массив в одномерный и выводит его в обратном порядке
    public static void flattenFlip (Integer[][] arr) {
        ArrayList<Integer> flattenedArr = new ArrayList<Integer>();
        for (int x=0; x < arr.length; x++) {
            for (int y=0; y < arr[x].length; y++) {
                flattenedArr.add(arr[x][y]);
            }
        }
        Collections.reverse(flattenedArr);
        System.out.println(flattenedArr);
    }

}
