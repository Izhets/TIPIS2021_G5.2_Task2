package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame {
    private JPanel mainPanel;
    private JPanel jfreeChartPanel;
    private JButton createFunctionButton;
    private JButton createSpectrumButton;
    private JSpinner frequencySpinner;
    private JMenuItem exit;
    private JMenuItem aboutProgramm;

    public Window() throws NullPointerException, IOException {
        this.setTitle("ТИПИС2021 | Задача 1 | Хныкин Д.Е. | Группа 5.2");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        //Create menuBar
        JMenuBar nb = new JMenuBar();

        JMenu file = new JMenu("Файл");
        nb.add(file);
        exit = new JMenuItem("Выход");
        file.add(exit);
        aboutProgramm = new JMenuItem("О программе");
        nb.add(aboutProgramm);

        this.setJMenuBar(nb);
        //Create menuBar

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        aboutProgramm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutProgramm aboutProgramm = new AboutProgramm();
                aboutProgramm.main();
            }
        });


        createFunctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfreeChartPanel.removeAll();
                HarmonicSignalGraph harmonicSignalGraph = new HarmonicSignalGraph();
                jfreeChartPanel
                        .add(harmonicSignalGraph.drawGraph(getFrequencySpinner()));
                jfreeChartPanel.updateUI();
            }
        });

        createSpectrumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfreeChartPanel.removeAll();
                SignalSpectrum signalSpectrum = new SignalSpectrum();
                jfreeChartPanel
                        .add(signalSpectrum.drawSignalSpectrum(getFrequencySpinner()));
                jfreeChartPanel.updateUI();
            }
        });
    }

    public int getFrequencySpinner() {
        return (int) frequencySpinner.getValue();
    }

    private void createUIComponents() {
        jfreeChartPanel = new JPanel();
    }
}