import java.util.Scanner;
import java.lang.Exception;

enum Roman{
    //I added ZERO value for convenience
    //It will be easier to convert enum to int and to check some booleans
    ZERO,
    I,
    II,
    III,
    IV,
    V,
    VI,
    VII,
    VIII,
    IX,
    X

}

public class Calculator {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        //Let's remove all whitespaces for our convenience
        string = string.replaceAll("\\s+","");

        //Let's find whether our expression has necessary operation
        Pair oper = new Pair(0,Operation.PLUS);
        try{
            oper = checkOperation(string);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        //Now we need to check left and right parts of our expression
        String left = string.substring(0,oper.index);
        String right = string.substring(oper.index+1);

        //Now let's check the type of the left expression
        int leftNumber = 0;
        try {
            leftNumber = Integer.parseInt(left);
        }
        catch (NumberFormatException e) {
            leftNumber = 0;
        }

        Roman leftRoman = Roman.ZERO;
        try {
            leftRoman =Roman.valueOf(left);
        }
        catch (IllegalArgumentException e) {
            leftRoman = Roman.ZERO;
        }
        if (leftNumber == 0 && leftRoman == Roman.ZERO) throw new Exception("Incorrect left part");
        if (leftNumber < 0 || leftNumber>10) throw new Exception("incorrect value");

        //Now let's check the type of the right expression
        int rightNumber = 0;
        try {
            rightNumber = Integer.parseInt(right);
        }
        catch (NumberFormatException e) {
            rightNumber = 0;
        }

        Roman rightRoman = Roman.ZERO;
        try {
            rightRoman =Roman.valueOf(right);
        }
        catch (IllegalArgumentException e) {
            rightRoman = Roman.ZERO;
        }
        if (rightNumber == 0 && rightRoman == Roman.ZERO) throw new Exception("Incorrect right part");
        if (rightNumber < 0 || rightNumber>10) throw new Exception("incorrect value");
        //Also we need to be sure that both parts are consistent
        if (leftNumber != 0 && rightRoman != Roman.ZERO) throw new Exception("Parts with different numerical systems");
        if (rightNumber != 0 && leftRoman != Roman.ZERO) throw new Exception("Parts with different numerical systems");
        Calculation cal = new Calculation();
        if (leftNumber !=0) System.out.println(cal.Calc(leftNumber,rightNumber,oper.operation));
        CalculationRoman calRoman = new CalculationRoman();
        System.out.println(calRoman.CalcRoman(leftRoman,rightRoman,oper.operation));
    }


    public static Pair checkOperation(String str) throws Exception{
        int index = str.indexOf('+');
        if (index != -1){
            Pair pair = new Pair(index, Operation.PLUS);
            return pair;
        }
        index = str.indexOf('-');
        if (index != -1){
            Pair pair = new Pair(index, Operation.MINUS);
            return pair;
        }
        index = str.indexOf('*');
        if (index != -1){
            Pair pair = new Pair(index, Operation.MULT);
            return pair;
        }
        index = str.indexOf('/');
        if (index != -1){
            Pair pair = new Pair(index, Operation.DIV);
            return pair;
        }
        throw new Exception("Incorrect operation or no operation at all");
    }

}

