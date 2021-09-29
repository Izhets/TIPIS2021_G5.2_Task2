package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HarmonicSignalGraph {

    public ChartPanel drawGraph(double frequency) {

        XYSeries series = new XYSeries("sign(sin(2*Pi*frequency*t)) + 1");

//region Через сумму синусов

//        int f1 = (int) frequency;
//        int fd = 1000;
//        double w1 = 2 * Math.PI * f1 / fd;
//        double a1 = 4 / Math.PI;
//
//        for (float i = 0; i < 1000; i+=0.001) {
//            double x1 = Math.sin(w1 * i);
//            double x3 = 1 / 3.99F * Math.sin(3 * w1 * i);
//            double x5 = 1 / 5.99F * Math.sin(5 * w1 * i);
//            double x7 = 1 / 7.99F * Math.sin(7 * w1 * i);
//            double x9 = 1 / 9.99F * Math.sin(9 * w1 * i);
//            double x11 = 1 / 11.99F * Math.sin(11 * w1 * i);
//            double x13 = 1 / 13.99F * Math.sin(13 * w1 * i);
//            double x15 = 1 / 15.99F * Math.sin(15 * w1 * i);
//            double x17 = 1 / 17.99F * Math.sin(17 * w1 * i);
//            double x19 = 1 / 19.99F * Math.sin(19 * w1 * i);
//            double x21 = 1 / 21.99F * Math.sin(21 * w1 * i);
//            double x23 = 1 / 23.99F * Math.sin(23 * w1 * i);
//            double x25 = 1 / 25.99F * Math.sin(25 * w1 * i);
//            double x27 = 1 / 27.99F * Math.sin(27 * w1 * i);
//
//            double xSum = a1 * (x1 + x3 + x5 + x7 + x9 + x11 + x13 + x15 + x17 + x19 + x21 + x23 + x25 + x27);
//            if (xSum > 0) {
//                series.add(i, xSum);
//            }
//        }
//endregion

        double f = 0;
        for (float i = 0; i < 1; i += 0.0001) {
            f = Math.signum(Math.sin(2*Math.PI*frequency*i)) + 1;
                series.add(i, f);
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График импульсного сигнала (однополярный меандр)" + "\n Частота: " + frequency + " Гц", "t", "A (U)",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        ChartPanel frame =
                new ChartPanel(chart);
        frame.setPreferredSize(new Dimension(850, 500));


        return frame;

    }

}
