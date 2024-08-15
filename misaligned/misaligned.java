import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class misaligned {
    static String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};


    static int printColorMap(Function<String, Void> printFn) {

        int i = 0, j = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                printFn.apply(getColorComboInfo(i, i));
            }
        }

        return i * j;
    }

    static String getColorComboInfo(int majorIndex, int minorIndex) {
        return (majorIndex * 5 + minorIndex) + " | " + majorColors[majorIndex] + " | " + minorColors[majorIndex] + "\n";
    }


    public static void main(String[] args) {
        int result = printColorMap(new PrintOnConsole());
        assert (result == 25);
        PrintOnConsoleMock printOnConsoleMock = new PrintOnConsoleMock();
        printColorMap(printOnConsoleMock);
        List<String> colorComboInfoList = printOnConsoleMock.getColorComboList();

        assert (colorComboInfoList.get(0).equals(0 + " | White | Blue"));
        assert (colorComboInfoList.get(1).equals(1 + " | White | Orange"));
        assert (colorComboInfoList.get(2).equals(2 + " | White | Green"));
        assert (colorComboInfoList.get(3).equals(3 + " | White | Brown"));
        assert (colorComboInfoList.get(4).equals(4 + " | White | Slate"));
        assert (colorComboInfoList.get(5).equals(5 + " | Red | Blue"));
        assert (colorComboInfoList.get(6).equals(6 + " | Red | Orange"));
        assert (colorComboInfoList.get(7).equals(7 + " | Red | Green"));
        assert (colorComboInfoList.get(8).equals(8 + " | Red | Brown"));
        assert (colorComboInfoList.get(9).equals(9 + " | Red | Slate"));
        assert (colorComboInfoList.get(10).equals(10 + " | Black | Blue"));
        assert (colorComboInfoList.get(11).equals(11 + " | Black | Orange"));
        assert (colorComboInfoList.get(12).equals(12 + " | Black | Green"));
        assert (colorComboInfoList.get(13).equals(13 + " | Black | Brown"));
        assert (colorComboInfoList.get(14).equals(14 + " | Black | Slate"));
        assert (colorComboInfoList.get(15).equals(15 + " | Yellow | Blue"));
        assert (colorComboInfoList.get(16).equals(16 + " | Yellow | Orange"));
        assert (colorComboInfoList.get(17).equals(17 + " | Yellow | Green"));
        assert (colorComboInfoList.get(18).equals(18 + " | Yellow | Brown"));
        assert (colorComboInfoList.get(19).equals(19 + " | Yellow | Slate"));
        assert (colorComboInfoList.get(20).equals(20 + " | Violet | Blue"));
        assert (colorComboInfoList.get(21).equals(21 + " | Violet | Orange"));
        assert (colorComboInfoList.get(22).equals(22 + " | Violet | Green"));
        assert (colorComboInfoList.get(23).equals(23 + " | Violet | Brown"));
        assert (colorComboInfoList.get(24).equals(24 + " | Violet | Slate"));
        System.out.println("All is well (maybe!)");
    }
}

class PrintOnConsole implements Function<String, Void> {

    @Override
    public Void apply(String s) {
        System.out.println(s);
        return null;
    }
}

class PrintOnConsoleMock implements Function<String, Void> {
    List<String> colorComboList;

    PrintOnConsoleMock() {
        colorComboList = new ArrayList<>();
    }

    @Override
    public Void apply(String colorInfo) {
        colorComboList.add(colorInfo);
        System.out.println(colorInfo);
        return null;
    }

    public List<String> getColorComboList() {
        return colorComboList;
    }
}

