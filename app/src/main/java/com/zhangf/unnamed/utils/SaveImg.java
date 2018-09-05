package com.zhangf.unnamed.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by 75232 on 2018/9/4
 * Email：752323877@qq.com
 */
public class SaveImg {

    public static boolean saveImg(Bitmap bitmap, String name, Context context) {
        try {
            String sdcardPath = context.getExternalCacheDir().getPath();      //获得sd卡路径
//            String dir = sdcardPath + "/每日看看/";                    //图片保存的文件夹名


//            File file = new File(dir);                                 //已File来构建
//            if (!file.exists()) {                                     //如果不存在  就mkdirs()创建此文件夹
//                file.mkdirs();
//            }
            Log.i("SaveImg", "file uri==>" + sdcardPath);
            File mFile = new File(sdcardPath +"/"+ name);                        //将要保存的图片文件
            if (mFile.exists()) {
                Toast.makeText(context, "该图片已存在!", Toast.LENGTH_SHORT).show();
                return false;
            }
            Log.i("SaveImg", "file uri==>" + mFile.getPath());

            FileOutputStream outputStream = new FileOutputStream(mFile);     //构建输出流
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);  //compress到输出outputStream
            Uri uri = Uri.fromFile(mFile);                                  //获得图片的uri
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri)); //发送广播通知更新图库，这样系统图库可以找到这张图片
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
