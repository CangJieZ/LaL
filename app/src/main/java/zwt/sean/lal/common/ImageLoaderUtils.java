package zwt.sean.lal.common;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import zwt.sean.lal.R;

/**
 * Created by sean on 16/4/28.
 */
public class ImageLoaderUtils {

    public static ImageLoaderUtils sImageLoaderUtils;

    public static DisplayImageOptions sImageOptions;

    public ImageLoaderUtils() {
        sImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                        //.delayBeforeLoading(int delayInMillis)//int delayInMillis为你设置的下载前的延迟时间
                        //设置图片加入缓存前，对bitmap进行设置
                        //.preProcessor(BitmapProcessor preProcessor)
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
//                .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
                .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                .build();//构建完成
    }


    public static ImageLoaderUtils getInstance() {
        if (null == sImageLoaderUtils) {
            synchronized (ImageLoaderUtils.class) {
                if (null == sImageLoaderUtils) {
                    sImageLoaderUtils = new ImageLoaderUtils();
                }
            }
        }
        return sImageLoaderUtils;
    }

    public void displayImg(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView, sImageOptions);
    }

}
