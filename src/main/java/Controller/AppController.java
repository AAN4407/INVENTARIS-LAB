package Controller;

import Model.DataModel;
import View.AlertHelper;
import View.InputValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @Aira Althafeliq Nurfirly
 */
public class AppController {

    @FXML private TextField field1;
    @FXML private TextField field2;

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button clearButton;

    @FXML private TableView<DataModel> dataTable;
    @FXML private TableColumn<DataModel, String> NamaBarang;
    @FXML private TableColumn<DataModel, String> Jumlah;

    @FXML private Label statusLabel;

    private ObservableList<DataModel> dataList;

    @FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();

        NamaBarang.setCellValueFactory(new PropertyValueFactory<>("field1"));
        Jumlah.setCellValueFactory(new PropertyValueFactory<>("field2"));

        dataTable.setItems(dataList);

        dataTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    fillFormWithSelectedData(newValue);
                }
            }
        );

        addSampleData();

        updateStatus("Application ready. Total records: " + dataList.size());
    }

    @FXML
    private void handleAdd() {
        try {
            if (!validateInputs()) {
                return;
            }

            String value1 = field1.getText();
            String value2 = field2.getText();
            String value3 = value1 + " - " + value2;

            DataModel newData = new DataModel(value1, value2, value3);
            dataList.add(newData);

            clearForm();

            updateStatus("Data added successfully! Total records: " + dataList.size());
            AlertHelper.showInfo("Success", "Data has been added successfully!");

        } catch (Exception e) {
            AlertHelper.showError("Error", "An error occurred: " + e.getMessage());
            updateStatus("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleUpdate() {
        DataModel selectedData = dataTable.getSelectionModel().getSelectedItem();

        if (selectedData == null) {
            AlertHelper.showWarning("No Selection", "Please select a record to update!");
            updateStatus("Error: No record selected");
            return;
        }

        try {
            if (!validateInputs()) {
                return;
            }

            String value1 = field1.getText();
            String value2 = field2.getText();
            String value3 = value1 + " - " + value2;

            selectedData.setField1(value1);
            selectedData.setField2(value2);
            selectedData.setField3(value3);

            dataTable.refresh();

            clearForm();

            updateStatus("Data updated successfully!");
            AlertHelper.showInfo("Success", "Data has been updated successfully!");

        } catch (Exception e) {
            AlertHelper.showError("Error", "An error occurred: " + e.getMessage());
            updateStatus("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleDelete() {
        DataModel selectedData = dataTable.getSelectionModel().getSelectedItem();

        if (selectedData == null) {
            AlertHelper.showWarning("No Selection", "Please select a record to delete!");
            updateStatus("Error: No record selected");
            return;
        }

        boolean confirmed = AlertHelper.showConfirmation(
            "Confirm Delete",
            "Are you sure you want to delete this record?"
        );

        if (confirmed) {
            dataList.remove(selectedData);
            clearForm();
            updateStatus("Data deleted successfully! Total records: " + dataList.size());
            AlertHelper.showInfo("Success", "Data has been deleted successfully!");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
        updateStatus("Form cleared");
    }

    private void fillFormWithSelectedData(DataModel data) {
        field1.setText(data.getField1());
        field2.setText(data.getField2());
        updateStatus("Record selected: " + data.getField1());
    }

    private void clearForm() {
        field1.clear();
        field2.clear();
        dataTable.getSelectionModel().clearSelection();
    }

    private boolean validateInputs() {
        if (InputValidator.isEmpty(field1.getText())) {
            AlertHelper.showWarning("Incomplete Input", "Please enter Field 1!");
            InputValidator.highlightError(field1);
            return false;
        }

        if (InputValidator.isEmpty(field2.getText())) {
            AlertHelper.showWarning("Incomplete Input", "Please enter Field 2!");
            InputValidator.highlightError(field2);
            return false;
        }

        InputValidator.clearHighlight(field1);
        InputValidator.clearHighlight(field2);

        return true;
    }

    private void updateStatus(String message) {
        statusLabel.setText("Status: " + message);
    }

    private void addSampleData() {
        dataList.add(new DataModel("Arduino UNO", "3", "arduino UNO - 3"));
        dataList.add(new DataModel("Resistor 220k", "50", "Resistor 220k - 50"));
        dataList.add(new DataModel("Kabel M to M", "60", "Kabel M to M - 60"));
    }
}
