package com.app.sunilmvp.utils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.sunilmvp.R;

/**
 * Created by MY PC on 03-Mar-18.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            dismissProgress();
        mProgressDialog = ProgressDialog.show(this, "Please w8", "");
    }

    protected void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
