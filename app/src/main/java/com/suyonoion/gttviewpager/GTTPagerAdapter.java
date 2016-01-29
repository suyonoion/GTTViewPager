package com.suyonoion.gttviewpager;

/**
 * Created by Suyono on 1/23/2016.
 * Copyright (c) 2016 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter
 */
public class GTTPagerAdapter extends PagerAdapter {

    private static final String TAG = "GTTPagerAdapter";
    private static final boolean DEBUG = true;

    private PagerAdapter adapter;

    public GTTPagerAdapter(PagerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getCount() {
        if (getRealCount() == 0) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    public int getRealCount() {
        return adapter.getCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int posisinya) {
        int posisiPalsu = posisinya % getRealCount();
        debug("instantiateItem: posisi sesungguhnya: " + posisinya);
        debug("instantiateItem: posisi palsu: " + posisiPalsu);
        return adapter.instantiateItem(container, posisiPalsu);
    }

    @Override
    public void destroyItem(ViewGroup container, int posisinya, Object object) {
        int posisiPalsu = posisinya % getRealCount();
        debug("destroyItem: posisi sesungguhnya: " + posisinya);
        debug("destroyItem: posisi palsu: " + posisiPalsu);
        adapter.destroyItem(container, posisiPalsu, object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        adapter.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }

    @Override
    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        adapter.restoreState(bundle, classLoader);
    }

    @Override
    public Parcelable saveState() {
        return adapter.saveState();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        adapter.startUpdate(container);
    }

    @Override
    public CharSequence getPageTitle(int posisinya) {
        int posisiPalsu = posisinya % getRealCount();
        return adapter.getPageTitle(posisiPalsu);
    }

    @Override
    public float getPageWidth(int posisinya) {
        return adapter.getPageWidth(posisinya);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int posisinya, Object object) {
        adapter.setPrimaryItem(container, posisinya, object);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        adapter.unregisterDataSetObserver(observer);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return adapter.getItemPosition(object);
    }

    private void debug(String message) {
        if (DEBUG) {
            Log.d(TAG, message);
        }
    }
}
