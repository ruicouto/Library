/*
 * GLibrary
 * ruicouto in 26/out/2016
 */
package biblioteca.business;

import biblioteca.data.GameDAO;
import java.util.List;

/**
 * Class representing a games Library
 * @author ruicouto
 */
public class GLibrary {
    
    /** Games information, as a list */
    private List<Game> games;

    /**
     * Initialize the games library.
     * Load from persistency
     */
    public GLibrary() {
        games = GameDAO.getAll();
    }
    
    /**
     * Get the list of all games
     * @return The list of games
     */
    public List<Game> getGames() {
        return games;
    }
    
    /**
     * Add a new Game to the library.
     * When a game is added, the information is persisted.
     * @param g The game to add
     */
    public void addGame(Game g) {
        games.add(g);
        GameDAO.saveAll(games);
    }
    
    /**
     * Get a game, given a name
     * @param title Name of the game
     * @return Return the game if found, null otherwise
     */
    public Game getGame(String title) {
        try {
            return games.stream()
                    .filter(g -> g.getTitle().equals(title))
                    .findFirst().get();    
        } catch (Exception e) {
        }
        return null;   
    }
    
    /**
     * Remove a given game.
     * @param g The game to remove.
     */
    public void removeGame(Game g) {
        games.remove(g);
    }
}
