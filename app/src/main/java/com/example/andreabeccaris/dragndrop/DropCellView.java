package com.example.andreabeccaris.dragndrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by andreabeccaris on 1/29/15.
 */
public class DropCellView extends LinearLayout {

    private int order;
    private Boolean status;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public DropCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.DropCellView, 0, 0);
        order = a.getInt(R.styleable.DropCellView_value,-1);
        status = a.getBoolean(R.styleable.DropCellView_empty,false);
        a.recycle();
    }
}
