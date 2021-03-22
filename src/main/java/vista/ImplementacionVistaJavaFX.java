package vista;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.InterrogaModelo;

public class ImplementacionVistaJavaFX implements InterrogaVista, InformaVista{
    private final Stage stage;
    private Controlador controlador;
    private InterrogaModelo modelo;
    private TextField tfNombre;
    private Label lContador;

    public ImplementacionVistaJavaFX(final Stage stage) {
        this.stage = stage;
    }

    public void setModelo(final InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(final Controlador controlador) {
        this.controlador = controlador;
    }

    public void creaGUI() {
        tfNombre = new TextField();
        Button bNuevo = new Button("Nuevo");
        bNuevo.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controlador.anyadeEntrada();
            }
        });

        Button bAtras = new Button("Atrás");
        bAtras.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controlador.atras();
            }
        });

        Button bAdelante = new Button("Adelante");
        bAdelante.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controlador.adelante();
            }
        });
        
        HBox fpEntrada = new HBox(10, tfNombre, bNuevo, bAtras, bAdelante);
        lContador = new Label(infoEstadoEntradas());
        HBox fpContador = new HBox(10, lContador);
        fpContador.setAlignment(Pos.CENTER);

        VBox fpFinal = new VBox(fpEntrada, fpContador);
//        fpFinal.setAlignment(Pos.CENTER);

        Scene scene = new Scene(fpFinal);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void entradaActualCambiada() {
        tfNombre.setText(modelo.getEntradaActual());
        lContador.setText(infoEstadoEntradas());
    }

    @Override
    public void nuevaEntrada() {
        lContador.setText(infoEstadoEntradas());
    }

    @Override
    public String getEntrada() {
        return tfNombre.getText();
    }

    private String infoEstadoEntradas() {
        return "Numero de entradas: " +
                modelo.getPoscionEntradaActual() + " de " +
                modelo.getNumeroEntradas();
    }
}