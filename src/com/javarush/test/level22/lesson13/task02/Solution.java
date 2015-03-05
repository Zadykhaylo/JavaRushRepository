package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte [] buffer = new byte[inputStream.available()];
        int i = 0;
        while (inputStream.available() > 0)
        {
            buffer[i] = (byte) inputStream.read();
            i++;
        }
        String s = new String(buffer, utf8);
        byte [] buffer2 = s.getBytes(windows1251);
        String ss = new String(buffer2, windows1251);
        byte [] buffer3 = ss.getBytes(windows1251);
        outputStream.write(buffer3);
        System.out.println(s);
        System.out.println(ss);
//        if (inputStream.available() > 0) {
//            byte[] buffer = new byte[1000];
//            inputStream.read(buffer);
//            String s = new String(buffer, windows1251);
//            buffer = s.getBytes(utf8);
//            outputStream.write(buffer);
//        }
        inputStream.close();
        outputStream.close();

//        byte[] buf = win1251TestString.getBytes(windows1251);
//        System.out.println(win1251TestString);
//        String ss = new String(buf, utf8);
//        System.out.println(ss);


    }
}
