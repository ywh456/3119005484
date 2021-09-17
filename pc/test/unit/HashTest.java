package unit;

import org.junit.Test;

public class HashTest {

//空字符窜获取hash测试
    @Test
    public void getHash1() throws FileException {
        String str =null;
       String str2= Hash.getHash(str);
       System.out.println(str2);
    }

    @Test
    public void getHash2() {
        String[] str = {"这是", "一次", "获得", "哈希", "值", "的", "测试"};
        for (String s : str) {
            String hash = Hash.getHash(s);
            System.out.println(hash.length());
            System.out.println(hash);
        }
    }
    }