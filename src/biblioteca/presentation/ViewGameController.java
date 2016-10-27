/*
 * ViewGameController
 * ruicouto in 27/out/2016
 */
package biblioteca.presentation;

import biblioteca.business.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * View Game controller
 *
 * @author ruicouto
 */
public class ViewGameController implements Initializable {

    @FXML
    private Label lblEval;
    @FXML
    private Label lblTitle;
    @FXML
    private CheckBox checkFinished;
            
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //nothing to do
    }   
    
    /**
     * Define the game to show. Initializes the view
     * @param g Game to show
     */
    public void setGame(Game g) {
        lblEval.setText("Evaluation: " + String.valueOf(g.getRating()) + " stars");
        lblTitle.setText(g.getTitle());
        checkFinished.setSelected(g.isFinished());
    }
    
}
