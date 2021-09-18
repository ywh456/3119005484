package unit;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class cipin_and_simhashTest {
//测试分词器文本查看能否成功对文本分词;
    @Test
    public void getTextDef() throws IOException {
     String s = "测试分词器文本//.查看能否成功对文本分词";
     Map<String,Integer> wF1= cipin_and_simhash.getTextDef(s);
     System.out.println(wF1);
    }
    //多重复词句分词测试
    @Test
    public void getTextDef2() throws IOException {
        String s = "重复的测试文本，重复的测试文本，重复的测试文本，重复的测试文本，重复的测试文本，重复的测试文本，重复的测试文本。";
        Map<String,Integer> wF1= cipin_and_simhash.getTextDef(s);
        System.out.println(wF1);
    }
    //获取SIMHASH值
    @Test
    public void simHash() throws IOException {
        String[] s = {"测试","计","算si","m","hash","的文本//",".查看","能否","成功求","出文本","的","simhash值;"};
        for(String s1 :s) {
            Map<String, Integer> wF1 = cipin_and_simhash.getTextDef(s1);
            String sim = cipin_and_simhash.simHash(wF1);
            System.out.println(sim);
        }
    }
}
