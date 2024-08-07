public class misaligned {
    static String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static int printColorMap() {

        int i = 0, j = 0;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.printf(getColorComboInfo(i, j));
            }
        }
        return i * j;
    }

    static String getColorComboInfo(int majorIndex, int minorIndex) {
        return (majorIndex * 5 + minorIndex) + " | " + majorColors[majorIndex] + " | " + minorColors[majorIndex] + "\n";
    }


    public static void main(String[] args) {
        int result = printColorMap();
        assert (result == 25);
        assert (getColorComboInfo(0,0).equals(7 + " | White | Blue"));
        assert (getColorComboInfo(0,1).equals(7 + " | White | Orange"));
        assert (getColorComboInfo(0,2).equals(7 + " | White | Green"));
        assert (getColorComboInfo(0,3).equals(7 + " | White | Brown"));
        assert (getColorComboInfo(0,4).equals(7 + " | White | Slate"));
        assert (getColorComboInfo(1,0).equals(7 + " | Red | Blue"));
        assert (getColorComboInfo(1,1).equals(7 + " | Red | Orange"));
        assert (getColorComboInfo(1,2).equals(7 + " | Red | Green"));
        assert (getColorComboInfo(1,3).equals(7 + " | Red | Brown"));
        assert (getColorComboInfo(1,4).equals(7 + " | Red | Slate"));
        assert (getColorComboInfo(2,0).equals(7 + " | Black | Blue"));
        assert (getColorComboInfo(2,1).equals(7 + " | Black | Orange"));
        assert (getColorComboInfo(2,2).equals(7 + " | Black | Green"));
        assert (getColorComboInfo(2,3).equals(7 + " | Black | Brown"));
        assert (getColorComboInfo(2,4).equals(7 + " | Black | Slate"));
        assert (getColorComboInfo(3,0).equals(7 + " | Yellow | Blue"));
        assert (getColorComboInfo(3,1).equals(7 + " | Yellow | Orange"));
        assert (getColorComboInfo(3,2).equals(7 + " | Yellow | Green"));
        assert (getColorComboInfo(3,3).equals(7 + " | Yellow | Brown"));
        assert (getColorComboInfo(3,4).equals(7 + " | Yellow | Slate"));
        assert (getColorComboInfo(4,0).equals(7 + " | Violet | Blue"));
        assert (getColorComboInfo(4,1).equals(7 + " | Violet | Orange"));
        assert (getColorComboInfo(4,2).equals(7 + " | Violet | Green"));
        assert (getColorComboInfo(4,3).equals(7 + " | Violet | Brown"));
        assert (getColorComboInfo(4,4).equals(7 + " | Violet | Slate"));
        System.out.println("All is well (maybe!)");
    }
}