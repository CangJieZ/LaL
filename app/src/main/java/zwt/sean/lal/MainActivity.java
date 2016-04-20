package zwt.sean.lal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Dao.UserDao;
import greendao.User;
import zwt.sean.lal.Base.DBMaster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDao dao = DBMaster.init().getDaoSession().getUserDao();
        User user = new User();
        user.setPhone("18767196567");
        dao.insert(user);
        User user1 = dao.queryBuilder().where(UserDao.Properties.Phone.eq("18767196567")).unique();
        Log.e("lal",user1.getPhone()+"");
    }
}
