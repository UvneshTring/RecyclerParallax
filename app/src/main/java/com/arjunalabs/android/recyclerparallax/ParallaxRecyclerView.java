package com.arjunalabs.android.recyclerparallax;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by bobbyadiprabowo on 6/5/15.
 */
public class ParallaxRecyclerView extends RecyclerView {

    public ParallaxRecyclerView(Context context) {
        super(context);
    }

    public ParallaxRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void setupParallax(Context context) {
        setLayoutManager(new LinearLayoutManager(context));
        ParallaxScrollListener parallaxScrollListener = new ParallaxScrollListener();
        addOnScrollListener(parallaxScrollListener);
    }

}
