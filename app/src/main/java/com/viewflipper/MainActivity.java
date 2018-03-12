package com.viewflipper;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements OnItemSelectedListener, ViewFactory
{
    private ImageSwitcher switcher;
    
    private Gallery gallery;
    
    private Button btn;
    
    private int[] mThumbIds = {R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.f, R.drawable.g, R.drawable.h,
        R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,};
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();
        switcher.setFactory(this); //������ͼ
        switcher.setInAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_left_in)); //���붯��
        switcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.drawable.push_left_out)); //�г�����
        gallery.setAdapter(new ImageAdapter(this, mThumbIds));
        gallery.setOnItemSelectedListener(this);
        btn.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    
    private void init()
    {
        switcher = (ImageSwitcher)findViewById(R.id.switcher);
        gallery = (Gallery)findViewById(R.id.gallery);
        btn = (Button)findViewById(R.id.btn);
    }
    
    /**
     * Gallery�����View�����¼�
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        // TODO Auto-generated method stub
        switcher.setImageResource(mThumbIds[position]);
    }
    
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * ʵ��ViewFactory��д�ķ���.
     * �÷�������һ��View��ʵ��
     * ���ʵ�����Ҫ��ImageSwitcher������ʾ��
     * �˴�����ImageView����ʾ����
     * ����ֱ�ӷ���һ���µ�ImageView��ʵ��
     * �ڴ˷����п�������ImageView��һЩ���ԣ�����
     */
    @Override
    public View makeView()
    {
        // TODO Auto-generated method stub
        ImageView view = new ImageView(this);
        view.setBackgroundColor(0xFF000000);
        view.setScaleType(ImageView.ScaleType.FIT_XY); //ͨ������ͼƬ���������View��������ԭ����
        view.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return view;
        //        return new ImageView(this);
    }
}
