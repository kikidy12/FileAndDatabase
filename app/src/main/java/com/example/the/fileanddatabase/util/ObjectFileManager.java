package com.example.the.fileanddatabase.util;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private static final String FILE_NAME  = "memo.obj";

    Context mContext;

    public ObjectFileManager(Context context) {
        mContext = context;
    }

    public void svae(HashMap<String, String> objData) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
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

}
