package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode()
        {
            String countryCod = null;

            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (pair.getValue().equals(this.customer.getCountryName())) countryCod = pair.getKey();
            }
            return countryCod;
        }

        public String getCompany()
        {
            return this.customer.getCompanyName();
        }

        public String getContactFirstName()
        {
            return this.contact.getName().substring(this.contact.getName().indexOf(' ') + 1 );
        }


        public String getContactLastName()
        {
            return this.contact.getName().substring(0, this.contact.getName().indexOf(','));
        }

        @Override
        public String getDialString()
        {
            String phoneNumber = this.contact.getPhoneNumber();
            String newNumber = "";
            char [] buf = phoneNumber.toCharArray();
            for (int i = 0; i < buf.length; i++)
            {
               if (buf[i] != '(' && buf[i] != ')' && buf[i] != '-') newNumber += buf[i];
            }
            return "callto://" + newNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //*example UA
        String getCompany();            //*example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //*example JavaRush Ltd.
        String getCountryName();        //*example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}