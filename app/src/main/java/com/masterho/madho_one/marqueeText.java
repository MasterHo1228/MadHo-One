package com.masterho.madho_one;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MasterHo on 2016/7/15.
 */
public class marqueeText extends TextView{
    public marqueeText(Context context) {
        super(context);
    }

    public marqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public marqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
