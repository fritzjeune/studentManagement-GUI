module com.ayitigenius.studentmanagegui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ayitigenius.studentmanagegui to javafx.fxml;
    exports com.ayitigenius.studentmanagegui;
    exports com.ayitigenius.studentmanagegui.management;
    opens com.ayitigenius.studentmanagegui.management to javafx.fxml;
}