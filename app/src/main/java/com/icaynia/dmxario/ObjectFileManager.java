package com.icaynia.dmxario;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by icaynia on 16/08/18.
 */
public class ObjectFileManager {

    Context mContext = null;

    public ObjectFileManager(Context _context) {
        mContext = _context;
    }

    public void save(HashMap<String, String> objData, String filename) {
        this.initsetfolder();


        if (objData == null || objData.isEmpty()) {
            return;

        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("/sdcard/DMXArio/"+"scene0.scn"));
            oos.writeObject(objData);
            oos.close();
            Log.e("ObjectFileManager", "save completed.");
        }catch (Exception e) {
            Log.e("ObjectFileManager", "Save Error!");
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, String> load() {
        try
        {
            FileInputStream fis = new FileInputStream("/sdcard/DMXArio/"+"scene0.scn");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, String> memoData = null;
            memoData = (HashMap<String,String>) ois.readObject();

            ois.close();

            return memoData;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String filename) {
        mContext.deleteFile(filename);
    }

    public void initsetfolder() {

        String dirPath = "/sdcard/DMXArio";   //DMXArio root
        File file = new File(dirPath);
        if( !file.exists() ) {
            file.mkdirs();
        }

        dirPath = "/sdcard/DMXArio/Controller";   //DMXArio Controller
        file = new File(dirPath);
        if( !file.exists() ) {
            file.mkdirs();
        }

    }

}