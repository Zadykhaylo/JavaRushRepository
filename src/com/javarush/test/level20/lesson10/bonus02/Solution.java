package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int k = 0;  //nach_string
        int d = 0;  //kon_string
        int m = 0;  //nach_column
        int n = 0;  //kon_column
        int z = 0;

        while (true){

            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a[i].length; j++)
                {
                    if (a[i][j] == 1) {k = i; m = j; z = 1; break;}
                }
                if (z != 0) break;
            }

            if (z == 0 ) break;

            for (int i = k; i < a.length; i++)
            {
                if (a[i][m] == 0) {d = i-1; break;}
                if (i == a.length - 1) {d = i; break;}

            }
            for (int i = m; i < a[k].length; i++)
            {
                if (a[k][i] == 0)  {n = i-1; break;}
                if (i == a[k].length - 1) {n = i; break;}
            }

            count++;
            obnul(a, k, d, m, n);

            k =0; d = 0; m = 0; n = 0;  z = 0;
        }

        return count;
    }

    //    obnulenie rectangle
    public static byte [][] obnul (byte[][] a, int k, int d, int m, int n){
        for (int i = k; i <= d; i++)
        {
            for (int j = m; j <= n; j++)
            {
                a[i][j] = 0;
            }
        }
        return a;
    }
}