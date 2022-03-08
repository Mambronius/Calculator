
public class Pair {
    Integer index;
    Operation operation;
    public Pair(Integer index, Operation oper) {

        this.index = index;
        this.operation = oper;
    }
}



enum Operation{
    PLUS, MINUS, MULT, DIV
}

