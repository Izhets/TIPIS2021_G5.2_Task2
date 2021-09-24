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

   private List<Double> list = new ArrayList();

    public ChartPanel drawGraph(double frequency) {
        //frequency = 1 / frequency;
        XYSeries series = new XYSeries("A*cos(2*pi*t*frequency)");

//        for (float i = 1; i < 3; i += 0.01) {
//            series.add(i, Math.cos(((2 * Math.PI * i * frequency))));
//        }

//        float x = 0;
//        double f = 0;
//        double T = 1/frequency;
//        double m = 2*Math.PI/T;
//
//        f = -0.5 * (1 / T + 2/Math.PI);
//        for (float i = 0, k = 1; i < 10 && k < 500; i+=0.001, k+=0.001) {
////            f += (10*(i-(-1000)*3*2+1/2)-10*(i-(-1000)*2-1/2));
////            k = 2 * n + 1;
////            x = 4 / Math.PI;
////            f += (4 / k * Math.PI) * Math.sin(k * (2 * Math.PI / 8) * i);
////            x = f*x;
//
//            //f = 1/2.9F + 2/(float)(Math.PI)*((float)(Math.cos(2*Math.PI/frequency*i))-1/3.9F*(float)(Math.cos(3*2*Math.PI/frequency*i))+1/5.9F*(float)(Math.cos(5*2*Math.PI/frequency*i)));
//
//            x += (float) (1/k*(Math.sin(k*m*1)/2)*(Math.cos(k*m*i)));
//
//            series.add(i, f*x);
//        }

//            for (float i = -1000; i < 1000; i += 0.1) {
//                if ((-T / 2) < i && i < 0) {
//                    f = 0;
//                }
//                if (0 < i && i < Ti) {
//                    f = 1;
//                }
//                if (Ti < i && i < T / 2) {
//                    f = 0;
//                }
//                series.add(i, f);
//            }

        int f1 = (int) frequency;
        int fd = 1000;
        double w1 = 2 * Math.PI * f1 / fd;
        double a1 = 4 / Math.PI;

        for (float i = 0; i < 1000; i+=0.001) {
            double x1 = Math.sin(w1 * i);
            double x3 = 1 / 3.99F * Math.sin(3 * w1 * i);
            double x5 = 1 / 5.99F * Math.sin(5 * w1 * i);
            double x7 = 1 / 7.99F * Math.sin(7 * w1 * i);
            double x9 = 1 / 9.99F * Math.sin(9 * w1 * i);
            double x11 = 1 / 11.99F * Math.sin(11 * w1 * i);
            double x13 = 1 / 13.99F * Math.sin(13 * w1 * i);
            double x15 = 1 / 15.99F * Math.sin(15 * w1 * i);
            double x17 = 1 / 17.99F * Math.sin(17 * w1 * i);
            double x19 = 1 / 19.99F * Math.sin(19 * w1 * i);
            double x21 = 1 / 21.99F * Math.sin(21 * w1 * i);
            double x23 = 1 / 23.99F * Math.sin(23 * w1 * i);
            double x25 = 1 / 25.99F * Math.sin(25 * w1 * i);
            double x27 = 1 / 27.99F * Math.sin(27 * w1 * i);

            double xSum = a1 * (x1 + x3 + x5 + x7 + x9 + x11 + x13 + x15 + x17 + x19 + x21 + x23 + x25 + x27);
            if (xSum > 0) {
                series.add(i, xSum);
            }
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График импульсного сигнала (однополярный меандр)" + "\n Частота: " + frequency + " Гц", "t", "A",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        ChartPanel frame =
                new ChartPanel(chart);
        frame.setPreferredSize(new Dimension(850, 500));


        return frame;

    }

}
