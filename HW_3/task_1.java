package HW_3;

import java.util.Scanner;

public class task_1 {
    
    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = iScanner.nextInt();
        int[] array = new int[size];
        
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < array.length ; i++) {
            array[i] = iScanner.nextInt();
        }
        iScanner.close();

        printArray(sortArray(array));
    }

    public static int[] sortArray(int[] array){
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }

        // разбиваем массив на две половинки
        int[] arrayL = new int[array.length / 2];
        System.arraycopy(array, 0, arrayL, 0, array.length / 2);
        int[] arrayR = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayR, 0, array.length - array.length / 2);

        // крутим рекурсию, пока не разобьём всё на массивы из одного (или нуля) элемента каждый
        arrayL = sortArray(arrayL);
        arrayR = sortArray(arrayR);

        // тут запускаем ещё одну рекурсию, в которой собираем обратно массив, попутно сортируя
        return mergeArray(arrayL, arrayR);
    }

    public static int [] mergeArray(int[] arrayL, int[] arrayR) {
        int[] result = new int[arrayL.length + arrayR.length];
        int indexL = 0, indexR = 0;

        for (int i = 0; i < result.length; i++) {
            // если весь левый массив скопирован, просто копируем правый
            if (indexL == arrayL.length){
                result[i] = arrayR[indexR];
                indexR++;
            }
            // если весь правый массив скопирован, просто копируем левый
            else if (indexR == arrayR.length) {
                result[i] = arrayL[indexL];
                indexL++;
            } 
            // если эл-нт из левого массива меньше - берём его
            else if (arrayL[indexL] < arrayR[indexR]) {
                result[i] = arrayL[indexL];
                indexL++;
            }
            // если эл-нт из правого массива меньше - берём его
            else {
                result[i] = arrayR[indexR];
                indexR++;
            }
        }
        return result;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}