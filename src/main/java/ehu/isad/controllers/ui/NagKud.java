package ehu.isad.controllers.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.controllers.db.ProbaDB;
import ehu.isad.model.Pertsona;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class NagKud {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Pertsona> ezTauId;

    @FXML
    private TableColumn<Pertsona, String> ezFNId;

    @FXML
    private TableColumn<Pertsona, String> ezLNId;

    @FXML
    private TableColumn<Pertsona, String> ezSportId;

    @FXML
    private TableColumn<Pertsona, Integer> ezYearsId;

    @FXML
    private TableColumn<Pertsona, Boolean> ezVegId;

    @FXML
    private TableColumn<Pertsona, Image> ezArgId;

    @FXML
    private TableView<Pertsona> eskTau;

    @FXML
    private TableColumn<Pertsona,String> eskFNId;

    @FXML
    private TableColumn<Pertsona,String> eskLNId;

    @FXML
    private TableColumn<Pertsona, String> eskSoprtId;

    @FXML
    private TableColumn<Pertsona, Integer> eskYearId;

    @FXML
    private TableColumn<Pertsona, Boolean> eskVegId;

    @FXML
    private TableColumn<Pertsona, String> eskArgId;

    @FXML
    private Button sartuId;

    @FXML
    private Button gordeId;

    @FXML
    private Button kenduId;

    private List<Pertsona> lista = new ArrayList<>();
    private List<Pertsona> eskLista = new ArrayList<>();
    private ObservableList<Pertsona> obsLista = FXCollections.observableArrayList();
    private ObservableList<Pertsona> eskObsLista = FXCollections.observableArrayList();
    private ProbaDB probaDB = ProbaDB.getInstance();

    @FXML
    void gordeClick(ActionEvent event) { //eskumako taulan dauden datuak db-an gorde
        probaDB.sartuDBn(eskLista);
    }

    @FXML
    void kenduClick(ActionEvent event) { //eskumako taulatik ezkerrera pasatu
        Pertsona p = eskTau.getSelectionModel().getSelectedItem();
        eskLista.remove(p);
        lista.add(p);

        obsLista.clear();
        obsLista.addAll(lista);

        eskObsLista.clear();
        eskObsLista.addAll(eskLista);

        kargatu(obsLista,eskObsLista);
    }

    @FXML
    void sartuClick(ActionEvent event) { //ezkerreko taulatik eskumara pasatu
        Pertsona p = ezTauId.getSelectionModel().getSelectedItem();
        lista.remove(p);
        eskLista.add(p);

        obsLista.clear();
        obsLista.addAll(lista);

        eskObsLista.clear();
        eskObsLista.addAll(eskLista);

        kargatu(obsLista,eskObsLista);

    }

    @FXML
    void initialize() throws SQLException {

        ezFNId.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        ezLNId.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ezSportId.setCellValueFactory(new PropertyValueFactory<>("sport"));
        ezYearsId.setCellValueFactory(new PropertyValueFactory<>("years"));
        ezVegId.setCellValueFactory(new PropertyValueFactory<>("vegetarian"));
        ezArgId.setCellValueFactory(new PropertyValueFactory<>("irudia"));

        eskFNId.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        eskLNId.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        eskSoprtId.setCellValueFactory(new PropertyValueFactory<>("sport"));
        eskYearId.setCellValueFactory(new PropertyValueFactory<>("years"));
        eskVegId.setCellValueFactory(new PropertyValueFactory<>("vegetarian"));
        eskArgId.setCellValueFactory(new PropertyValueFactory<>("irudia"));

        ezVegId.setCellFactory(column -> new CheckBoxTableCell<>());


        lista = probaDB.lortuPertsonak();
        obsLista.addAll(lista);
        kargatu(obsLista,eskObsLista);

    }

    private void kargatu(ObservableList<Pertsona> obsLista, ObservableList<Pertsona> eskObsLista) {
        ezTauId.setItems(obsLista);
        eskTau.setItems(eskObsLista);
    }
}
