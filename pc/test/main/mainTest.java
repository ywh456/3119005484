package main;

import unit.FileException;
import unit.HaiMing;
import unit.cipin_and_simhash;
import unit.wenjian_IO;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class mainTest {
// 测试原文件与add文件相似度
    @Test
    public void maintestADD() throws FileException, IOException {
        String a = "C:\\Users\\MZ\\Desktop\\Testfile\\orig.txt" ;
        String b = "C:\\Users\\MZ\\Desktop\\Testfile\\orig_0.8.add.txt";
        String str = "C:\\Users\\MZ\\Desktop\\Testfile\\testadd.txt";
        Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
        Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
        //Similarity
        double s = HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
        System.out.println(s);
        wenjian_IO.writeFile(str,s);
    }
    // 测试原文件与del文件相似度
@Test
    public void maintestDEL() throws FileException, IOException {
    String a = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig.txt");
    String b = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig_0.8_del.txt");
    String str = "C:/Users/MZ/Desktop/Testfile/testdel.txt";
    Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
    Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
    //Similarity
    double s = HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
    System.out.println(s);
    wenjian_IO.writeFile(str,s);
}
    // 测试原文件与dis_1文件相似度
@Test
    public void mainteestDIS_1() throws FileException, IOException {
        String a = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig.txt");
        String b = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig_0.8_dis_1.txt");
        String str = "C:/Users/MZ/Desktop/Testfile/testdis_1.txt";
    Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
    Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
    //Similarity
    double s = HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
    System.out.println(s);
    wenjian_IO.writeFile(str,s);
    }
    // 测试原文件与dis_10文件相似度
    @Test
    public void mainteestDIS_10() throws FileException, IOException {
        String a = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig.txt");
        String b = wenjian_IO.read("C:/Users/MZ/Desktop/Testfile/orig_0.8_dis_10.txt");
        String str = "C:/Users/MZ/Desktop/Testfile/testdis_10.txt";
        Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
        Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
        //Similarity
        double s = HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
        System.out.println(s);
        wenjian_IO.writeFile(str,s);
    }
    // 测试原文件与dis_15文件相似度
    @Test
    public void mainteestDIS_15() throws FileException, IOException {
        String a = wenjian_IO.read("C:/Users/MZ/Desktop//Testfile//orig.txt");
        String b = wenjian_IO.read("C:/Users/MZ/Desktop//Testfile//orig_0.8_dis_15.txt");
        String str = "C:/Users/MZ/Desktop/Testfile/testdis_15.txt";
        Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
        Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
        //Similarity
        double s = HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
        System.out.println(s);
        wenjian_IO.writeFile(str,s);
    }


}
