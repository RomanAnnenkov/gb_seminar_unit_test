package view;

import model.NumberListComparison;
import model.listCreator.INumberListCreator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsoleViewTest {

    @Test
    void testRun() {
        INumberListCreator listCreator = mock(INumberListCreator.class);
        NumberListComparison listComparison = mock(NumberListComparison.class);
        ConsoleView consoleView = new ConsoleView(listCreator, listComparison);
        when(listCreator.createList()).thenReturn(Arrays.asList(1, 1, 1));
        when(listComparison.compare(listCreator.createList(), listCreator.createList())).
                thenReturn(0).
                thenReturn(1).
                thenReturn(-1);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream modifiedSystemOut = new PrintStream(byteArrayOutputStream);
        PrintStream standardSystemOut = System.out;
        System.setOut(modifiedSystemOut);

        consoleView.run();
        String[] strings = byteArrayOutputStream.toString().split("\n");
        assertEquals("Средние значения равны.", strings[strings.length - 1]);

        consoleView.run();
        strings = byteArrayOutputStream.toString().split("\n");
        assertEquals("Первый список имеет большее среднее значение.", strings[strings.length - 1]);

        consoleView.run();
        strings = byteArrayOutputStream.toString().split("\n");
        assertEquals("Второй список имеет большее среднее значение.", strings[strings.length - 1]);

        System.setOut(standardSystemOut);
    }
}