package unit;

import org.junit.Test;

import java.io.IOException;


public class wenjian_IOTest {

//读文件测试
    @Test
    public void read() throws FileException {
        String str = "C:\\Users\\MZ\\Desktop\\Testfile\\orig.txt" ;
        String a = wenjian_IO.read(str);
        System.out.println(a);
    }
    //错误路径读入测试
   @Test
    public void read2() throws FileException {
        String str = "C:/Users/MZ/Desktop//Desktop//null.txt";
        String b = wenjian_IO.read(str);
        System.out.println(b);
    }
    //空白文件读入测试
    @Test
    public void read3() throws FileException {
        String str = null;
        String c= wenjian_IO.read(str);
        System.out.println(c);
    }


    @Test
    public void writeFile() throws IOException {
        double ssim = 1;
        String str = "C:/Users/MZ/Desktop//测试文本/test.txt" ;
        boolean a;
        a = wenjian_IO.writeFile(str,ssim);
        System.out.println(a);
    }
    @Test
    public void writeFile2() throws IOException {
        double ssim = 1;
        String str ="p:/null.text";
       boolean a = wenjian_IO.writeFile(str,ssim);
        System.out.println(a);
    }
    @Test
    public void writeFile3() throws IOException {
        double ssim = 1;
        String str = null;
       boolean a =wenjian_IO.writeFile(str,ssim);
        System.out.println(a);
    }
}
