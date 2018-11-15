package com.example.csdc.barchartapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private BarChart barChart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart = (BarChart) findViewById(R.id.barchart);


        //这里使用两个方法，一个控制数据，一个控制视图
        BarData barData = setInitData();


        //设置图表的属性
        setBarData(barData);
    }


    private void setBarData(BarData barData) {
        barChart.setData(barData);
        barChart.setDrawBorders(true);   //设置图标是否要边框，当然也可以设置边框的颜色大少等、
        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);   //设置不要描述


        barChart.setDrawGridBackground(true);    //是否显示表格颜色
        //barChart.setGridBackgroundColor(Color.RED);   //设置红色




        barChart.setTouchEnabled(false); // 设置是否可以触摸
        barChart.setDragEnabled(false);// 是否可以拖拽
        barChart.setScaleEnabled(false);// 是否可以缩放
        barChart.setPinchZoom(false);//y轴的值是否跟随图表变换缩放;如果禁止，y轴的值会跟随图表变换缩放


        //       barChart.setBackgroundColor(Color.BLACK);// 设置整个图表控件的背景


        //       barChart.setDrawBarShadow(true);//柱状图没有数据的部分是否显示阴影效果


        //       barChart.setDrawValueAboveBar(false);//柱状图上面的数值是否在柱子上面


        //是否显示竖直标尺线
        barChart.getXAxis().setDrawGridLines(false);
        //设置横坐标之间的间隔距离 float值
        //       barChart.getXAxis().setSpaceMax(50);


        //右侧是否显示Y轴数值
        barChart.getAxisRight().setDrawLabels(false);


        //是否显示最右侧竖线
        barChart.getAxisRight().setEnabled(false);



    }


    //初始化数据
    private BarData setInitData() {
        ArrayList<String> xValues = new ArrayList<>();
        for(int i =0 ;i<3;i++){
            xValues.add(i+"");
        }


        ArrayList<BarEntry> barentryS = new ArrayList<>();
        for(int i = 0 ; i<3;i++){
            barentryS.add(new BarEntry(i,(float)(Math.random()*10)+3));
        }


        BarDataSet barDataSet = new BarDataSet(barentryS,"测试数据");


        ArrayList<IBarDataSet> iBarDataSet = new ArrayList<>();
        iBarDataSet.add(barDataSet);


        BarData barData = new BarData(iBarDataSet);
        //barChart.setData(barData);
        return  barData;
    }
}
