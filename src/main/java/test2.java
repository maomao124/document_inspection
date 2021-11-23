import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/23
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2
{
    public static void main(String[] args)
    {
        String filePath1 = "target\\classes\\class_getFiles_RelativePath2.class";
        String filePath2 = "target\\classes\\class_getFiles_RelativePath2.class";
        String file1_md5 = md5HashCode(filePath1);
        String file2_md5 = md5HashCode(filePath2);

        System.out.println(file1_md5);
        System.out.println(file2_md5);
        if (file1_md5.equals(file2_md5))
        {
            System.out.println("两个文件是一致的");
        }
        else
        {
            System.out.println("两个文件不一致的");
        }
    }


    public static String md5HashCode(String filePath)
    {
        try
        {
            InputStream fis = new FileInputStream(filePath);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1)
            {
                md.update(buffer, 0, length);
            }
            fis.close();
            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);
            return bigInt.toString(16);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
