package com.slobodsky.nick.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    Button button;

    Random r;

    int angle;

    int speed = 1000;

    boolean restart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.bottleImgView);

        button = (Button) findViewById(R.id.btnSpin);

        r = new Random();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (restart){

                angle = angle % 360;

                RotateAnimation rotate = new RotateAnimation(angle, 0,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setFillAfter(true);

                rotate.setDuration(speed);

                speed = speed - 40;

                rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                imageView.startAnimation(rotate);

                button.setText("Go");

                restart = false;

                }
                else
                {
                    angle = r.nextInt(3600) + 360;

                    RotateAnimation rotate = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    rotate.setFillAfter(true);

                    rotate.setDuration(speed);

                    speed = speed - 40;

                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    imageView.startAnimation(rotate);

                    restart = true;

                    button.setText("Reset");
                }
            }
        });
    }
}
