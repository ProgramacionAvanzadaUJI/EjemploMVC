package principal;

import vista.ImplementacionVista;
import controlador.ImplementacionControlador;
import modelo.ImplementacionModelo;

public class Principal {
    public static void main(String args[]) {
	ImplementacionControlador controlador = new ImplementacionControlador();
	ImplementacionVista vista = new ImplementacionVista();
	ImplementacionModelo modelo = new ImplementacionModelo();
	modelo.setVista(vista);
	controlador.setVista(vista);
	controlador.setModelo(modelo);
	vista.setModelo(modelo);
	vista.setControlador(controlador);
	vista.creaGUI();
    }
}