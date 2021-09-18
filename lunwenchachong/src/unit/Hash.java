package unit;
import java.math.BigInteger;
import java.security.MessageDigest;
public class Hash {
    //Pass in string to calculate hash value
    public static String getHash(String str)
    {
        try {//Get the hash value with the MD5 value of the file
            MessageDigest MD = MessageDigest.getInstance("MD5");
            String BI= new BigInteger(1, MD.digest(str.getBytes("UTF-8"))).toString(2);
          return BI;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
