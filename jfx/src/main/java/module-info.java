module com.jfxapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jfxapp to javafx.fxml;
    exports com.jfxapp;
}
