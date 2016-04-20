package zwt.sean.lal.Base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import Dao.DaoMaster;
import Dao.DaoSession;
import de.greenrobot.dao.async.AsyncSession;

/**
 * Created by sean on 16/4/20.
 */
public class DBMaster {

    private DaoSession daoSession;
    private AsyncSession asyncSession;
    private static DBMaster master;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;

    public DBMaster(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "lal", null);
        daoMaster = new DaoMaster(helper.getReadableDatabase());
        daoSession = daoMaster.newSession();
        asyncSession = daoSession.startAsyncSession();
    }


    public static DBMaster init() {
        if (null == master) {
            synchronized (DBMaster.class) {
                if (null == master) {
                    master = new DBMaster(BaseApplication.getContext());
                }
            }
        }
        return master;
    }

    public DaoSession getSession() {
        return init().getDaoSession();
    }

    public AsyncSession getASession() {
        return init().getAsyncSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public AsyncSession getAsyncSession() {
        return asyncSession;
    }

    public void setAsyncSession(AsyncSession asyncSession) {
        this.asyncSession = asyncSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }
}
