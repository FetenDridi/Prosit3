module org.example.magasinjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.magasinjava to javafx.fxml;
    exports org.example.magasinjava;
}