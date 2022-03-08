public class Calculation {
    public int Calc(int left, int right, Operation oper){
        if (oper == Operation.PLUS) return left + right;
        if (oper == Operation.MINUS) return left - right;
        if (oper == Operation.MULT) return left * right;
        if (oper == Operation.DIV) return (int)left / right;
        return 0;
    }

}
