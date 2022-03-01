module com.example.pokemon {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires javafx.graphics;


    opens com.example.pokemon to javafx.fxml;
    exports com.example.pokemon;
}