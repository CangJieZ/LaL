package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    public static void main(String args[]) throws Exception {
        //初始化一下数据库
        //第一个参数是版本号,第二个参数是为你生成的bean类放的文件夹名
        Schema schema = new Schema(1, "greendao");

        //设置一下生成的三个java文件的目录
        schema.setDefaultJavaPackageDao("Dao");
        Entity User = schema.addEntity("User");
        User.addIdProperty();
        User.addStringProperty("phone");
        new DaoGenerator().generateAll(schema, args[0]);
    }
}
