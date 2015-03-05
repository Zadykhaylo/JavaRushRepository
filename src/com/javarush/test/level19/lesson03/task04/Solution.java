package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scan;
        public PersonScannerAdapter (Scanner scanner){
              this.scan = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            Person person=null;
            if(scan.hasNext()){

                String last = scan.next();
                String first = scan.next();
                String middle = scan.next();
                int day = scan.nextInt();
                int month = scan.nextInt()-1;
                int year = scan.nextInt();
                Calendar date = new GregorianCalendar(year, month, day);
                person = new Person(first, middle, last,date.getTime());
            }

            return person;
        }

        @Override
        public void close() throws IOException
        {
            this.scan.close();
        }
    }
}
