import java.util.Random;
import java.util.Stack;

public class Expression {

    public static int priority(char c)//优先级
    { if(c=='-'||c=='+'){return 1;}
      else if(c=='*'||c=='/'){return 2;}
      else if(c=='('){return 0;}
      else {return -1;}
    }
    //随机获取一个数值
    public static String  getrandommath(int range)
    {
        Random random = new Random();
        int x = random.nextInt(2);
        int a = random.nextInt(range);
         int b = random.nextInt(range);
      String math =Integer.toString(a);
        if(x == 0){ return math;}
        else{
            if(a>b&&b!=0){
                int c =a/b;
                int d =a-b;
               math =  c + "'" + d + "/" + b;
            }
            else if(a==0){
                math = Integer.toString(1);
            }
            else if (a<b){math = a+"/"+b;}
            else if(b==0){return math;}
            return math;
        }
    }
    //随机生成运算符号
    public static String getoperator() {
        Random rand = new Random();
        int a = rand.nextInt(4);
        String str = null;
        if (a == 0) {
            str = "+";
        }
        else if (a == 1) {
            str = "-";
        }
        else if (a == 2) {
            str = "*";
        }
        else {
            str = "/";
        }
        return str;
    }
    //生成一个中缀表达式
   public static String infixExpression(int range){

            String str1 = "";
       do {
            int num = 0;
            Random random = new Random();
            num = random.nextInt(3) + 2;
            if (num == 2) {
                String op = getoperator();
                String s1 = getrandommath(range);
                String s2 = getrandommath(range);
                str1 = " "+s1 + " " + op + " " + s2;
            } else if (num == 3) {
                String op1 = getoperator();
                String op2 = getoperator();
                String s1 = getrandommath(range);
                String s2 = getrandommath(range);
                String s3 = getrandommath(range);
                str1 = " "+s1 + " " + op1 + " " + s2 + " " + op2 + " " + s3;

            } else {//num==4加一个括号
                int i = random.nextInt(2);
                String op1 = getoperator();
                String op2 = getoperator();
                String s1 = getrandommath(range);
                String s2 = getrandommath(range);
                String s3 = getrandommath(range);
                if (i == 0) {
                    str1 = "("+" " + s1 + " " + op1 + " " + s2 + ")" + " " + op2 + " " + s3;
                } else {
                    str1 = s1 + " " + op1 + " " +"("+" "+ s2  + " " + op2 + " " + s3+" "+")";
                }

            }
        }while(countanswer(str1).contains("-"));//负数重新生成

       return str1 + " =" + " "+"、";
    }

    //中缀转后缀
    public static String suffixExprssion(String str){
        int stacklength = 0;
        int num = 0;
        int temp = 0;
        String exp = "";
        char element ='|';
        boolean withoutnum = false;

        Stack<Character>  stack = new Stack<Character>();
        str = str + "|";//|做结尾标志

        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c<='9'&&c>='0'){
                withoutnum = true;
                temp = temp*10+(c-'0');
            }
            else{
                if(withoutnum){
                    exp += temp;
                    temp =0;
                    withoutnum = false;
                }
                if(c=='('){
                    num++;
                    stack.push(c);
                }
                else if(c=='+'||c=='-'||c=='|') {
                    if (num > 0) {
                        stacklength = stack.size();
                        for (int j = 0; j < stacklength; j++) {
                            element = stack.peek();
                            if (element == '(') {
                                break;
                            }
                            exp += ' ';
                            exp += stack.pop();
                        }
                    } else {
                        exp += ' ';
                        if (stack.size() != 0) {
                            stacklength = stack.size();
                            for (int h = 0; h < stacklength; h++) {
                                exp += ' ';
                                exp += stack.pop();
                            }
                        }
                    }
                    if (c == '|') {
                        break;
                    }
                        stack.push(c);
                        exp += ' ';

                }
                else if(c=='*'||c=='/')
                {if(str.charAt(i-1) == ' '){
                    //弹出栈顶优先级大于当前元素的符号;
                    while(!stack.empty()&&priority(c)<=priority(stack.peek())){
                        exp += ' ';
                        exp +=stack.pop();
                    }
                    stack.push(c);
                }
                else {
                    exp +=c; }
                }
                else if(c==')'){
                    if(stack.size() == 0){
                        exp += ' ';
                    }
                    else{
                        stacklength = stack.size();
                        for(int z=0;z<stacklength;z++){
                            element = stack.pop();
                            if(element=='('){break;}
                            exp += ' ';
                            exp +=element;
                        }
                        num--;
                    }
                }
                else if(c==' '){exp += ' ';}

            }
        }
    return exp;
    }
    //将输入的表达中的假分数转为真分数，便于计算
    public static String jiafen (String str){
        int t1 =0;
        for(int i=0;i<str.length();i++){
            char c1 = str.charAt(i);
            if(String.valueOf(c1).equals("'")){t1++;}
        }
        if(t1 ==0){return str;}
        else{
            String str2 = jiafentool(str);
             str =jiafen(str2);
        }
        return str;
    }
public static String jiafentool(String str){
        String exp = "";
        String qian ="";
        String hou ="";
        String shu1 = "";
       String shu2 = "";
        String shu3 = "";

        l1:for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (String.valueOf(c1).equals("'")) {
                loo1:
                for (int j = i + 1; j < str.length(); j++) {
                    char c2 = str.charAt(j);
                    if (c2 == '/') {
                        loo2:
                        for (int h = j + 1; h < str.length(); h++) {
                            char c3 = str.charAt(h);
                            if (c3 <= '9' && c3 >= '0') {
                                shu3 += c3;
                            } else {
                                for (int l = h; l < str.length(); l++) {
                                    char c4 = str.charAt(l);
                                    hou += c4;
                                }
                                break loo1;
                            }
                        }
                    } else {
                        continue loo1;
                    }
                }


                loo1:
                for (int j = i; j > 0; j--) {
                    char c2 = str.charAt(j);
                    if (c2 == '/' || c2 == '*' || c2 == '+' || c2 == '-') {
                        for (int h = j + 1; h < i; h++) {
                            char c3 = str.charAt(h);
                            if (c3 <= '9' && c3 >= '0') {
                                shu1 += c3;
                            }
                        }
                        for (int t = 0; t <= j; t++) {
                            char c3 = str.charAt(t);
                            qian += c3;
                        }
                    } else if (j == 1) {
                        for (int u = 0; u < i; u++) {
                            char c3 = str.charAt(u);
                            if (c3 <= '9' && c3 >= '0') {
                                shu1 += c3;
                            }
                        }

                    } else {
                        continue loo1;
                    }
                    break loo1;
                }

                loo1:
                for (int j = i; j > 0; j++) {
                    char c2 = str.charAt(j);
                    if (c2 == '/' || c2 == '*' || c2 == '+' || c2 == '-') {
                        for (int h = i; h < j; h++) {
                            char c3 = str.charAt(h);
                            if (c3 <= '9' && c3 >= '0') {
                                shu2 += c3;
                            }
                        }
                        break loo1;
                    } else {
                        continue loo1;
                    }

                }
                break l1;

            }
        }
            String jia = " "+"("+" "+"("+shu1+" "+"*"+" "+shu3+" "+"+"+" "+shu2+")"+" "+"/"+" "+shu3+" "+")"+" ";
            exp = qian+jia+hou;
        return exp;
}
// 计算中缀表达式的值
    public static String countanswer(String expstr){
        String jsu = jiafen(expstr);
        String suffixexpstr = suffixExprssion(jsu);
         char cnum = '|';
         int num = 0;//分子
         int den = 0;//分母
         int temp = 0;
         boolean isnum = false;
         boolean  isfraction = false;
         Fraction f = null;
         Fraction x = null;
         Fraction y = null;
     Stack<Fraction> fractionStack  = new Stack<Fraction>();
        for(int i=0;i<suffixexpstr.length();i++){
         cnum = suffixexpstr.charAt(i);
         if(cnum >='0'&&cnum<='9'){isnum =true;temp = temp*10+(cnum - '0');}
         else {
             if(isnum) {
             isnum = false;
             if (cnum == ' ' || cnum == '-' || cnum == '+' || cnum == '*') {
                 if (isfraction) {
                     den = temp;
                     Fraction f2 = new Fraction(num, den);
                     fractionStack.push(f2);
                     temp = 0;den=0;
                 } else {
                     Fraction f2 = new Fraction(temp, 1);
                     fractionStack.push(f2);
                     temp = 0;
                 }
             } else {
                 isfraction = true;
                 num = temp;
                 temp = 0;
                 continue;
             }
         }
         if(cnum ==' '){if(isfraction){isfraction=false;} continue;}


              else if(cnum == '*'||cnum =='/'||cnum == '+'||cnum == '-'){
                  y = fractionStack.pop();
                  x = fractionStack.pop();

             if(cnum=='*'){f = Fraction.multiply(x,y);}
             else if(cnum == '/'){f = Fraction.divide(x,y);}
             else if(cnum == '+'){f = Fraction.add(x,y);}
             else if(cnum == '-'){f = Fraction.subtract(x,y);}
              }
             fractionStack.push(f);
         }
     }
        if(fractionStack.size()==0){ return -1+"";}
     else{
         Fraction result = fractionStack.pop();
     return transform(result.numerator,result.denominator);
    }
    }
    //转化为真分数
    public static String transform(int i, int j) {
        if (j==0){int a = -i;return a+"";}
        if(i==0){return "0";}
        if (i >= j) {
            if (j == 1) {
                return i + "" ;
            }
            return " "+i / j + "'" + i % j + "/" + j;
        } else {
            return i + "/" + j;
        }
    }

    //判断题目是否重复
    public static boolean WhetherEqual(String str1,String str2)
    { String a = suffixExprssion(str1);
     String b = suffixExprssion(str2);
        Tree x = Tree.suffixtree(a);
        Tree y = Tree.suffixtree(b);
        x.printTree();
        System.out.println("--------------------");
        y.printTree();
        return Tree.equaltree(x,y);
    }

}
