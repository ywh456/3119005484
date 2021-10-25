import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @org.junit.jupiter.api.Test
    void priority() {
        char c1='-';
        int p1=Expression.priority(c1);
        char c2='/';
        int p2=Expression.priority(c2);
        char c3='(';
        int p3=Expression.priority(c3);
        char c4=')';
        int p4=Expression.priority(c4);
        System.out.println(p1+" "+p2+" "+p3+" "+p4);

    }

    @org.junit.jupiter.api.Test
    void getrandommath() {
        for(int i=0;i<20;i++){
            int j =10;
            System.out.println(Expression.getrandommath(j));
        }
    }

    @org.junit.jupiter.api.Test
    void getoperator() {
        for(int i=0;i<20;i++){
            System.out.println(Expression.getoperator());
        }
    }

    @org.junit.jupiter.api.Test
    void infixExpression() {
        for(int i=0;i<20;i++){
            System.out.println(Expression.infixExpression(10));
        }
    }

    @org.junit.jupiter.api.Test
    void suffixExprssion() {
        for(int i=0;i<20;i++){
            System.out.println(Expression.suffixExprssion(Expression.infixExpression(10)));
        }
    }

    @org.junit.jupiter.api.Test
    void jiafen() {  for(int i=0;i<20;i++){
        System.out.println(Expression.jiafen(Expression.suffixExprssion(Expression.infixExpression(10))));
    }
    }


    @org.junit.jupiter.api.Test
    void countanswer() {
        for(int i=0;i<20;i++){
            System.out.println(Expression.countanswer(Expression.infixExpression(10)));
        }
    }

    @org.junit.jupiter.api.Test
    void whetherEqual() {
        String s1 = "1 + 2";
        String s2 = "2 + 1";
        String s3 = "1 + 2 + 3 ";
        String s4 = "3 + (2 + 1) ";
        boolean w1 = Expression.WhetherEqual(s3,s4);
        boolean w2 = Expression.WhetherEqual(s1,s2);
        System.out.println(w1);
        System.out.println(w2);
    }
}