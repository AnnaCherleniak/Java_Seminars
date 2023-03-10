package lesson0303;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        arrMinAndMax();
        transferArrayElement();
        hiTimeDay();

    }


    //    Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static void arrMinAndMax() {
        int[] arr = {5, -12, 22, 14, 7};
        int elMax = arr[0];
        int elMin = arr[0];
        for (int el : arr) {
            if (el > elMax) {
                elMax = el;
            } else if (el < elMin) {
                elMin = el;
            }
        }
        System.out.printf("Minimum array element: %d%n", elMin);
        System.out.printf("Maximum array element: %d%n", elMax);
    }


//    Дан массив nums = [3,2,2,3] и число val = 3.
//    Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//    Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

    public static void transferArrayElement() {
        int[] arr = {3, 2, 1, 3, 0, 3, 2};
        int val = 3;
        int i = 0;
        int j = arr.length - 1;
        int temp = 0;
        while (i < j) {
            if (arr[i] == val && arr[j] == val) {
                j--;
            } else if (arr[i] == val) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            } else if (arr[j] == val) {
                j--;
            }
            i++;
        }
        for (int el : arr) {
            System.out.printf("%d ", el);
        }
        System.out.println();
    }


    //    В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    public static void hiTimeDay() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (hour >= 5 && hour < 12) {
            System.out.printf("GoodMorning, %s!", name);
        } else if (hour >= 12 && hour < 18) {
            System.out.printf("GoodAfternoon, %s!", name);
        } else if (hour >= 18 && hour < 23) {
            System.out.printf("GoodEvening, %s!", name);
        } else if (hour < 5 || hour == 23) {
            System.out.printf("GoodNight, %s!", name);
        }
        System.out.println();
    }

}