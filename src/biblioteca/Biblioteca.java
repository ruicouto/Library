/*
 * Biblioteca
 * ruicouto in 26/out/2016
 */
package biblioteca;

import biblioteca.presentation.FXMLMainController;
import biblioteca.business.GLibrary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class to the library
 * @author ruicouto
 */
public class Biblioteca extends Application {
    
    /**
     * Called when the application is loaded
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        GLibrary l = new GLibrary();
        
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("presentation/FXMLMain.fxml"));
        Parent root = (Parent) loader.load();
        FXMLMainController controller = 
                loader.<FXMLMainController>getController();
        controller.setLibrary(l);
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
