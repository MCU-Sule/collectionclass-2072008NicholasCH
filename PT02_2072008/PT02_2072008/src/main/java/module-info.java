module com.example.pt02_2072008 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pt02_2072008 to javafx.fxml;
    exports com.example.pt02_2072008;

    opens com.example.pt02_2072008.model to javafx.fxml;
    exports com.example.pt02_2072008.model;
}