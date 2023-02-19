package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;

public class Calculator {
    public static double x;
    public static double y;
    @Дано("число {double} и число {double}")
    public static void число_и_число(Double numx, Double numy){
        x = numx;
        y = numy;
    }

    @Тогда("^Вывести результат$")
    public void Вывести_результат(){
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("x+y=" + (x+y));
    }
}
