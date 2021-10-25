import java.util.Objects;

public class main {

    public static void main(String[] args) throws Exception {
        String s1=args[0];
        String s2=args[1];
        String s3=args[2];
        String s4=args[3];
        if(Objects.equals(args[0], "-n") && Objects.equals(args[2], "-r"))
        {
            IOLink.create(Integer.parseInt(s2),Integer.parseInt(s4));
        }

        if(Objects.equals(args[0], "-e") && Objects.equals(args[2], "-a")){
            IOLink.checkanswer(s2,s4);
        }
    }
}