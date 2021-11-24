import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): test3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/24
 * Time(创建时间)： 10:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test3
{
    public static void main(String[] args)
    {
        File fileDirectory = new File("fileout");
            System.out.println(fileDirectory.mkdirs());
        //System.out.println(fileDirectory.isDirectory());
        FileWriter fileWriter = null;
        for (int i = 0; i < 1000; i++)
        {
            String path = "fileout\\file" + Integer.toString(i + 1) + ".txt";
            try                                  //文件流打开，文件读写
            {
                fileWriter = new FileWriter(path);
                fileWriter.write("hello world");
            }
            catch (FileNotFoundException e)      //文件未找到
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
                System.exit(1);
            }
            catch (Exception e)                  //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
            finally
            {
                try                              //关闭流
                {
                    if (fileWriter != null)
                    {
                        fileWriter.close();
                    }
                }
                catch (NullPointerException e)    //空指针异常
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.err.println("文件已经被关闭，无法再次关闭！！！");
                }
                catch (Exception e)              //其它异常
                {
                    Toolkit.getDefaultToolkit().beep();
                    e.printStackTrace();
                }
            }
        }
    }
}
