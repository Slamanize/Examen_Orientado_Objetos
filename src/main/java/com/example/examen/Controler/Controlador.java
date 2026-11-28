package com.example.examen.Controler;

import com.example.examen.Model.*;
import com.example.examen.Repository.RepositorioCliente;
import com.example.examen.Repository.RepositorioEquipoGaming;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtMarca;
    @FXML private TextField txtModelo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtHorasUso;
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
    @FXML private TableColumn<EquipoGaming, Integer> colAnio;
    @FXML private TableColumn<EquipoGaming, Integer> colHorasUso;
    @FXML private TableColumn<EquipoGaming, String> colNombre;
    @FXML private TableColumn<EquipoGaming, Integer> colTelefono;
    @FXML private TableColumn<EquipoGaming, String> colRut;

    public void initialize() throws SQLException {
        cmbTipo.getItems().setAll("PcGamer","Consola","SimuladorRacing");
        cmbTipo.valueProperty().addListener((obs,anterior,actual)->tiposActivos());
        cmbTipoVolante.getItems().setAll("Estandar", "Profesional");
        cmbEstado.getItems().setAll("Disponible", "Reservado", "En Uso", "Mantenimiento");

        colId.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getUid()));
        colTipo.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getTipo()));
        colMarca.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getMarca()));
        colModelo.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getModelo()));
        colAnio.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getAnioAdquisicion()));
        colHorasUso.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getHorasUso()));
        colNombre.setCellValueFactory(c-> new SimpleObjectProperty<>());//Falta code aqui, los tipo de datos son de otro tipo de modelo
        colTelefono.setCellValueFactory(c-> new SimpleObjectProperty<>());
        colRut.setCellValueFactory(c-> new SimpleObjectProperty<>());

        tblDatos.setPlaceholder(new Label("No hay Dispositivos registrados"));

        limpiar();
        mostrarTab();
    }


    private final RepositorioCliente repoCliente = new RepositorioCliente();
    private final RepositorioEquipoGaming repoEquipoGaming = new RepositorioEquipoGaming();
    private final ObservableList<EquipoGaming> listaEquipos = FXCollections.observableArrayList();

    @FXML
    public void agregar() {
        try {
            String rut = txtRut.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            int telefono = Integer.parseInt(txtTelefono.getText().trim());

            String tipo = cmbTipo.getValue();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            int horas = Integer.parseInt(txtHorasUso.getText().trim());

            if (tipo == null || rut.length() < 3 || nombre.isEmpty() || apellido.isEmpty()
                    || marca.isEmpty() || modelo.isEmpty()) {
                lblMensaje.setText("Completa todos los campos obligatorios.");
                lblMensaje.setStyle("-fx-text-fill: #b71c1c;");
                return;
            }

            EquipoGaming equipo;
            if (tipo.equals("PcGamer")) {
                int ram = Integer.parseInt(txtRam.getText().trim());
                equipo = new PCGamer(marca, modelo, anio, horas,"", ram, chkTieneGPU.isSelected());
            } else if (tipo.equals("Consola")) {
                int gen = Integer.parseInt(txtGen.getText().trim());
                int almacenamiento = Integer.parseInt(txtAlmacenamiento.getText().trim());
                equipo = new Consola(marca, modelo, anio, horas,"", gen, almacenamiento);
            } else {
                boolean conVolante = "Con volante".equals(cmbTipoVolante.getValue());
                int pedales = Integer.parseInt(txtCantPedales.getText().trim());
                equipo = new SimuladorRacing(marca, modelo, anio, horas,"", conVolante, pedales);
            }

            Cliente cliente = new Cliente(rut, apellido, nombre, telefono, new ArrayList<>());

            // El cliente primero, porque el equipo depende de él por la llave foránea
            repoCliente.insertar(cliente);
            boolean ok = repoEquipoGaming.insertar(equipo, rut);

            if (ok) {
                listaEquipos.add(equipo);
                limpiar();
                lblMensaje.setText("Equipo agregado correctamente.");
                lblMensaje.setStyle("-fx-text-fill: #1b5e20;");
                mostrarTab();
            } else {
                lblMensaje.setText("No se pudo guardar en la base de datos.");
                lblMensaje.setStyle("-fx-text-fill: #b71c1c;");
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("Revisa que los campos numéricos tengan solo números.");
            lblMensaje.setStyle("-fx-text-fill: #b71c1c;");
        } catch (Exception e) {
            e.printStackTrace();
            lblMensaje.setText("Ocurrió un error al agregar: "+e.getMessage());
            lblMensaje.setStyle("-fx-text-fill: #b71c1c;");
        }
    }
    // Metodos
    public void tiposActivos(){
        boolean esTipoC = "Consola".equals(cmbTipo.getValue());
        boolean esTipoP = "PcGamer".equals(cmbTipo.getValue());
        boolean esTipoS = "SimuladorRacing".equals(cmbTipo.getValue());
        txtGen.setDisable(!esTipoC);
        txtAlmacenamiento.setDisable(!esTipoC);
        txtCantPedales.setDisable(!esTipoS);
        cmbTipoVolante.setDisable(!esTipoS);
        txtRam.setDisable(!esTipoP);
        chkTieneGPU.setDisable(!esTipoP);
    }

    public void mostrarTab(){
        try{
            tblDatos.setItems(FXCollections.observableArrayList(repoEquipoGaming.cargar()));
        }catch(SQLException e){
            tblDatos.getItems().clear();
            lblMensaje.setText("Error al leer informacion: "+e.getMessage());
        }
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
        txtHorasUso.clear();
        txtRam.clear();
        chkTieneGPU.setSelected(false);
        txtGen.clear();
        txtAlmacenamiento.clear();
        cmbTipoVolante.getSelectionModel().clearSelection();
        txtCantPedales.clear();
        cmbEstado.getSelectionModel().clearSelection();
        lblMensaje.setText("El formulario se a limpiado correctamente.");
        lblMensaje.setStyle("-fx-text-fill: #1b5e20;");

    }
}
