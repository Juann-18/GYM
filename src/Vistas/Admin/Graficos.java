package Vistas.Admin;

import Modelo.Admin.Md_Graficos;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficos extends JFrame {
    public JButton jbVolver;
    public Estadisticas mp;
    public int tipo;
    private Md_Graficos modeloGraficos;

    public Graficos(Estadisticas mp, int tipo) {
        this.mp = mp;
        this.tipo = tipo;
        this.modeloGraficos = new Md_Graficos();
        configurarVentana();
        crearGUI();
    }

    private void configurarVentana() {
        setTitle(obtenerTituloGrafico());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
    }

    private String obtenerTituloGrafico() {
        switch (tipo) {
            case 1: return "Tipos de Documento";
            case 2: return "Top 5 Entrenadores";
            case 3: return "Distribución de Usuarios";
            case 4: return "Registros Mensuales";
            case 5: return "Clases por Hora";
            default: return "Gráfico";
        }
    }

    private void crearGUI() {
        switch (tipo) {
            case 1 -> verGraf1();
            case 2 -> verGraf2();
            case 3 -> verGraf3();
            case 4 -> verGraf4();
            case 5 -> verGraf5();
        }
        
        jbVolver = new JButton("Volver");
        jbVolver.setBounds(250, 320, 100, 25);
        jbVolver.addActionListener(e -> {
            this.dispose();
            mp.setVisible(true);
        });
        add(jbVolver);
    }
    
    private void verGraf1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Integer> datos = modeloGraficos.obtenerDistribucionDocumentos();

        datos.forEach(dataset::setValue);

        JFreeChart chart = ChartFactory.createPieChart(
            "Tipos de Documento de Usuarios", 
            dataset,
            true, true, false
        );

        // Personalización del gráfico
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Cédula (CC)", new Color(79, 129, 189));
        plot.setSectionPaint("Tarjeta (TI)", new Color(192, 80, 77));
        plot.setSectionPaint("Extranjería (CE)", new Color(155, 187, 89));
        plot.setSectionPaint("Pasaporte", new Color(128, 100, 162));
        plot.setBackgroundPaint(Color.WHITE);

        agregarChartPanel(chart);
    }
    

    private void verGraf2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> datos = modeloGraficos.obtenerTopEntrenadores(5);

        datos.forEach((nombre, total) -> 
            dataset.addValue(total, "Clases", nombre));

        crearGraficoBarras3D(dataset, 
            "Top 5 Entrenadores con más Clases", 
            "Entrenador", 
            "Cantidad de Clases");
    }

    private void verGraf3() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Integer> datos = modeloGraficos.obtenerDistribucionUsuarios();

        datos.forEach(dataset::setValue);

        JFreeChart chart = ChartFactory.createPieChart(
            "Distribución de Tipos de Usuario",
            dataset,
            true, true, false
        );

        personalizarGraficoPie(chart);
        agregarChartPanel(chart);
    }

    private void verGraf4() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> datos = modeloGraficos.obtenerRegistrosPorMes();

        datos.forEach((mes, total) -> 
            dataset.addValue(total, "Registros", mes));

        crearGraficoArea(dataset,
            "Registro de Usuarios por Mes",
            "Mes",
            "Cantidad");
    }

    private void verGraf5() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> datos = modeloGraficos.obtenerClasesPorHora();

        datos.forEach((hora, total) -> 
            dataset.addValue(total, "Clases", hora));

        crearGraficoBarras3D(dataset,
            "Clases por Hora del Día",
            "Hora",
            "Cantidad de Clases");
    }

    // Métodos auxiliares para creación de gráficos
    private void crearGraficoBarras3D(DefaultCategoryDataset dataset, 
                                    String titulo, String ejeX, String ejeY) {
        JFreeChart chart = ChartFactory.createBarChart3D(
            titulo, ejeX, ejeY, dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );
        chart.setBackgroundPaint(Color.WHITE);
        agregarChartPanel(chart);
    }

    private void crearGraficoArea(DefaultCategoryDataset dataset,
                                String titulo, String ejeX, String ejeY) {
        JFreeChart chart = ChartFactory.createAreaChart(
            titulo, ejeX, ejeY, dataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );
        agregarChartPanel(chart);
    }

    private void personalizarGraficoPie(JFreeChart chart) {
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Clientes", new Color(79, 129, 189));
        plot.setSectionPaint("Entrenadores", new Color(155, 187, 89));
        plot.setSectionPaint("Administradores", new Color(192, 80, 77));
        plot.setSectionPaint("Otros", new Color(241, 196, 15));
        plot.setBackgroundPaint(Color.WHITE);
    }

    private void agregarChartPanel(JFreeChart chart) {
        ChartPanel panel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(570, 310);
            }
        };
        panel.setBounds(10, 10, 570, 310);
        panel.setMouseWheelEnabled(true);
        add(panel);
        revalidate();
        repaint();
    }
}