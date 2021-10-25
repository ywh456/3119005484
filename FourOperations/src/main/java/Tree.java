import java.util.Stack;
//树结构体，用于判断题目是否重复
public class Tree {
    Tree left;
    Tree right;
    String data;
    static boolean ifswitch = false;

    public Tree(String data){this.data = data;}

    public void printTree(){
        if(left != null){left.printTree();}
        if(right != null){right.printTree();}
        System.out.println(data);
    }
    //判断2树是否相等
    public static boolean equaltree(Tree a, Tree b) {
        //同样是空就是相等，其中一个是空必然不相等;
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }
        if (a.data.equals(b.data)) {
            //直接比照左右节点，或者一次换枝叶比较是否相等;
            boolean switchResult = true;//控制是否已经交换
            //左右枝的交换
            if ((a.data.equals("+")||a.data.equals("*"))&&!ifswitch) {
                ifswitch = true;
                switchResult = equaltree(a.right, b.left) && equaltree(a.left, b.right);
                ifswitch = false;
            }
            return (equaltree(a.left, b.left) && equaltree(a.right, b.right)) || switchResult;
        } else {
            return false;
        }
    }

    //后缀表达式生成树，便于判重
public static Tree suffixtree(String str) {
    if ((str == null) || (str.equals(""))) {
        return null;
    }
    String c[] = str.split("( )+");
    Stack<Tree> stack = new Stack<Tree>();
    for (int i = 0; i < c.length; i++) {
        if (c[i].equals("+") || c[i].equals("-") || c[i].equals("*") || c[i].equals("/")) {
            if (stack.isEmpty() || stack.size() < 2) {
                System.out.print("后缀表达式输入错误");
                return null;
            }
            Tree root = new Tree(c[i]);
            root.left = stack.pop();
            root.right = stack.pop();
            stack.push(root);

        } else {
            Tree t = new Tree(c[i]);
            stack.push(t);
        }
    }
        if (stack.isEmpty() || stack.size() > 1) {
            System.out.print("后缀表达式输入错误");
            return null;
        }
        return stack.pop();
}

}
