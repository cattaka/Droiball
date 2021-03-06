
package net.cattaka.droiball;

import android.app.Application;
import android.content.res.AssetManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File dbFile = getDatabasePath(Constants.DB_NAME);
        if (!dbFile.exists()) {
            AssetManager am = getAssets();
            try {
                {
                    if (!dbFile.getParentFile().exists()) {
                        dbFile.getParentFile().mkdirs();
                    }
                    dbFile.createNewFile();
                }
                InputStream in = am.open("orig_" + Constants.DB_NAME);
                OutputStream out = new BufferedOutputStream(new FileOutputStream(dbFile));
                byte[] buf = new byte[1 << 14];
                int r;
                while ((r = in.read(buf)) > 0) {
                    out.write(buf, 0, r);
                }
                out.flush();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
