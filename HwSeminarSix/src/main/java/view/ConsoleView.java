package view;

import model.listCreator.INumberListCreator;
import model.NumberListComparison;

import java.util.List;

public class ConsoleView implements IView {

    private final NumberListComparison numberListComparison;
    private final INumberListCreator listCreator;

    public ConsoleView(INumberListCreator listCreator, NumberListComparison numberListComparison) {
        this.listCreator = listCreator;
        this.numberListComparison = numberListComparison;
    }

    @Override
    public void run() {
        System.out.println("Программа для сравнения двух списков чисел.");
        List<Integer> firstList = listCreator.createList();
        System.out.println("Первый список: " + firstList.toString());
        List<Integer> secondList = listCreator.createList();
        System.out.println("Второй список: " + secondList.toString());
        int compareValue = numberListComparison.compare(firstList,secondList);
        if (compareValue > 0) {
            System.out.println("Первый список имеет большее среднее значение.");
        }
        if (compareValue < 0) {
            System.out.println("Второй список имеет большее среднее значение.");
        }
        if (compareValue == 0) {
            System.out.println("Средние значения равны.");
        }

    }
}
