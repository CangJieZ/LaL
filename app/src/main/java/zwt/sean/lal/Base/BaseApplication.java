package zwt.sean.lal.Base;

import android.app.Application;
import android.content.Context;

import Dao.DaoMaster;
import Dao.DaoSession;
import de.greenrobot.dao.async.AsyncSession;

/**
 * Created by sean on 16/4/20.
 */
public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
