import java.io.File;
import java.util.LinkedList;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/23
 * Time(创建时间)： 20:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class class_getFiles_RelativePath
{
    public static void main(String[] args)          //H:\程序\大三上期\文件检验
    {
        LinkedList<String> list2;
        list2 = getFiles_RelativePath();
        System.out.println(list2.size());
        for (String s : list2)
        {
            System.out.println(s);
        }
    }

    public static LinkedList<String> getFiles_RelativePath()    //获取工作路径下的所有文件，返回相对路径
    {
        File file = new File("");
        String path = file.getAbsolutePath();
        LinkedList<String> list = new LinkedList<>();
        getFiles_RelativePath(path, list);
        LinkedList<String> list1 = new LinkedList<>();
        for (String s : list)
        {
            list1.add(s.substring(path.length() + 1));
        }
        list = null;
        return list1;
    }


    private static void getFiles_RelativePath(String path, LinkedList<String> list)
    {
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory())
        {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (File value : files)
            {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (value.isDirectory())
                {
                    //继续读取文件夹里面的所有文件
                    getFiles_RelativePath(value.getPath(), list);
                }
                else
                {
                    list.add(value.getPath());
                }
            }
        }
        else
        {
            list.add(file.getPath());
        }
    }
}
