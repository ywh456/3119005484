package unit;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
public class   wenjian_IO {
    //Read in file
    public static String read(String filepath) throws FileException {
        if(filepath == null ||"".equals(filepath)){
            throw new FileException("Empty file path exception");
        }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filepath);
        }catch (Exception e){
            throw new FileException("Empty file exception");
        }
        String result = fileReader.readString();
        return result;
    }
    //Write in file
    public static Boolean writeFile(String filepath,double ssim){
        FileWriter writer = new FileWriter(filepath);
        try {
            writer.write("Similarity is: "+ssim);
        }catch (Exception e){
            System.out.println("The output file address is abnormal, and the similarity is:"+ssim);
        }
        return true;
    }
}
