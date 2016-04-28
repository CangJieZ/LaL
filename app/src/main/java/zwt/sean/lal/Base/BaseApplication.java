package zwt.sean.lal.Base;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import zwt.sean.lal.common.Constant;
import zwt.sean.lal.utils.FileUtils;

/**
 * Created by sean on 16/4/20.
 */
public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initImageLoader(context);
    }

    public static Context getContext(){
        return context;
    }


    /**
     * 初始化ImageLoader
     * @param context
     */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.diskCache(new UnlimitedDiskCache(FileUtils.makerFolder("lalCache")));//缓存地址
        config.memoryCacheSize(Constant.MAX_MEMORY);//最大缓存
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
//        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());//MD5加密文件名
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app
        config.imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000));//超时时间
        ImageLoader.getInstance().init(config.build());
    }
}
