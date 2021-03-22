package principal;

import javafx.application.Application;
import javafx.stage.Stage;
import vista.ImplementacionVista;
import controlador.ImplementacionControlador;
import modelo.ImplementacionModelo;
import vista.ImplementacionVistaJavaFX;

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ImplementacionControlador controlador = new ImplementacionControlador();
        ImplementacionModelo modelo = new ImplementacionModelo();
//        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionVistaJavaFX vista = new ImplementacionVistaJavaFX(stage);
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}