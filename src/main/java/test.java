import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Project name(项目名称)：文件检验
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/23
 * Time(创建时间)： 22:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void MD5Write(TreeMap<String, String> map)
    {
        for (String s : map.keySet())
        {
            System.out.println("文件路径：" + s);
            System.out.println("MD5: " + map.get(s));
        }
        FileWriter fileWriter = null;
        try                                  //文件流打开，文件读写
        {
            fileWriter = new FileWriter("MD5.txt");
            fileWriter.write(map.size() + "\n");
            for (String s : map.keySet())
            {
                fileWriter.write(s + "\n");
                fileWriter.write(map.get(s) + "\n");
            }
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
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

    public static TreeMap<String, String> MD5Read()
    {
        TreeMap<String, String> map = new TreeMap<>();
        File file = new File("MD5.txt");
        Scanner input = null;
        int sum = 0;
        try                                  //文件流打开，文件读写
        {
            input = new Scanner(file);
            sum = Integer.parseInt(input.nextLine());
            String path;
            String MD5;
            for (int i = 0; i < sum; i++)
            {

                path = input.nextLine();
                MD5 = input.nextLine();
                map.put(path, MD5);
            }
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
                if (input != null)
                {
                    input.close();
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
        return map;
    }

    public static void MD5Verification(TreeMap<String, String> map)
    {
        int errorCount=0;
        String fileMD5;
        String calculateMD5;
        for (String path : map.keySet())
        {
            System.out.println("文件路径："+path);
            fileMD5=map.get(path);
            calculateMD5= class_getFileMD5.getFileMD5(path);
            System.out.println("文件中的MD5值："+fileMD5);

        }
    }

    public static void main(String[] args)
    {
        System.out.println("1.创建MD5文件   2.验证");
        System.out.print("请选择：");
        Scanner input = new Scanner(System.in);
        char ch = input.next().charAt(0);
        if (ch == '1')
        {
            LinkedList<String> list;
            list = class_getFiles_RelativePath.getFiles_RelativePath();
            //list.forEach(System.out::println);
            TreeMap<String, String> map = new TreeMap<String, String>();
            int sum = list.size();
            String md5;
            int i = 0;
            for (String path : list)
            {
                System.out.print("\b\b\b\b\b\b\b\b\b\b进度：" + (i + 1) + "/" + sum);
                md5 = class_getFileMD5.getFileMD5(path);
                map.put(path, md5);
                i++;
            }
            System.out.println();
            System.out.println("正在写入");
            MD5Write(map);
            System.out.println("写入完成");
        }
        else if (ch == '2')
        {
            TreeMap<String, String>map;
            map = MD5Read();
            /*
            for (String s : map.keySet())
            {
                System.out.println("文件路径：" + s);
                System.out.println("MD5: " + map.get(s));
            }
             */
            MD5Verification(map);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("输入错误！！！");
        }
    }
}
