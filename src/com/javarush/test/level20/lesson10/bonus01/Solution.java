package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Collections;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args)
    {
        long memoryStart = Runtime.getRuntime().totalMemory();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long memoTaken = memoryStart - memoryEnd;
        Long t1 = System.currentTimeMillis();

        int [] vivod = getNumbers(100000000);
        for (int i = 0; i < vivod.length; i++)
        {
            System.out.println(vivod[i]);
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) / 1000d + " sec");
        System.out.println("memory: " + memoTaken/1024d/1024d + " MBytes");

    }

    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //otbor
//        for (int i = 1; i < N ; i++)
//        {
//          if (otbor_chisel(i)) list_otbor.add(i);
//        }
//
//        System.out.println(list_otbor.size());
        for (int i = 1; i < N; i++)
        {

            String s = ""+i;
            int stepen = s.length();
            int temp = i, r, sum = 0;
            while( temp != 0 )
            {
                r = temp%10;
                sum = sum + v_stepen(r, stepen);
                temp = temp/10;
            }

            if ( i == sum ) list.add(i);
        }
//        for (int i = 1; i < N; i++)
//        {
//            String s = "" + i;
//            char [] cifri = s.toCharArray();
//
//            if (chisla(cifri))
//            {
//                int summa = 0;
//                for (int j = 0; j < cifri.length; j++)
//                {
//                  summa += v_stepen(Integer.parseInt("" + cifri[j]), cifri.length);
//
//                }
//                if (i == summa) list.add(i);
//            }
//
//        }
//        int[] result = null;
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
        {
           result[i] = list.get(i);
        }
        return result;
    }

    public static int v_stepen (int x, int y)
    {   int itog = 1;
        for (int i = 1; i <= y; i++)
        {
           itog *= x;
        }
        return itog;
    }

//    public static boolean chisla (char [] cifri){

//    public static boolean otbor_chisel (int n){
//
//        String s = "" + n;
//        char [] cifri = s.toCharArray();
//        int [] massiv_cifr = new int[cifri.length];
//        for (int i = 0; i < massiv_cifr.length; i++)
//        {
//           massiv_cifr[i] = Integer.parseInt(""+cifri[i]);
//        }
//
//        for (int i = 1; i < massiv_cifr.length; i++)
//        {
//            if (i+1 == massiv_cifr.length) break;
//            if (massiv_cifr[i-1] > massiv_cifr[i] || massiv_cifr[i+1] < massiv_cifr[i]) return false;
//
//        }
//
//        return true;
//    }
}
