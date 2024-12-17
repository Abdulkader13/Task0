module com.example.task0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task0 to javafx.fxml;
    exports com.example.task0;
}