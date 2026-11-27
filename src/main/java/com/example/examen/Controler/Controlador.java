package com.example.examen.Controler;

import com.example.examen.Model.EquipoGaming;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;

public class Controlador {

    @FXML private TextField txtRut;
    @FXML private TextField txtDv;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtMarca;
    @FXML private TextField txtModelo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtHorasuso;
    @FXML private TextField txtRam;
    @FXML private CheckBox chkTieneGPU;
    @FXML private TextField txtGen;
    @FXML private TextField txtAlmacenamiento;
    @FXML private ComboBox<String> cmbTipoVolante;
    @FXML private TextField txtCantPedales;
    @FXML private TextField txtIdUnico;
    @FXML private ComboBox<String> cmbEstado;
    @FXML private Button btnAgregar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;
    @FXML private Label lblMensaje;

    @FXML private TableView<EquipoGaming> tblDatos;
    @FXML private TableColumn<EquipoGaming,Integer> colId;
    @FXML private TableColumn<EquipoGaming, String> colTipo;
    @FXML private TableColumn<EquipoGaming, String> colMarca;
    @FXML private TableColumn<EquipoGaming, String> colModelo;
    @FXML private TableColumn<EquipoGaming, Date> colAnio;
    @FXML private TableColumn<EquipoGaming, Integer> colHoras;
    @FXML private TableColumn<EquipoGaming, String> colNombre;
    @FXML private TableColumn<EquipoGaming, Integer> colTelefono;
    @FXML private TableColumn<EquipoGaming, String> colRut;

    public void initialize(){
        cmbTipo.getItems().setAll("PcGamer","Consola","SimuladorRacing");


    }
    // Metodos
    public void tiposActivos(){
    }

    public void limpiar(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        cmbTipo.getSelectionModel().clearSelection();
        txtMarca.clear();
        txtModelo.clear();
        txtAnio.clear();
        txtHorasuso.clear();
        txtRam.clear();
        chkTieneGPU.setSelected(false);
        txtGen.clear();
        txtAlmacenamiento.clear();
        cmbTipoVolante.getSelectionModel().clearSelection();
        txtCantPedales.clear();
        cmbEstado.getSelectionModel().clearSelection();
        txtIdUnico.clear();
        lblMensaje.setText("El formulario se a limpiado correctamente.");
        lblMensaje.setStyle("-fx-text-fill: #1b5e20;");

    }
}
