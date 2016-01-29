# GTTViewPager
ViewPager GTT (Gulir Tak Terbatas) adalah
Circular Scrolling di ViewPager dengan Animasi CubeOutTransformer.

# Preview
![alt tag](https://raw.githubusercontent.com/suyonoion/GTTViewPager/master/demopreview/2016_01_29_17_59_14.gif)
YouTube link : https://youtu.be/eUTmBOpgg7U

# How To use
```
<com.suyonoion.gttviewpager.GTTViewPager 
    android:id="@+id/GTT_id" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:overScrollMode="never"/>
```
Jumlah page defaultnya 3 pages,
jika ingin lebih buat layout baru dan tambahkan di GTTViewPager.java
```
private int DaftarPage[] = {
            setResource("gtt_page1","layout"),
            setResource("gtt_page2","layout"),
            setResource("gtt_page3","layout"),
            setResource("nama_layout_baru","layout"
    };
```
# Source Project : 
https://github.com/suyonoion/GTTViewPager

# Download Demo Apk here
https://raw.githubusercontent.com/suyonoion/GTTViewPager/master/demopreview/GTTViewPager.apk

# Thanks to
- Allah Subhanahu wa Ta'ala
- antonyt for his answer
  on Original StackOverflow question: http://stackoverflow.com/questions/7546224/viewpager-as-a-circular-queue-wrapping
- Amazing Studio for free_video_to_gif_converter

# About Me
- Suyonoion, https://fb.com/suyono.ion

