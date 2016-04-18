package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import modelo.InterrogaModelo;
import controlador.Controlador;

public class ImplementacionVistaAWT implements InterrogaVista, InformaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private TextField jtfNombre;
    private Label jlContador;

    public ImplementacionVistaAWT() {
    	super();
    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void creaGUI() {
        Frame ventana = new Frame("Modelo/Vista/Controlador");
        Panel jpEntrada = new Panel();
        Panel jpContador = new Panel();
        jtfNombre = new TextField(20);
        Escuchador escuchador = new Escuchador();
        Button jbNuevo = new Button("Nuevo");
        jbNuevo.addActionListener(escuchador);
        Button jbAtras = new Button("Atras");
        jbAtras.addActionListener(escuchador);
        Button jbAdelante = new Button("Adelante");
        jbAdelante.addActionListener(escuchador);
        jlContador = new Label(infoEstadoEntradas());
        jpEntrada.add(jtfNombre);
        jpEntrada.add(jbNuevo);
        jpEntrada.add(jbAtras);
        jpEntrada.add(jbAdelante);
        jpContador.add(jlContador);
        ventana.add(jpEntrada, BorderLayout.NORTH);
        ventana.add(jpContador, BorderLayout.SOUTH);
        ventana.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
		});
        ventana.pack();
        ventana.setVisible(true);
    }

    public void cambiaNombre(String nombre) {
        jtfNombre.setText(nombre);
    }

    class Escuchador implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Nuevo"))
                controlador.anyadeEntrada();
            else if(texto.equals("Atras"))
                controlador.atras();
            else if(texto.equals("Adelante"))
                controlador.adelante();
        }
    }

    @Override
    public String getEntrada() {
        return jtfNombre.getText();
    }

    private String infoEstadoEntradas() {
        return "Numero de entradas: " +
                modelo.getPoscionEntradaActual() + " de " +
                modelo.getNumeroEntradas();
    }

	@Override
	public void entradaActualCambiada() {
        jtfNombre.setText(modelo.getEntradaActual());
        jlContador.setText(infoEstadoEntradas());
	}

	@Override
	public void nuevaEntrada() {
        jlContador.setText(infoEstadoEntradas());
	}
}
