package unit;

public class HaiMing {
    //Calculate the Hamming distance of two simhashes
    public static  int getHaiMing(String SH1  , String SH2)
    {
        int distance = 0;
        //字符串相同才能计算海明距离
        if(SH1.length() == SH2.length()){
            for(int i=0;i<SH1.length();i++){
                if(SH1.charAt(i)!=SH2.charAt(i)){distance++;}
            }
        }
        else{distance = -1;}
        return distance;
    }
//Output the similarity of two simhash and the corresponding simhash value;
    public static double getSSIM(String SH1  , String SH2){
        int distance = getHaiMing(SH1,SH2);
        int i=(SH1.length()-distance);
        int j=(SH1.length()+distance);
        return 100*i/j;//Jaccard系数计算相似度
    }
}
