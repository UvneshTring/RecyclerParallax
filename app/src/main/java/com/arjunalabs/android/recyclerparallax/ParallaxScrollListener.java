package com.arjunalabs.android.recyclerparallax;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by bobbyadiprabowo on 11/15/15.
 */
public class ParallaxScrollListener extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        ((ParallaxAdapter)recyclerView.getAdapter()).reTranslate();
    }
}
