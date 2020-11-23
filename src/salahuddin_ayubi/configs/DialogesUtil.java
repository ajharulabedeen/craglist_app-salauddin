
package salahuddin_ayubi.configs;

import javafx.scene.control.Alert;
public class DialogesUtil
    {

    public static void information(String information)
        {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText(information);
        alert.showAndWait();
        }
    public static void conformation(String conformation)
        {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText(conformation);
        alert.showAndWait();
        }
    public static void warning(String warning)
        {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        alert.setContentText(warning);
        alert.showAndWait();
        }
    public static void error(String error)
        {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
        }
    }
