package controller;

public class Calc
{
    Lexer lexer;

    private double primary()
    {
        double result = 0;
        LexemType curType = lexer.currentLexem.getType();

        switch (curType)
        {
            case OPEN:
                lexer.nextLexem();
                result = expression();
                lexer.nextLexem();
                break;
            case NUMBER:
                result = lexer.currentLexem.getValue();
                lexer.nextLexem();
                break;
            default:
                result = expression();
        }
        return result;
    }

    private double unary()
    {
        double result = 0;
        LexemType curType = lexer.currentLexem.getType();

        switch (curType)
        {
            case MINUS:
                lexer.nextLexem();
                result = -primary();
                break;
            case PLUS:
                lexer.nextLexem();
                result = primary();
                break;
            default:
                result = primary();
        }
        return result;
    }

    private double term()
    {
        double result = unary();
        LexemType curType = lexer.currentLexem.getType();

        while (curType == LexemType.MULT || curType == LexemType.DIV )
        {
            lexer.nextLexem();
            if (curType == LexemType.MULT)
                result *= unary();
            else
                result /= unary();
            curType = lexer.currentLexem.getType();
        }
        return result;
    }

    private double expression()
    {
        double result = term();
        LexemType curType = lexer.currentLexem.getType();

        while (curType == LexemType.PLUS || curType == LexemType.MINUS)
        {
            lexer.nextLexem();
            if (curType == LexemType.PLUS)
                result += term();
            else
                result -= term();
            curType = lexer.currentLexem.getType();
        }
        return result;
    }

    public double calculate(String expression)

    {

        lexer = new Lexer(expression.toLowerCase());
        lexer.nextLexem();
        return expression();
    }
}
