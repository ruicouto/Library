/*
 * Game
 * ruicouto in 26/out/2016
 */
package biblioteca.business;

import java.io.Serializable;

/**
 * Representation of a Game entry
 * @author ruicouto
 */
public class Game implements Serializable {
    /** Title of the game */
    private String title;
    /** Property defining if the game was finished */
    private boolean finished;
    /** Rating of the game */
    private int rating;

    /**
     * Empty constructor.
     */
    public Game() {
    }

    /**
     * Constructor
     * @param title Title of the game
     * @param finished Was the game finished
     * @param rating Rating of the game
     */
    public Game(String title, boolean finished, int rating) {
        this.title = title;
        this.finished = finished;
        this.rating = rating;
    }
    
    /**
     * Get the game title
     * @return Get the title as string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define the title of the game
     * @param title The game title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Check if the game was finished
     * @return true if finished, false otherwise
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Define the game as finished
     * @param finished true for finished, false otherwise
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * Get the game rating
     * @return The game rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Define the rating of the game
     * @param rating The rating value
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Get a textual representation of the object.
     * @return The game title
     */
    @Override
    public String toString() {
        return title;
    }
    
    
}
