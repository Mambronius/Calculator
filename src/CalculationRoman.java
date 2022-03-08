public class CalculationRoman {
    public String CalcRoman(Roman left, Roman right, Operation oper){
        int l = left.ordinal();
        int r = right.ordinal();

        try {
            if (oper == Operation.PLUS) return IntegerToRomanNumeral(l+r);
            if (oper == Operation.MINUS) return IntegerToRomanNumeral(l-r);
            if (oper == Operation.MULT) return IntegerToRomanNumeral(l*r);
            if (oper == Operation.DIV) return IntegerToRomanNumeral((int)l / r) ;
        } catch (Exception e) {
            e.printStackTrace();
        }



        return "";
    }

    public static String IntegerToRomanNumeral(int input) throws Exception {
        if (input < 1 || input > 100) {
            throw new Exception("Invalid Roman Number Value");
        }
        String s = "";

        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
}
