package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:\\file1.txt");
            InputStream inputStream = new FileInputStream("d:\\file1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            for (int i = 0; i < somePerson.assets.size(); i++)
            {
                System.out.println(somePerson.assets.get(i).getName());
                System.out.println(somePerson.assets.get(i).getPrice());
            }

            System.out.println(ivanov.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            String isAssets = assets != null ? "yes" : "no";
            printWriter.println(isAssets);
            printWriter.println(assets.size());
            if (assets != null)
            {
                for (int i = 0; i < assets.size(); i++)
                {
                    printWriter.println(assets.get(i).getName());
                    printWriter.println(assets.get(i).getPrice());
                }
            }
            printWriter.close();
           //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            String isAssets = reader.readLine();
            if (isAssets.equals("yes"))
            {
                int number = Integer.parseInt(reader.readLine());
                {
                    int n = 0;
                    while (n < number)
                    {
                        Asset assett = new Asset(reader.readLine());
                        assett.setPrice(Double.parseDouble(reader.readLine()));
                        assets.add(assett);
                        n++;
                    }
                }
            }
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }
}
