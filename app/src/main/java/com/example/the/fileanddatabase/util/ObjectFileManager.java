package com.example.the.fileanddatabase.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
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

public class ObjectFileManager {
    // 확장자는 뭘로해도됨.
    // 단지 읽고 쓰는데 지장이 없어야함.
    // ex) .csv의 경우 항목마다 쉼표를 넣어줘야 한다.
    // 다른 프로금램이 활용하지 않는 확장자를 독자적으로 사용한다면, 굳이 가공할 필요가 없다.
    private static final String FILE_NAME = "memo.obj";
    private static final String EXTERNAL_FULL_PATH  = Environment.getExternalStorageDirectory().getAbsolutePath() + "/memo.obj";

    Context mContext;

    public ObjectFileManager(Context context) {
        mContext = context;
    }

    public void svae(HashMap<String, String> objData) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
//            fos = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos = new FileOutputStream(EXTERNAL_FULL_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objData);

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> load() {

        try {
//            FileInputStream fis = mContext.openFileInput(FILE_NAME);
            FileInputStream fis = new FileInputStream(EXTERNAL_FULL_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String , String> retureMemoData = null;
            retureMemoData = (HashMap<String, String>) ois.readObject();

            ois.close();
            fis.close();

            return retureMemoData;

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
//        mContext.deleteFile(FILE_NAME);

        // 외장 메모리 파일 삭제
        File deleteFile = new File(EXTERNAL_FULL_PATH);
        deleteFile.delete();
    }

}
