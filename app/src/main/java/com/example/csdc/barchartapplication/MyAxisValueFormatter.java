package com.example.csdc.barchartapplication;

import android.graphics.Color;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by csdc on 2018/11/13.
 */

public class MyAxisValueFormatter implements IAxisValueFormatter {
    //private DecimalFormat mFormat;
    String[] mStrings = new String[]{
            "选项一", "选项二", "选项三","选项四"
    };
    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140),
            Color.rgb(140, 234, 255), Color.rgb(255, 140, 157), Color.rgb(193, 37, 82),
            Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31),
            Color.rgb(179, 100, 53),Color.rgb(64, 89, 128), Color.rgb(149, 165, 124),
            Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)
    };
    public MyAxisValueFormatter() {
       // mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        axis.setTextColor(VORDIPLOM_COLORS[(int)value+2]);
        return mStrings[(int)value];
    }

}
