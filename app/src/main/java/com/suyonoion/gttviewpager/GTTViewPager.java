package com.suyonoion.gttviewpager;

/**
 * Created by Suyono on 1/23/2016.
 * Copyright (c) 2016 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings("ALL")
public class GTTViewPager extends ViewPager {
    /* getIdentifier untung menghilangkan id dalam smali */
    public int setResource(String NamaFile, String NamaFolder)
    {
        return getContext().getResources().getIdentifier(NamaFile, NamaFolder, getContext().getPackageName());
    }
    /**
     * Deklarasi variabel
     * tambah layout disini
     */
    private int DaftarPage[] = {
            setResource("gtt_page1","layout"),
            setResource("gtt_page2","layout"),
            setResource("gtt_page3","layout")
    };

    /********************************************************/
    public GTTViewPager(Context context) {
        super(context);
        /* eksekusi kodeutama */
        GTTkodeUtama();
    }

    public GTTViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        GTTkodeUtama();
    }

    /******************************************************/

    /* skrip kode utama */
    private void GTTkodeUtama() {
        PagerAdapter adapter = new GTTPagerAdapter(new PagerAdapter() {
            /* dapatkan
            * jumlah dari jumlah array (daftar page)
            */
            public int getCount() {
                return DaftarPage.length;
            }
            /* instantiateItem,
            *  kondisi jika posisinya 0 ke layout no.0 dst
            */
            public Object instantiateItem (ViewGroup koleksi,int posisi) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View pageLayout = null;
                for (int i=0; i<=DaftarPage.length; i++) {
                    if (posisi == i) {
                        pageLayout = inflater.inflate(DaftarPage[i],null,false);
                    }
                }
                ((ViewPager) koleksi).addView(pageLayout);
                return pageLayout;
            }


            @Override
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView((View) arg2);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public Parcelable saveState() {
                return null;
            }
        });

        ViewPager GTTVP = (ViewPager) findViewById(setResource("GTT_id","id"));
        GTTVP.setAdapter(adapter);
        GTTVP.setPageTransformer(true, new PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                final float rotation = (position < 0 ? 90f : -90f) * Math.abs(position);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    view.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
                    view.setPivotX(position < 0f ? view.getWidth() : 0f);
                    view.setPivotY(view.getHeight() * 0.5f);
                    view.setRotationY(90f * position);
                }
            }
        });
    }

    /********************************************************/
    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(0);
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean gulungHalus) {
        if (getAdapter().getCount() == 0) {
            super.setCurrentItem(item, gulungHalus);
            return;
        }
        item = getOffsetAmount() + (item % getAdapter().getCount());
        super.setCurrentItem(item, gulungHalus);
    }

    @Override
    public int getCurrentItem() {
        if (getAdapter().getCount() == 0) {
            return super.getCurrentItem();
        }
        int posisi = super.getCurrentItem();
        if (getAdapter() instanceof GTTPagerAdapter) {
            GTTPagerAdapter gttAdapter = (GTTPagerAdapter) getAdapter();
            return (posisi % gttAdapter.getRealCount());
        } else {
            return super.getCurrentItem();
        }
    }

    private int getOffsetAmount() {
        if (getAdapter().getCount() == 0) {
            return 0;
        }
        if (getAdapter() instanceof GTTPagerAdapter) {
            GTTPagerAdapter gttAdapter = (GTTPagerAdapter) getAdapter();
            return gttAdapter.getRealCount() * 100;
        } else {
            return 0;
        }
    }

}