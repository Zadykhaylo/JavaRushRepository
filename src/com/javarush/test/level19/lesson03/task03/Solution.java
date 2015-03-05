package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData incomeData;
        public IncomeDataAdapter (IncomeData incomeData){
            this.incomeData = incomeData;
        }

        public String getName()
        {
            return this.incomeData.getContactLastName()  + ", " + this.incomeData.getContactFirstName();
        }

        public String getPhoneNumber()
        {
            String phoneNumber = this.incomeData.getPhoneNumber() + "";
            if (phoneNumber.length() < 11)
            {
                while (phoneNumber.length() < 10) phoneNumber = "0" + phoneNumber;
            }

            //example +38(050)123-45-67
            return "+" + this.incomeData.getCountryPhoneCode()+ "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 8) + "-" + phoneNumber.substring(8);
        }

        public String getCompanyName()
        {
            return this.incomeData.getCompany();
        }

        public String getCountryName()
        {
            String countryName = null;

            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (pair.getKey().equals(this.incomeData.getCountryCode())) countryName = pair.getValue();

            }
            return countryName;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //*example UA
        String getCompany();            //*example JavaRush Ltd.
        String getContactFirstName();   //*example Ivan
        String getContactLastName();    //*example Ivanov
        int getCountryPhoneCode();      //*example 38
        int getPhoneNumber();           //*example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}