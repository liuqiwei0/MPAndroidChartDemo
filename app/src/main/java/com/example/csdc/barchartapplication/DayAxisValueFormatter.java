package com.example.csdc.barchartapplication;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by csdc on 2018/11/13.
 */

public class DayAxisValueFormatter implements IAxisValueFormatter {
    protected String[] mMonths = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13"
    };

    private BarLineChartBase<?> chart;

    public DayAxisValueFormatter(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        int days = (int) value - 1;
            return mMonths[days];
        }
}
