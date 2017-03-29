
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lichenyang on 2017/3/29.
 */
public class ScanDirText extends Thread implements Runnable{

    private String scanPath;
    private List<File> filelist;
    private ScanView view;
    public ScanDirText(String path, ScanView view){
        this.scanPath = path;
        this.view = view;
        filelist = new ArrayList<File>();
    }

    /**
     * 得到路径下的所有指定类型的文件
     * @param strPath 路径
     * @param fileType 文件类型 eg:lua
     * @return
     */
    public void getFileList(String strPath, String fileType) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(), fileType); // 获取文件绝对路径
                } else if (fileName.endsWith(fileType)) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }
        }
    }

    public List<String> getMatcherStrList(File file){
        List<String> strList = new ArrayList<String>();
        String content = this.getFileContent(file);
        String regEx = "\"[\\u0391-\\uFFE5]+\"";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(content);
        while (matcher.find())
        {
            int start = matcher.start();
            int end = matcher.end();
            String match = content.substring(start, end);
            strList.add(match);
        }
        return strList;
    }

    public String getFileContent(File file){
        String tempString = null;
        String content = "";
        try {
            InputStream stream = new FileInputStream(file);
            InputStreamReader inputFileReader = new InputStreamReader(stream, "utf-8");
            BufferedReader reader = new BufferedReader(inputFileReader);

            while ((tempString = reader.readLine()) != null) {
                content += tempString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  content;
    }

    @Override
    public void run() {
        int num=0;
        this.getFileList(this.scanPath, "lua");
        for (File file: this.filelist) {
            List<String> strList = this.getMatcherStrList(file);
            for (String str: strList) {
                num++;
                this.view.setTitleNum(num);
                try{
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            view.addString(str);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
