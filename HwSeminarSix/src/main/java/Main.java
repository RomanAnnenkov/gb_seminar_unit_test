import model.ArithmeticAverage;
import model.listCreator.INumberListCreator;
import model.NumberListComparison;
import model.listCreator.RandomNumbersList;
import view.ConsoleView;
import view.IView;

public class Main {
    public static void main(String[] args) {
        NumberListComparison numberListComparison = new NumberListComparison(new ArithmeticAverage());
        INumberListCreator listCreator = new RandomNumbersList(3, 1, 20);
        IView view = new ConsoleView(listCreator, numberListComparison);
        view.run();
    }
}
