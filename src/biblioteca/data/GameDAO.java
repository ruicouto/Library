/*
 * GameDAO
 * ruicouto in 26/out/2016
 */
package biblioteca.data;

import biblioteca.business.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) to perform the game data persistency.
 * The data is currently being saved as a file object.
 * 
 * @author ruicouto
 */
public class GameDAO {
    
    /**
     * Get all games information.
     * @return The list of games
     */
    public static List<Game> getAll() {
        try {
            FileInputStream fis = new FileInputStream(new File("games.dat"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<Game>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    /**
     * Persist a list of games.
     * @param games The list of games to save
     */
    public static void saveAll(List<Game> games) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("games.dat"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(games);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
