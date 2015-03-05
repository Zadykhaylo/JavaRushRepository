package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        for (Column column : values()){
            if (column.isShown()) result.add(column);
        }

        Column [] arr = new Column[result.size()];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = result.get(i);
        }

        for (int j = 0; j < arr.length; j++)
        {
            for (int i = j+1; i < arr.length; i++)
            {
                if (realOrder[arr[i].ordinal()] < realOrder[arr[j].ordinal()])
                {
                    Column t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        result.clear();
        for (int i = 0; i < arr.length; i++)
        {
           result.add(arr[i]);
        }
        return result;
    }

    /**
     * @return полное имя колонки
     */
    public String getColumnName()
    {
        return columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    public boolean isShown()
    {
        return realOrder[this.ordinal()] != -1;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    public void hide()
    {
//        int n = realOrder[this.ordinal()];
        realOrder[this.ordinal()] = -1;
//        for (int i = 0; i < realOrder.length; i++)
//        {
//            if (realOrder[i] > n) realOrder[i] --;
//        }

    }

    /**
     * Возвращает порядок константы в энуме.
     *
     * @return порядок константы в энуме
     */
//    public int ordinal(){
//
//        return 0;
//    }



}
