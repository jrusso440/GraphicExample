package edu.bu.graphicexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Handler;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLinearLayout;

    private static int textViewBg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xmldraw);
    }

    void changeBackground(View v){

        Resources res = getResources();
        Drawable myImage;
        int bgImgId;

        TextView myText = (TextView)findViewById(R.id.textViewid);
        myText.setBackgroundResource(R.drawable.shape1);
        if (textViewBg == 0) {
            textViewBg = 1;
            bgImgId = R.drawable.chatimages2p;
        } else {
            textViewBg = 0;
            bgImgId = R.drawable.shape1;
        }
        myText.setBackgroundResource(bgImgId);


        //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        //       myImage = res.getDrawable(textViewBg,null);
        //   else
        //       myImage = res.getDrawable(R.drawable.background);
        //myText.setBackground(myImage);

        ImageButton imageBtn = (ImageButton)(findViewById(R.id.imgBtnid));

        TransitionDrawable drawable = (TransitionDrawable) imageBtn.getDrawable();
        drawable.startTransition(3000);
        }

        void addImageView(View v) {

            // Find the LinearLayout in which to add the ImageView
            mLinearLayout = (LinearLayout) findViewById(R.id.linearlayout1);
            // Instantiate an ImageView and define its properties
            ImageView iV = new ImageView(this);
            iV.setImageResource(R.drawable.human);
            iV.setAdjustViewBounds(true); // set the ImageView bounds to match Drawable 's dim’s
            iV.setLayoutParams(new LinearLayout.LayoutParams // width / height
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            // Add the ImageView to the layout and set the layout as the content view
            mLinearLayout.addView(iV);
        }

    void nextScreen(View v){
        startActivity(new Intent(this, AnimationActivity.class));
    }
}
