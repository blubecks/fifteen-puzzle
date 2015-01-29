package com.example.andreabeccaris.dragndrop;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage7).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage8).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage9).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage10).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage11).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage12).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage13).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage14).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.myimage15).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.one).setOnDragListener(new MyDragListener());
        findViewById(R.id.two).setOnDragListener(new MyDragListener());
        findViewById(R.id.three).setOnDragListener(new MyDragListener());
        findViewById(R.id.four).setOnDragListener(new MyDragListener());
        findViewById(R.id.five).setOnDragListener(new MyDragListener());
        findViewById(R.id.six).setOnDragListener(new MyDragListener());
        findViewById(R.id.seven).setOnDragListener(new MyDragListener());
        findViewById(R.id.eight).setOnDragListener(new MyDragListener());
        findViewById(R.id.nine).setOnDragListener(new MyDragListener());
        findViewById(R.id.ten).setOnDragListener(new MyDragListener());
        findViewById(R.id.eleven).setOnDragListener(new MyDragListener());
        findViewById(R.id.twelve).setOnDragListener(new MyDragListener());
        findViewById(R.id.thirteen).setOnDragListener(new MyDragListener());
        findViewById(R.id.fourteen).setOnDragListener(new MyDragListener());
        findViewById(R.id.fifteen).setOnDragListener(new MyDragListener());
        findViewById(R.id.empty).setOnDragListener(new MyDragListener());

    }

    private final class MyTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d(Constants.LOG,"Action Down");
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                Log.d(Constants.LOG,"Else branch touchListener");
                return false;
            }
        }
    }

    class MyDragListener implements OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            View view = (View) event.getLocalState();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    v.setBackgroundColor(Color.BLUE);
                    v.invalidate();
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    if (((DropCellView) v).getStatus())
                        Log.d(Constants.LOG,"PUOI DROPPPARE "+((DropCellView) v).getOrder());
                    else
                        Log.d(Constants.LOG,"NON PUOI DROPPPARE "+((DropCellView) v).getOrder());
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(Constants.LOG,"ACTION_DRAG_EXITED "+((DropCellView) v).getStatus());
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup

                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    Log.d(Constants.LOG, ((DropCellView) v).getStatus().toString());
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(Constants.LOG,"ACTION_DRAG_ENDED");
                    if (dropEventNotHandled(event)) {
                        view.setVisibility(View.VISIBLE);
                    }
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
        private boolean dropEventNotHandled(DragEvent dragEvent) {
            return !dragEvent.getResult();
        }
    }
}