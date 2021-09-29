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

        XYSeries series = new XYSeries("T * (|Math.sin(i) * T / 2)| / i * (T / 2)");

        double f = 0;
        float T = (float) (1 / frequency); //период
        double Ti = T / 2; //длительность импульса
        double m = frequency; //основная частота
        double k = 1;

        series.add(0,0);

        for (float i = 1; i < 30; i+=0.001, k++) {
            //f = (Ti / T) * ((Math.abs(Math.sin(frequency * m) * Ti / 2)) / frequency * m * (Ti / 2));
            f = T * (Math.abs(Math.sin(i) * T / 2)) / i * (T / 2);

            series.add(m, f);
            m+=2 * Math.PI/T/10000;

        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("График спектра импульсного сигнала (однополярного меандра)" + "\n Частота: " + frequency + " Гц", "Гц", "А",
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
