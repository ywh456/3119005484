package unit;

import org.junit.Test;


public class HaiMingTest {
//计算海明距离
    @Test
    public void getHaiMing() {
        String str1 = "11000111001";
        String str2 = "00110011100";
        int d = HaiMing.getHaiMing(str1,str2);
        System.out.println("海明距离为："+d);
    }
    //测试不同长度的simhash的海明距离
    @Test
    public void getHaiMing2() {
        String str1 = "11000111001";
        String str2 = "0011001110";
        int d = HaiMing.getHaiMing(str1,str2);
        System.out.println("海明距离为："+d);
    }
//测试相似度
    @Test
    public void getSSIM() {
        String str1 = "11000111001";
        String str2 = "00110011100";
        double s = HaiMing.getSSIM(str1,str2);
        System.out.println("相似度为："+s);
    }
}
