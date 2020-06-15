package edu.bu.graphicexample;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimationActivity extends AppCompatActivity {

    private ImageView animationIV;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        //set up the animation through xml file
        ImageView image = (ImageView) findViewById(R.id.chatimageview);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.animateexample);
        image.startAnimation(hyperspaceJump);

        LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linearlayout2);


        animationIV = new ImageView(this);
        animationIV.setBackgroundResource(R.drawable.animationlist);
        frameAnimation =
                (AnimationDrawable) animationIV.getBackground();

       //  frameAnimation.start();

        mLinearLayout.addView(animationIV);
    }


    public void addAnimation(View v) {

        // the animation will start after 1s
        Handler animationHandler = new Handler();
        animationHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        }, 1000);

        //the animation will stop after 6s
        animationHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                frameAnimation.stop();
            }
        },6000);

    }

    void nextScreen(View v){
        startActivity(new Intent(this, CanvasActivity.class));
    }


}
