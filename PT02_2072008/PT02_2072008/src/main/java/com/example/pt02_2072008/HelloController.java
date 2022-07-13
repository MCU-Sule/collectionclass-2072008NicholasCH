package com.example.pt02_2072008;

import com.example.pt02_2072008.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class HelloController {
    @FXML
    private TableView <Student> tableStudent;
    @FXML
    private TableColumn <Integer, Student> col1;
    @FXML
    private TableColumn <String, Student> col2;
    @FXML
    private TextField addNrp;
    @FXML
    private TextField nama;
    @FXML
    private TextField delNrp;

    public ObservableList <Student> sList;

    public void reset(){
        addNrp.clear();
        nama.clear();
        delNrp.clear();
    }

    public void initialize(){
        sList = FXCollections.observableArrayList(
                new Student(1, "Axel"),
                new Student(2, "Shira"),
                new Student(3, "Sapata"),
                new Student(4, "Negara"),
                new Student(5, "Nicholas")
        );
        tableStudent.setItems(sList);
        col1.setText("NRP");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setText("Nama");
        col2.setCellValueFactory(new PropertyValueFactory<>("nama"));
    }
    @FXML
    protected void addStudent() {
        int nrp = Integer.parseInt(addNrp.getText());
        String sName = nama.getText();
        sList.add(new Student(nrp, sName));
        addNrp.setText("");
        nama.setText("");
        reset();
    }
    @FXML
    protected void delStudent() {
        int nrp = Integer.parseInt(delNrp.getText());
        for (Student st: sList) {
            if (nrp == st.getId()) {
                sList.remove(st);
                return;
            }
        }
        reset();
    }

}