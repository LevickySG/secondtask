package StepDefinition;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.Scanner;

public class Calculator {
    @Когда("^Пользователь вводит x$")
    public Double Пользователь_вводит_x() {
        Double x = 10.0;
        return x;
    }
    @Когда("^Пользователь вводит y$")
    public Double Пользователь_вводит_y(){
        Double y = 20.0;
        return y;
    }
    @Тогда("^Получить сумму$")
    public Double Получить_сумму(){
        return (Пользователь_вводит_x() + Пользователь_вводит_y());
    }
    @Затем("^Вывести результат$")
    public void Вывести_результат(){
        System.out.println("x=" + Пользователь_вводит_x());
        System.out.println("y=" + Пользователь_вводит_y());
        System.out.println("x+y=" + Получить_сумму());
    }
}
