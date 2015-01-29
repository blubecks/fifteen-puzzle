package com.example.andreabeccaris.dragndrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by andreabeccaris on 1/29/15.
 */
public class DropCellView extends LinearLayout {


    public DropCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.DropCellView, 0, 0);
        Integer i = a.getInteger(R.styleable.DropCellView_value,-1);
        Boolean b = a.getBoolean(R.styleable.DropCellView_empty,false);
        Log.d(Constants.LOG,i+"AAAAAAAAAAA");
        Log.d(Constants.LOG,b.toString()+" test");
        a.recycle();
    }
}
