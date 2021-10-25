
public class Fraction {
    int numerator = 0;//分子
    int denominator = 0;//分母
    public Fraction(int a ,int b){
        numerator = a;
        denominator = b;
    }
    //辗转相除，算最大公因子
    public static int getdiv(int x,int y){

        while(y!=0){
            int r= x%y;
            x = y;
            y = r;
        }
        return x;
    }
    // 乘法
    public static Fraction multiply(Fraction x, Fraction y)
    {    Fraction f = new Fraction (1,1);
        f.numerator = x.numerator*y.numerator;
        f.denominator =x.denominator*y.denominator;
        if(f.numerator!=0){
            int a=getdiv(f.numerator,f.denominator);
            f.numerator = f.numerator/a;
            f.denominator = f.denominator/a;
        }
        return f;
    }
    //除法
    public static Fraction divide(Fraction x, Fraction y)
    {   Fraction f = new Fraction(1, 1);
    //除数为0，返回一个负数
        if (y.numerator == 0) {
            f.numerator = -x.numerator ;
            f.denominator = 0*x.denominator;
            return f;
        } else {
            f.numerator = x.numerator * y.denominator;
            f.denominator = x.denominator * y.numerator;
            if (f.numerator != 0) {
                int a = getdiv(f.numerator, f.denominator);
                f.numerator = f.numerator / a;
                f.denominator = f.denominator / a;
            }
        }
        return f;
    }
    // 加法
    public static Fraction add(Fraction x, Fraction y)
    {
        Fraction f = new Fraction (1,1);
        f.numerator = x.numerator*y.denominator+y.numerator*x.denominator;
        f.denominator =x.denominator*y.denominator;
        if(f.numerator!=0){
            int a=getdiv(f.numerator,f.denominator);
            f.numerator = f.numerator/a;
            f.denominator = f.denominator/a;
        }
        return f;
    }
    // 减法
    public static Fraction  subtract(Fraction x, Fraction y) {
          Fraction f = new Fraction (1,1);
            f.numerator = x.numerator * y.denominator - y.numerator * x.denominator;
            f.denominator = x.denominator * y.denominator;
            if (f.numerator != 0) {
                int a = getdiv(f.numerator, f.denominator);
                f.numerator = f.numerator / a;
                f.denominator = f.denominator / a;
            }
            return f;
        }

}
