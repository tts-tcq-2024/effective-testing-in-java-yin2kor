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
        assert (getColorComboInfo(0,0).equals(1 + " | White | Blue"));
        assert (getColorComboInfo(0,1).equals(2 + " | White | Orange"));
        assert (getColorComboInfo(0,2).equals(3 + " | White | Green"));
        assert (getColorComboInfo(0,3).equals(4 + " | White | Brown"));
        assert (getColorComboInfo(0,4).equals(5 + " | White | Slate"));
        assert (getColorComboInfo(1,0).equals(6 + " | Red | Blue"));
        assert (getColorComboInfo(1,1).equals(7 + " | Red | Orange"));
        assert (getColorComboInfo(1,2).equals(8 + " | Red | Green"));
        assert (getColorComboInfo(1,3).equals(9 + " | Red | Brown"));
        assert (getColorComboInfo(1,4).equals(10 + " | Red | Slate"));
        assert (getColorComboInfo(2,0).equals(11 + " | Black | Blue"));
        assert (getColorComboInfo(2,1).equals(12 + " | Black | Orange"));
        assert (getColorComboInfo(2,2).equals(13 + " | Black | Green"));
        assert (getColorComboInfo(2,3).equals(14 + " | Black | Brown"));
        assert (getColorComboInfo(2,4).equals(15 + " | Black | Slate"));
        assert (getColorComboInfo(3,0).equals(16 + " | Yellow | Blue"));
        assert (getColorComboInfo(3,1).equals(17 + " | Yellow | Orange"));
        assert (getColorComboInfo(3,2).equals(18 + " | Yellow | Green"));
        assert (getColorComboInfo(3,3).equals(19 + " | Yellow | Brown"));
        assert (getColorComboInfo(3,4).equals(20 + " | Yellow | Slate"));
        assert (getColorComboInfo(4,0).equals(21 + " | Violet | Blue"));
        assert (getColorComboInfo(4,1).equals(22 + " | Violet | Orange"));
        assert (getColorComboInfo(4,2).equals(23 + " | Violet | Green"));
        assert (getColorComboInfo(4,3).equals(24 + " | Violet | Brown"));
        assert (getColorComboInfo(4,4).equals(25 + " | Violet | Slate"));
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

