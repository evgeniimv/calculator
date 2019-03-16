package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum LexemType{
    NUMBER,
    PLUS,
    MINUS,
    MULT,
    DIV,
    POW,
    OPEN,
    CLOSE,
    END
}


public class Lexer {

    private Pattern doubleRegExp = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
    private Matcher matcher;

    class Lexem
    {
        private double value;
        private LexemType type;

        Lexem(LexemType t)
        {
            type = t;
        }

        LexemType getType ()
        {
            return type;
        }

        void setValue (double x)
        {
            value = x;
        }

        double getValue ()
        {
            if(type == LexemType.NUMBER)
                return value;
            else
                return 0;
        }
    }

    public Lexem currentLexem = new Lexem(LexemType.END);
    private int it = 0;
    private String expression;

    Lexer(String expression)
    {
        this.expression = expression;
        this.matcher = doubleRegExp.matcher(expression);
    }

    void nextLexem()
    {
        if (it >= expression.length())
        {
            this.currentLexem = new Lexem(LexemType.END);
            return;
        }
        switch (expression.charAt(it))
        {
            case ' ':
                ++it;
                nextLexem();
                break;
            case '+':
                ++it;
                currentLexem = new Lexem(LexemType.PLUS);
                break;
            case '-':
                ++it;
                currentLexem = new Lexem(LexemType.MINUS);
                break;
            case '*':
                ++it;
                currentLexem = new Lexem(LexemType.MULT);
                break;
            case '/':
                ++it;
                currentLexem = new Lexem(LexemType.DIV);
                break;
            case '^':
                ++it;
                currentLexem = new Lexem(LexemType.POW);
                break;
            case '(':
                ++it;
                currentLexem = new Lexem(LexemType.OPEN);
                break;
            case ')':
                ++it;
                currentLexem = new Lexem(LexemType.CLOSE);
                break;
            default:
                matcher.find();
                this.currentLexem = new Lexem(LexemType.NUMBER);
                //присваиваем переменной value модуль соответсвующего числа, распознанное
                // с использованием шаблона doubleRegExp
                currentLexem.setValue(Math.abs(Double.parseDouble(matcher.group())));
                it = matcher.end();
        }

    }


}
