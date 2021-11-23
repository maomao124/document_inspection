import java.io.File;
import java.util.LinkedList;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): class_getFiles_AbsolutePath2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/23
 * Time(创建时间)： 22:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class class_getFiles_AbsolutePath2
{
    public static LinkedList<String> getFiles_AbsolutePath(String paths)   //获取某路径下的所有文件，返回绝对路径
    {
        File file = new File(paths);
        String path = file.getAbsolutePath();
        LinkedList<String> list = new LinkedList<>();
        getFiles_AbsolutePath(path, list);
        return list;
    }

    private static void getFiles_AbsolutePath(String clientBase, LinkedList<String> list)
    {
        File file = new File(clientBase);
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
                    getFiles_AbsolutePath(value.getPath(), list);
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

    public static void main(String[] args)
    {
        LinkedList<String>list=getFiles_AbsolutePath("H:\\程序\\大三上期");
        list.forEach(System.out::println);
        System.out.println(list.size());
        System.out.println("数量："+list.size());
    }
}
