package com.example.csdc.barchartapplication;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;

import java.util.ArrayList;
import java.util.List;


public class FourActivity extends AppCompatActivity {

    private RadarChart mRadarChart;
    List<String> options = new ArrayList<>();
    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140),
            Color.rgb(140, 234, 255), Color.rgb(255, 140, 157), Color.rgb(193, 37, 82),
            Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31),
            Color.rgb(179, 100, 53),Color.rgb(64, 89, 128), Color.rgb(149, 165, 124),
            Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_four);
        options.add("选项一");
        options.add("选项二");
        options.add("选项三");
        options.add("选项四");


        mRadarChart = findViewById(R.id.raderChart);
        MyAxisValueFormatter formatter = new MyAxisValueFormatter();
        XAxis xAxis = mRadarChart.getXAxis();
        xAxis.setValueFormatter(formatter);
        YAxis yAxis = mRadarChart.getYAxis();
        yAxis.setAxisMinimum(0);
        List<RadarEntry> radarEntries = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            radarEntries.add(new RadarEntry((i+1)*10));
            //xAxis.setTextColor(VORDIPLOM_COLORS[i]);
        }

        Legend legend = mRadarChart.getLegend();
        //图例放在左下方
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);//图例水平排列
        legend.setDrawInside(false);
        List<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            entries.add(new LegendEntry(options.get(i), Legend.LegendForm.CIRCLE,14f,9f,null,VORDIPLOM_COLORS [i]));
        }
        legend.setCustom(entries);

        RadarDataSet dataSet = new RadarDataSet(radarEntries,"");
        RadarData radarData = new RadarData(dataSet);
        mRadarChart.animateXY(1000,1000);
        mRadarChart.setData(radarData);
        mRadarChart.invalidate();
    }

}
