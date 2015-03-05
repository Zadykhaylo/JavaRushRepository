package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private static final long serialVersionUID = 1L;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public static void main(String[] args) throws Exception
    {
        Solution solution1 = new Solution("D:\\file1.txt");
        solution1.writeObject("Hi-Hi");
        solution1.close();


        FileOutputStream fileOutputStream = new FileOutputStream("D:\\file2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\file2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        solution2.writeObject("Hi-Hi-Hi");
    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        out.flush();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        fileName = (String)in.readObject();
        FileInputStream myFile = new FileInputStream(fileName);
        int[] buffer = new int[myFile.available()];
        int i = 0;
        while (myFile.available() > 0)
        {
            buffer[i] = myFile.read();
            i++;
        }
        myFile.close();

        FileOutputStream myFile11 = new FileOutputStream(fileName);
        for (int j = 0; j < buffer.length; j++)
        {
            myFile11.write(buffer[j]);
        }

        stream = myFile11;
//        in.close();

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
