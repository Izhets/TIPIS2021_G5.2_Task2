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
        double T = 1 / frequency; //период
        double Ti = 1; //длительность импульса
        double m = 2 * Math.PI / T; //основная частота
        double m0 = 2 * Math.PI * frequency; //основная частота
//

//        f = -0.5 * (1 / T + 2/Math.PI);
//        for (float i = 0, k = 1; i < 1000 && k < 1000; i+=0.001, k+=0.001) {
//            x += (float) (1/k*(Math.sin(k*m*1)/2)*(Math.cos(k*m*i)));
//            series.add(i, f*x);
//        }



            for (float i = 0; i < 5; i += 0.01) {
                f = 2 * 1 * (Ti / T) * (Math.abs(Math.sin(i * m) * Ti / 2)) / i * m * Ti / 2;
                    series.add(i, f);
            }


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
