package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static void main(String[] args)
    {
        Car car = new Car();
        for (int i = 0; i < car.wheels.size(); i++)
        {
            System.out.println(car.wheels.get(i));
        }
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<>();
            try {
            for (int i = 0; i < loadWheelNamesFromDB().length; i++)
            {
                wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[i]));
            }

            if (wheels.size() != 4) throw new IllegalArgumentException();

            int fl = 0, fr = 0, bl = 0, br = 0;
            for (int i = 0; i < wheels.size(); i++)
            {
               switch (wheels.get(i)){
                   case FRONT_RIGHT: fr++;
                   case FRONT_LEFT: fl++;
                   case BACK_RIGHT: br++;
                   case BACK_LEFT: bl++;
               }
            }
//            if (fr !=1 || fl !=1 || br != 1 || bl != 1) throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("что-то не то с колесами");
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
