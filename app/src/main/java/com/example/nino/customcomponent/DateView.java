package com.example.nino.customcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nino on 20/08/14.
 */
public class DateView extends TextView {

    public DateView(Context context) {
        super(context);
    }

    public DateView(Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.DateView);
        int count = array.getIndexCount();

        for(int i = 0; i < count; i++){
            int attr = array.getIndex(i);

            switch (attr){
                case R.styleable.DateView_delimiter:
                    String delimiter = array.getString(attr);
                    // todo: se need to do something with the delimiter
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
                    Date date = new Date();
                    String d = sdf.format(date);
                    this.setText(d);

                    break;
                case R.styleable.DateView_fancyText:
                    boolean fancyText = array.getBoolean(attr, false);
                    if(fancyText == true){
                        this.setTextAppearance(context, R.style.CustomDateView);
                    }
                    break;
            }
        }
        array.recycle();
    }

    public DateView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }
}
