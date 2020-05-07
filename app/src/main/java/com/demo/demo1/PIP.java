package com.demo.demo1;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PIP extends AppCompatActivity {
    private LinearLayout linearLayout;
    private PictureInPictureParams.Builder pictureParamBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pip);
        initPictureInPictureParams();
        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPictureInPictureFeature();
            }
        });
    }

    private void initPictureInPictureParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            pictureParamBuilder = new PictureInPictureParams.Builder();
    }

    private void startPictureInPictureFeature() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return;
        Rational aspectRation = new Rational(linearLayout.getWidth(), linearLayout.getHeight());
        pictureParamBuilder.setAspectRatio(aspectRation).build();
        enterPictureInPictureMode(pictureParamBuilder.build());
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

    }
}
