import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class IOLink {
    public static final String EXERCISES_URL = "./Exercises.txt";//绝对地址，保存题目
    public static final String ANSWERS_URL = "./Answers.txt";//保存对应题目答案
    //n 题目数， range 题目取值范围
    public static void create(int n,int range) throws Exception{
        String s="";
        FileWriter fw1 = new FileWriter(ANSWERS_URL);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        FileWriter fw = new FileWriter(EXERCISES_URL);
        BufferedWriter bw = new BufferedWriter(fw);
        LinkedList<String> result = new LinkedList<String>();
        //生成题目
        for(int i = 0,tCount = 0;i<n;) {
            boolean isSame = false;
            String[] answer = new String[n];
            String[] p = new String[n];
            String problem = Expression.infixExpression(range);
            String aproblem = Expression.countanswer(problem);
            //去重
            for (int j = 0; j < answer.length; j++) {
                if (aproblem.equals(answer[j])) {
                    if (Expression.WhetherEqual(p[j],problem)) {
                        isSame = true;
                    }
                }
            }
            p[i]=problem;
            answer[i]=aproblem;
            if (isSame == false) {
                result.add(problem);
                String[] path = problem.split("、");
                bw.write(i+1 + "、 " + path[0]);
                bw.newLine();
                bw.flush();
                bw1.write(i+1 + "、 " + Expression.countanswer(path[0]));
                bw1.newLine();
                bw1.flush();
                i++;
            }
        }
        bw.close();
        bw1.close();
    }


     // 检查并且写入到文件夹中
    public static void checkanswer(String str1, String str2) throws Exception {
        int countcorrect=0;
        int countwrong=0;
        BufferedReader savebr=null;
        String SubjectString= "";
        String NumberOfCorrectAnswers= "(";
        String NumberOfWrongAnswers= "(";
        String SubAnswer=null;
        String answer=null;
        String[] path1 = null;
        String[] path2 = null;
        FileWriter fw = new FileWriter("./Grade.txt");

        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fr = new FileReader(str1);//题目
        BufferedReader br = new BufferedReader(fr);
            FileReader fr1 = new FileReader(str2);//做题结果
            savebr = new BufferedReader(fr1);
        for(int i=0;(SubjectString = br.readLine())!=null;i++) {
            path1 = SubjectString.split("、");//分割
            if(path1.length>1) {
                SubAnswer = Expression.countanswer(path1[1]).replaceAll(" +","");//去空格
            }
            path2 = savebr.readLine().split("、");//分割

            if(path2.length>1) {
                answer = path2[1].replaceAll(" +","");//去空格
            }

            if(SubAnswer.equals(answer)){
                int j =i+1;
                NumberOfCorrectAnswers = NumberOfCorrectAnswers + j+",";
                countcorrect++;
            }else {
                int j =i+1;
                NumberOfWrongAnswers = NumberOfWrongAnswers + j+",";
                countwrong++;
            }
        }
        NumberOfCorrectAnswers=NumberOfCorrectAnswers.substring(0,NumberOfCorrectAnswers.length()-1);
        NumberOfWrongAnswers=NumberOfWrongAnswers.substring(0,NumberOfWrongAnswers.length()-1);
        bw.write("Correct: "+ countcorrect + NumberOfCorrectAnswers +")");
        bw.newLine();
        bw.write("Wrong: "+ countwrong + NumberOfWrongAnswers +")");
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        create(100 ,10);
        System.out.println("OK");
        checkanswer("./Exercises.txt","./Answers.txt");
        System.out.println("OK");
    }
}
