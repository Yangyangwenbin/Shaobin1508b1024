package baway.bawie.shaobin1508b1024;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 朝朝暮暮 on 2017/10/24.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }
}
