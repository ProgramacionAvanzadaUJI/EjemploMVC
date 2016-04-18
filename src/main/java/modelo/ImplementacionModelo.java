package modelo;
import java.util.ArrayList;

import vista.InformaVista;


public class ImplementacionModelo implements CambioModelo, InterrogaModelo {
	private ArrayList<String> entradas = new ArrayList<String>();
	private int posicionActual = 0;
	private InformaVista vista;

	public ImplementacionModelo(){}
	
	public void setVista(InformaVista vista) {
		this.vista = vista;
	}

	@Override
	public void anyadeEntrada(String entrada) {
		entradas.add(entrada);
		posicionActual++;
		vista.nuevaEntrada();
	}

	@Override
	public void incrementaPosicionActual() {
		if(posicionActual+1 <= entradas.size()) {
			posicionActual++;
			vista.entradaActualCambiada();
		}
	}

	@Override
	public void decrementaPosicionActual() {
		if(posicionActual > 1) {
			posicionActual--;
			vista.entradaActualCambiada();
		}
	}

	@Override
	public int getNumeroEntradas() {
		return entradas.size();
	}

	@Override
	public String getEntradaActual() {
		return (String)entradas.get(posicionActual-1);
	}

	@Override
	public int getPoscionEntradaActual() {
		return posicionActual;
	}
}