package com.viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SecondActivity extends Activity implements OnItemClickListener, OnGestureListener {
    private GestureDetector detector;
    private ViewFlipper flipper;
    private Gallery gallery;
    private int[] mImage = {R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        detector = new GestureDetector(this);
        init();
        gallery.setAdapter(new ImageAdapter(this, mImage));
        gallery.setOnItemClickListener(this);
        for (int i = 0; i < mImage.length; i++) {
            flipper.addView(getImageView(mImage[i]));
        }
    }

    private void init() {
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        gallery = (Gallery) findViewById(R.id.gallery_second);
    }

    private View getImageView(int id) {
        ImageView view = new ImageView(this);
        view.setImageResource(id);
        return view;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        flipper.setDisplayedChild(position);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // TODO Auto-generated method stub
        if (e1.getX() - e2.getX() > 120) {
            flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_left_in));
            flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_left_out));
            flipper.showNext(); //��ʾ��һ��
            gallery.setSelection(flipper.getDisplayedChild());
            return true;
        } else if (e2.getX() - e1.getX() > 120) {
            flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_right_in));
            flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_right_out));
            flipper.showPrevious();
            gallery.setSelection(flipper.getDisplayedChild());
            return true;
        }

        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

}
