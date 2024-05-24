module com.robot {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.robot to javafx.fxml;
    exports com.robot;
}
