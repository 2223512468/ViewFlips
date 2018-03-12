package com.viewflipper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter
{
    private Context mContext;
    
    private int[] image;
    
    public ImageAdapter(Context mContext, int[] image)
    {
        super();
        this.mContext = mContext;
        this.image = image;
    }
    
    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return image.length;
    }
    
    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }
    
    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ImageView view = new ImageView(mContext);
        view.setImageResource(image[position]);
        view.setAdjustViewBounds(true);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        return view;
    }
    
}