package com.example.examen.Controler;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.awt.*;

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
    @FXML private TableView<?> tblDatos;
    @FXML private Label lblMensaje;
}
