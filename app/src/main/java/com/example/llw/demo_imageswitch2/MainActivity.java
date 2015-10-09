package com.example.llw.demo_imageswitch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private  Button btn1;
    private ImageSwitcher imageSwitcher;
    private  int index =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.button1);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.image);

        final int[] pictures = {R.drawable.alenafs,R.drawable.d,R.drawable.dd,R.drawable.e,R.drawable.f,
                R.drawable.h,R.drawable.j,R.drawable.k,R.drawable.mm,R.drawable.qq,R.drawable.r,R.drawable.s};

       imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        imageSwitcher.setImageResource(pictures[index]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 0) {
                    index--;
                } else {
                    index = pictures.length - 1;
                }
                imageSwitcher.setImageResource(pictures[index]);
            }
        });

        imageSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<pictures.length-1)
                {
                    index++;
                }else {
                    index = 0;
                }
                imageSwitcher.setImageResource(pictures[index]);
            }
        });

    }


}
