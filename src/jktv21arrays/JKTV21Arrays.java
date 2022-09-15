/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv21arrays;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author pupil
 */
public class JKTV21Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("--- Odnomernqe massivq ---");
        int n = 5;
        int[] nums = new int[n];
        for (int i = 0; i<nums.length;i++){
            nums[i] = random.nextInt(n);
        }
        //Arrays.sort(nums);
        int sum = 0;
        int min = n;
        int max = 0;
        for (int i = 0; i<nums.length;i++){
            System.out.printf("%2d,",nums[i]);
            sum += nums[i];
            if(min > nums[i]) min = nums[i];
            if(max < nums[i]) max = nums[i];
        }
        System.out.println("");
        System.out.println("sum = " + sum);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        /*=============================================*/
        System.out.println("--- Двухмерный массив ---");
        
        int [][] nums2 = new int[n][n]; // массив с исходными данными
        int [][] nums3 = new int[3][n]; // массив для строк
        //nums3[0][] - суммы по строкам массива nums2 ,
        //nums3[1][] - минимальные значения по строкам
        //nums3[2][] - максимальные значения по строкам
        Arrays.fill(nums3[1], n); 
        int [][] nums4 = new int[3][n]; // массив для столбцов
        //nums4[0][] - суммы по столбцам массива nums2 ,
        //nums4[1][] - минимальные значения по столбцам
        //nums4[2][] - максимальные значения по столбцам
        Arrays.fill(nums4[1], n);
        int sumTotal = 0, minTotal = n, maxTotal = 0; // для nums2
        int sumDn = 0, minDn = n, maxDn = 0; // для нисходящей диагонали
        int sumDv = 0, minDv = n, maxDv = 0; // для восходящей диагонали
        for (int i = 0; i < nums2.length; i++){
            for (int j = 0; j<nums2[i].length;j++){
                nums2[i][j] = random.nextInt(n); 
                sumTotal += nums2[i][j];
                if(minTotal > nums2[i][j]) minTotal = nums2[i][j];
                if(maxTotal < nums2[i][j]) maxTotal = nums2[i][j];
                // по строке
                nums3[0][i] += nums2[i][j];
                if(nums3[1][i] > nums2[i][j]) nums3[1][i] = nums2[i][j];
                if(nums3[2][i] < nums2[i][j]) nums3[2][i] = nums2[i][j];
                // по столбцу
                nums4[0][j] += nums2[i][j];
                if(nums4[1][j] > nums2[i][j]) nums4[1][j] = nums2[i][j];
                if(nums4[2][j] < nums2[i][j]) nums4[2][j] = nums2[i][j];
                // по нисходящей диагонали
                if (i == j){
                    sumDn += nums2[i][j];
                    if(minDn > nums2[i][j]) minDn = nums2[i][j];
                    if(maxDn < nums2[i][j]) maxDn = nums2[i][j];
                }
                // по восходящей диагонали
                if (j == n-1-i){
                    sumDv += nums2[i][j];
                    if(minDv > nums2[i][j]) minDv = nums2[i][j];
                    if(maxDv < nums2[i][j]) maxDv = nums2[i][j];
                }
            }
        }
        System.out.println("Исходный массив:");
        for (int i = 0; i<nums2.length;i++){
            for (int j = 0; j<nums2[i].length;j++){
                System.out.printf("%3d",nums2[i][j]);
            }
            System.out.println();
        }
        System.out.println("---- В массиве----");
        System.out.printf("Сумма всех элементов  = %3d%n", sumTotal);
        System.out.printf("Минимальное значение  = %3d%n",minTotal);
        System.out.printf("Максимальное значение = %3d%n", maxTotal);
        System.out.println("---- Нисходящяя диагональ ----");
        System.out.printf("Сумма всех элементов  = %3d%n", sumDn);
        System.out.printf("Минимальное значение  = %3d%n",minDn);
        System.out.printf("Максимальное значение = %3d%n", maxDn);
        System.out.println("---- Восходящяя диагональ ----");
        System.out.printf("Сумма всех элементов  = %3d%n", sumDv);
        System.out.printf("Минимальное значение  = %3d%n",minDv);
        System.out.printf("Максимальное значение = %3d%n", maxDv);
        System.out.println("---- Данные по строкам ----");
        for (int i = 0; i<nums2.length;i++){
            System.out.printf("Строка %2d : sum =%3d, min =%3d, max =%3d%n", i+1, nums3[0][i], nums3[1][i], nums3[2][i]);
        }
        System.out.println("---- Данные по столбцам ----");
        for (int i = 0; i<nums2.length;i++){
            System.out.printf("Строка %2d : sum =%3d, min =%3d, max =%3d%n", i+1, nums4[0][i], nums4[1][i], nums4[2][i]);
        }
//        System.out.println();
    }
    
}
