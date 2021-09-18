package unit;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class cipin_and_simhash {
    //Word segmentation and word frequency statistics are saved in HashMap
    public static Map getTextDef(String text) throws IOException {
        Map<String, Integer> wordsFren=new HashMap<String, Integer>();//使用HASGHMAP 记录分词结果
        IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(text), true);
        Lexeme lexeme;
        while ((lexeme = ikSegmenter.next()) != null) {
            if(lexeme.getLexemeText().length()>1){
                if(wordsFren.containsKey(lexeme.getLexemeText())){
                    wordsFren.put(lexeme.getLexemeText(),wordsFren.get(lexeme.getLexemeText())+1);
                }else {
                    wordsFren.put(lexeme.getLexemeText(),1);
                }
            }
        }
        return wordsFren;
    }
    //Calculate the simhash value of the text
    public static String simHash(Map<String,Integer> wordsFrenMaps){
        int[] a = new int[128];
        String simhash = " ";
        // 获取迭代器
        Iterator<Map.Entry<String, Integer>> wordsFrenMapsIterator = wordsFrenMaps.entrySet().iterator();

           while (wordsFrenMapsIterator.hasNext()) {
        //Map.Entry里有相应的getKey和getValue方法，能够从一个项中取出Key和Value。
                Map.Entry<String, Integer> wordsFrenEntry = wordsFrenMapsIterator.next();
                String WordHash = Hash.getHash(wordsFrenEntry.getKey());

               if (WordHash.length() < 128) {
                   // hash值可能少于128位，在低位以0补齐
                   int dif = 128 - WordHash.length();
                   for (int j = 0; j < dif; j++) {
                       WordHash += "0";
                   }
               }
               //加权、合并
                for (int j = 0; j < a.length; j++) {
                    if (WordHash.charAt(j) == '1') {
                        a[j] += wordsFrenEntry.getValue();//hans值为1加权重值，权重等于词频
                    } else {
                        a[j] -= wordsFrenEntry.getValue();//hans值为0减权重值，权重等于词频
                    }
                }
            }
           //降维
            for (int j = 0; j < a.length; j++) {
                if (a[j] > 0) {
                    simhash += "1";
                } else {
                    simhash += "0";
                }
            }

        return simhash;
    }
}
