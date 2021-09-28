package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class SignalSpectrum {

    public ChartPanel drawSignalSpectrum(double frequency) {

        XYSeries series = new XYSeries("");

        double f = 0;


        float T = (float) (1 / frequency); //период
        double Ti = T / 2; //длительность импульса
        double m = frequency; //основная частота

        double a = 0.5/T + 2*Math.PI;
        double k = 1;

        double m0 = 2 * Math.PI * frequency;
        double omega = 2 * Math.PI / Ti;

        double [] arr = new double[30];

        series.add(0,0);

        for (float i = 1; i < 30; i+=0.001, k++) {
            //f = (Ti / T) * ((Math.abs(Math.sin(frequency * m) * Ti / 2)) / frequency * m * (Ti / 2));
                f = T * (Math.abs(Math.sin(i) * T / 2)) / i * (T / 2);
            //System.out.println(m/10 + " " + f);

            series.add(m, f);
            m+=2 * Math.PI/T/10000;

//            f = 4/Math.PI*(Math.sin(2*Math.PI*m*i)+1/3.f*Math.sin(6*Math.PI*m*i)+1/5.f*Math.sin(10*Math.PI*m*i));
//            series.add(i, f);

            //f += 1/k*Math.sin(k*m*0.5/2)*Math.cos(k*m*i);
            //series.add(i, a*f);
        }

//        double n = 0;
//        for (float i = 0; i < 30 && n<30; i += 0.0001) {
//            f = Math.signum(Math.sin(2*Math.PI*m*n*i)) + 1;
//            series.add(i, f);
//            n++;
//        }

//        for (int i = 0; i < 30; i++) {
//            series.add(a += 2 * Math.PI / T, arr[i]);
//        }


//        for (float i = 0; i < 1000; i += 0.01) {
//            if (-T/4 < i && i < T/4) {
//                series.add(i, 1);
//            }
//            if ( T / 4 < i && i < 3/4.f*T) {
//                series.add(i, 0);
//            }
//        }


        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График спектра гармонического сигнала" + "\n Частота: " + frequency + " Гц", "t", "A",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

        ChartPanel frame =
                new ChartPanel(chart);
        frame.setPreferredSize(new

                Dimension(850, 500));

        return frame;
    }

}
