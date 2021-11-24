import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): getFileMD5
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/23
 * Time(创建时间)： 22:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class class_getFileMD5
{
    public static String getFileMD5(String filePath)
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
            System.out.println(e.getMessage());
            return "";
        }
    }

    public static void main(String[] args)
    {
        System.out.println(getFileMD5("H:\\程序\\大三上期\\文件检验\\.idea\\workspace.xml"));
    }
}
