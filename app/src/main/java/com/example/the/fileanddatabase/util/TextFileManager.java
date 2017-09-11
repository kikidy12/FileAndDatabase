package com.example.the.fileanddatabase.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by the on 2017-09-11.
 */

public class TextFileManager {

    private final static String memoFileName = "memo.txt";

    Context mContext;

    public TextFileManager(Context context) {
        mContext = context;
    }

    public void saveMemo(String inputData) {
        // 들어오는 String 객체를 내장메모리의 파일로 저장.

        if(inputData == null || inputData.equals("")) {
            // 메모의 내용이 들어오지 않으면 세이브 동작을 취소
            return;
        }

        FileOutputStream fosMemo = null;

        try {
            fosMemo = mContext.openFileOutput(memoFileName, Context.MODE_PRIVATE);

            fosMemo.write(inputData.getBytes());
            fosMemo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load() {

        try {
            FileInputStream fisMemo = mContext.openFileInput(memoFileName);

            byte[] memoData = new byte[fisMemo.available()];

            while (fisMemo.read(memoData) != -1) {
                // 파일이 끝날때가지 계속해서 읽어들인다.
                // read의 결과가 -1이라는 것은 파일이 종료됨을 의미함.
            }

            fisMemo.close();

            return new String(memoData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
