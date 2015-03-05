package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> www = detectAllWords(crossword, "home", "same", "po");
        for (int i = 0; i < www.size(); i++)
        {
            System.out.println(www.get(i));
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> result = new ArrayList<Word>();
        ArrayList<String> slova = new ArrayList<String>();
        for(String s : words)
        {
            slova.add(s);
        }

        ArrayList<String> koorditi_first_letter = new ArrayList<String>();
        for (int i = 0; i < slova.size(); i++)
        {
            int first = (int) slova.get(i).charAt(0);

            for (int t = 0; t < crossword.length; t++)
            {
                for (int j = 0; j < crossword[i].length; j++)
                {
                    if (crossword[t][j] == first) koorditi_first_letter.add(slova.get(i) + " " + t + " " + j);
                }
            }
        }
        for (int i = 0; i < koorditi_first_letter.size(); i++)
        {
            ArrayList<Word> vse_dlja_odnoj = vse_slova(crossword, koorditi_first_letter.get(i));
            for (int j = 0; j < vse_dlja_odnoj.size(); j++)
            {
               result.add(vse_dlja_odnoj.get(j));
            }
        }
        return result;
    }

    public static ArrayList<Word> vse_slova (int[][] crossword, String s){
        ArrayList<Word> vo_vse_storoni = new ArrayList<Word>();
        String [] slovo_koordinati = s.split(" ");
        String slovo = slovo_koordinati[0];
        int i = Integer.parseInt(slovo_koordinati[1]);
        int j = Integer.parseInt(slovo_koordinati[2]);
        int[][] step = new int[][]{
                {-1, -1, -1,  0, 0,  1, 1, 1},
                {-1,  0,  1, -1, 1, -1, 0, 1}
        };
        for (int k = 0; k < 8; k++)
        {
            String slovo2 = perebor(crossword, i, j, step[0][k], step[1][k], slovo);
            String [] sravnenie = slovo2.split(" ");
            if (slovo.equals(sravnenie[0]))    {
                Word w = sozdanie(sravnenie[0], j, i, Integer.parseInt(sravnenie[2]), Integer.parseInt(sravnenie[1]));
                vo_vse_storoni.add(w);
            }
        }

        return vo_vse_storoni;
    }
    public static String perebor (int[][] crossword, int i, int j, int iStep, int jStep, String slovo) {
        String s = "";
        while (i >= 0 && i <crossword.length && j >= 0 && j <crossword[i].length){

            s += (char)crossword[i][j];
            if (s.length() == slovo.length())
            {
                s += " " + i + " " + j;
                break;
            }
            j += jStep;
            i += iStep;
        }

    return s;
    }
    public static Word sozdanie (String s, int start1, int start2, int end1, int end2){
        Word word = new Word(s);
        word.setStartPoint(start1, start2);
        word.setEndPoint(end1, end2);
        return word;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
