package com.hosamazzam.supportscreensize;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by hosam azzam on 20/11/2016.
 */

public class SupportScreenSize {
    private Context context;
    private Activity activity;
    private int height;
    private int width;
    private float density;
    private float heightdp;
    private float widthdp;

    public Context getContext() {
        return this.context;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public float getDensity() {
        return this.density;
    }

    public float getHeightIndp() {
        return this.heightdp;
    }

    public float getWidthIndp() {
        return this.widthdp;
    }


    public SupportScreenSize(Context _context) {
        if (_context == null) {
            throw new RuntimeException("Context is null you need to call constructor first or pass it as parameter");
        } else {
            this.context = _context;
            this.activity = (Activity) _context;
            init();
        }

    }

    public SupportScreenSize(Context _context, Activity _activity) {
        if (_context == null) {
            throw new RuntimeException("Context is null you need to call constructor first or pass it as parameter");
        } else if (_activity == null) {
            throw new RuntimeException("Activity is null you need to call constructor first or pass it as parameter");
        } else {
            this.context = _context;
            this.activity = _activity;
            init();
        }
    }

    private void init() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        this.height = displaymetrics.heightPixels;
        this.width = displaymetrics.widthPixels;
        this.density = this.context.getResources().getDisplayMetrics().density;
        this.heightdp = this.height / this.density;
        this.widthdp = this.width / this.density;
    }

    public void reinit() {
        if (this.context == null) {
            throw new RuntimeException("Context is null you need to call constructor first or pass it as parameter");
        } else init();
    }

    public void reinit(Context _context) {
        this.context = _context;
        this.activity = (Activity) _context;
        init();
    }

    public void reinit(Context _context, Activity _activity) {
        this.context = _context;
        this.activity = _activity;
        init();
    }

    public boolean isTablet() {
        // sw600dp
        return (Math.min(this.widthdp, this.heightdp) < 720 && Math.min(this.widthdp, this.heightdp) >= 600);
    }

    public boolean isPhone() {
        // sw320dp
        return (Math.min(this.widthdp, this.heightdp) >= 320 && Math.min(this.widthdp, this.heightdp) < 480);
    }

    public boolean isPhab() {
        // sw480dp
        return (Math.min(this.widthdp, this.heightdp) < 600 && Math.min(this.widthdp, this.heightdp) >= 480);
    }

    public boolean isLargeTablet() {
        // sw720dp
        return (Math.min(this.widthdp, this.heightdp) >= 720);
    }

    public String isTabletDevice() {
        // sw600dp
        return isTablet() ? "This device is Tablet  (7\" tablet)." : "This device is not Tablet (7\" tablet).";
    }

    public String isPhoneDevice() {
        // sw320dp
        return isPhone() ? "This device is normal phone/handset." : "This device is not normal phone/handset.";
    }

    public String isPhabDevice() {
        // sw480dp
        return isPhab() ? "This device is Phab" : "This device is not Phab";
    }

    public String isLargeTabletDevice() {
        // sw720dp
        return isLargeTablet() ? "This device is Large Tablet  (10\" tablet)." : "This device is not Larage Tablet  (10\" tablet).";
    }

    public String checkDeviceType() {
        if (isPhone()) return "This device is normal phone/handset.";
        else if (isPhab()) return "This device is Phab";
        else if (isTablet()) return "This device is Tablet  (7\" tablet).";
        else if (isLargeTablet()) return "This device is Large Tablet  (10\" tablet).";
        else return "Can't detect device type";
    }
}
