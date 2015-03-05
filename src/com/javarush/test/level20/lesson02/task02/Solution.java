package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);

            OutputStream outputStream = new FileOutputStream("D:\\file1.txt");
            InputStream inputStream = new FileInputStream("D:\\file1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            User user2 = new User();
            user2.setFirstName("Sidor");
            user2.setLastName("Sidorov");
            user2.setBirthDate(new Date());
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (int i = 0; i < loadedObject.users.size(); i++)
            {
                System.out.println(loadedObject.users.get(i).getFirstName());
                System.out.println(loadedObject.users.get(i).getLastName());
                System.out.println(loadedObject.users.get(i).getBirthDate());
                System.out.println(loadedObject.users.get(i).isMale());
                System.out.println(loadedObject.users.get(i).getCountry());
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUsers = users != null ? "yes" : "no";
            printWriter.println(isUsers);
            printWriter.println(users.size());
            if (users != null)
            {
                for (int i = 0; i < users.size(); i++)
                {
                    printWriter.println(users.get(i).getFirstName());
                    printWriter.println(users.get(i).getLastName());
                    printWriter.println(users.get(i).getBirthDate().getTime());
                    printWriter.println(users.get(i).isMale());
                    printWriter.println(users.get(i).getCountry());
                }
            }
            printWriter.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsers = reader.readLine();
            if (isUsers.equals("yes"))
            {
                int number = Integer.parseInt(reader.readLine());
                {
                    int n = 0;
                    while (n < number)
                    {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String country = reader.readLine();
                        if (country.equals("UKRAINE")) user.setCountry(User.Country.UKRAINE);
                        else if (country.equals("RUSSIA")) user.setCountry(User.Country.RUSSIA);
                             else user.setCountry(User.Country.OTHER);
                        users.add(user);
                        n++;
                    }
                }
            }
            reader.close();

            //implement this method - реализуйте этот метод
        }
    }
}
