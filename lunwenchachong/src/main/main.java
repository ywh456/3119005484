package main;

import unit.FileException;
import unit.HaiMing;
import unit.cipin_and_simhash;
import unit.wenjian_IO;
import java.io.IOException;
import java.util.Map;


public class main {
    public static void main(String[] args) throws IOException, FileException {
        Similarity(args[0], args[1], args[2]);

        System.exit(0);
    }
    public static void Similarity(String source, String Plagiarize, String Answer)throws IOException, FileException {
        String a = wenjian_IO.read(source);
        String b = wenjian_IO.read(Plagiarize);
        Map<String,Integer> wF1 = cipin_and_simhash.getTextDef(a);
        Map<String,Integer> wF2 = cipin_and_simhash.getTextDef(b);
        //Hamming distance
        int distance= HaiMing.getHaiMing(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2));
        System.out.println(distance);
        //Similarity
        System.out.println(HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2)));
        wenjian_IO.writeFile(Answer,HaiMing.getSSIM(cipin_and_simhash.simHash(wF1), cipin_and_simhash.simHash(wF2)));
    }
}
