/*
 * NewGameController
 * ruicouto in 27/out/2016
 */
package biblioteca.presentation;

import biblioteca.business.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * New game controller class
 *
 * @author ruicouto
 */
public class NewGameController implements Initializable {
    
    /** Parent controller. Reference needed add games */
    private FXMLMainController parent;
    
    @FXML
    private TextField txtTitle;
    @FXML
    private Slider progEval;
    @FXML
    private CheckBox checkFinished;
    @FXML
    private Button btnCreate;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Game g = new Game(txtTitle.getText(), checkFinished.isSelected(), (int)progEval.getValue());
                parent.addGame(g);
                //close the window
                ((Stage)btnCreate.getScene().getWindow()).close();
            }
        });
    }

    /**
     * Define the parent window
     * @param parent The parent controller
     */
    void setParent(FXMLMainController parent) {
        this.parent = parent;
    }
    
}
