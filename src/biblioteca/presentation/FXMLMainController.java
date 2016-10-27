/*
 * FXMLMainController
 * ruicouto in 26/out/2016
 */
package biblioteca.presentation;

import biblioteca.business.GLibrary;
import biblioteca.business.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * Main window controller
 * @author ruicouto
 */
public class FXMLMainController implements Initializable {
    
    @FXML 
    private Button newGame;
    @FXML 
    private Button details;
    @FXML
    private ListView list;
    @FXML
    private WebView webView;
    @FXML
    private BarChart chart;
    
    /** Game library representation */
    private GLibrary library;
        
    /**
     * Called when the view is created
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Set the listener for new game button
        newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {                    
                    FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("NewGame.fxml"));
                    Parent root = (Parent) loader.load();
                    NewGameController controller = 
                            loader.<NewGameController>getController();
                    controller.setParent(FXMLMainController.this);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
               
            }
        });
        
        //Set the listener for list item click
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Get the selected game
                Game g = (Game) list.getSelectionModel().getSelectedItems().get(0);
                webView.getEngine().load("http://www.metacritic.com/search/all/"+g.getTitle()+"/results");

                
            }
        });
        
        //set the listener for the details button
        details.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("ViewGame.fxml"));
                    Parent root = (Parent) loader.load();
                    ViewGameController controller = 
                            loader.<ViewGameController>getController();
                    Game g = (Game) list.getSelectionModel().getSelectedItems().get(0);
                    controller.setGame(g);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }    

    /**
     * Set the internal information
     * @param l The games library to set
     */
    public void setLibrary(GLibrary l) {
        library = l;
        refresh();
    }
    
    /**
     * Update the view information
     */
    public void refresh() {
        //set the list data
        list.getItems().clear();
        for(Game g : library.getGames()) {
            list.getItems().add(g);
        }
        
        //set the chart data
        chart.getData().clear();
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Games");
        series1.getData().add(new XYChart.Data("Finished", library.getGames().stream().filter(Game::isFinished).count()));
        series1.getData().add(new XYChart.Data("Not finished", library.getGames().stream().filter(g -> !g.isFinished()).count()));
        chart.getData().add(series1);
    }
    
    /**
     * Add a new game ti the internal representaion
     * @param g The game to add
     */
    public void addGame(Game g) {
        library.addGame(g);
        refresh();
    }
    
}
