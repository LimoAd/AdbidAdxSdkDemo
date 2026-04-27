package com.yiman.ad.adbid;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.gyf.immersionbar.ImmersionBar;

public class BaseActivity extends FragmentActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionBar.with(this).fullScreen(true).init();
        super.onCreate(savedInstanceState);
    }
}
