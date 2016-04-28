package zwt.sean.lal.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by sean on 16/4/28.
 */
public class FileUtils {

    private static String getDirPath() {
        String sdDir = "";
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory()+"/";//获取SD卡路径目录
        }else{
            sdDir = Environment.getRootDirectory()+"/";
        }
        return sdDir;
    }

    /**
     * 创建文件夹
     * @param name
     * @return
     */
    public static File makerFolder(String name){
        File file = new File(getDirPath()+name);
        if (!file.exists())
            file.mkdirs();
        return file;
    }
}
