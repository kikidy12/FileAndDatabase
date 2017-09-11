package com.example.the.fileanddatabase.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by the on 2017-09-11.
 */

public class ObjectManager2 {

    private static final String FILE_NAME = "memo2.obj";

    Context mContext;

    public ObjectManager2(Context context) {
        mContext = context;
    }

    public void save(HashMap<String, String> inputData) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(inputData);

            fos.close();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String , String> load () {
        try {
            FileInputStream fis = mContext.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String , String > data = (HashMap<String, String>) ois.readObject();

            fis.close();
            ois.close();

            return data;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }
}
