package com.example.the.fileanddatabase.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by the on 2017-09-11.
 */

public class TxtManager {

    private final static String memoFileName = "memo.txt";

    Context mContext;

    public TxtManager(Context context) {
        mContext = context;
    }

    public void saveMemo (String inputMemo) {

        if (inputMemo == null || inputMemo.equals("")) {
            return;
        }

        FileOutputStream fos = null;

        try {
            fos = mContext.openFileOutput(memoFileName, Context.MODE_PRIVATE);

            fos.write(inputMemo.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadMemo () {
        try {
            FileInputStream fis = mContext.openFileInput(memoFileName);

            byte[] memoData = new byte[fis.available()];

            while (fis.read(memoData) != -1) {

            }

            fis.close();

            return new String(memoData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void close () {
        mContext.deleteFile(memoFileName);
    }
}
