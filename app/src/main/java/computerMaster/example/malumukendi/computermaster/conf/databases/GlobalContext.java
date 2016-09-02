package computerMaster.example.malumukendi.computermaster.conf.databases;

import android.app.Application;
import android.content.Context;

/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public class GlobalContext extends Application {

    public static Context context;

    private static GlobalContext singleton;

    public void onCreate() {
        super.onCreate();
        GlobalContext.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return GlobalContext.context;
    }

    public static synchronized GlobalContext getInstance() {
        return singleton;
    }
}

