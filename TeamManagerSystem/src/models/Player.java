package models;

/**
 * This is the model of the player. 
 * It holds the properties of  player name, height, birthplace and positions. 
 * The player class provides methods to get the concatenated text of all positions for a player. 
 * @author Selina Yu
 * @since 2021-11-06
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

	private String name;
	private int height;
	private String birthplace;
	private String allPositions;
	private List<String> playerPositions;
    /**
     * Construct a player object with name,height,birth place and array of positions
     * @param name player name
     * @param height player height
     * @param birthplace player birth place
     * @param positions array of positions
     */
	public Player(String name, int height, String birthplace, String[] positions) {
		super();
		this.name = name;
		this.height = height;
		this.birthplace = birthplace;
		playerPositions = new ArrayList<>(Arrays.asList(positions));
		this.setAllPositions();
	}
	/**
	 * Construct a player object with name,height,birth place and string positions
	 * @param name player name
	 * @param height player height
	 * @param birthplace birth place
	 * @param allpositions string positions
	 */
	public Player(String name, int height, String birthplace, String allpositions) {
		super();
		this.name = name;
		this.height = height;
		this.birthplace = birthplace;
		this.allPositions = allpositions;
	}

	/**
	 * Method to get player name
	 * @return player name
	 */
	public String getName() {
		return name;
	}
    /**
     * Method to set player name
     * @param name player name
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * Method to get player height
     * @return player height
     */
	public int getHeight() {
		return height;
	}
	/**
	 * Method to set player height
	 * @param height player height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * Method to get birth place
	 * @return player birth place
	 */
	public String getBirthplace() {
		return birthplace;
	}
	/**
	 * method to set birth place
	 * @param birthplace player birth place
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	/**
	 * method to get player positions
	 * @return list of player positions
	 */
	public List<String> getPlayerPositions() {
		return playerPositions;
	}
	/**
	 * method to set a list of player positions
	 * @param playerPositions
	 */
	public void setPlayerPositions(List<String> playerPositions) {
		this.playerPositions = playerPositions;
	}
	/**
	 * method to add a position to the list of player positions
	 * @param position
	 */
	public void addPosition(String p) {
		playerPositions.add(p);
	}
    /**
     * method to get player positions in a concatenated text
     * @return all positions
     */
	public String getAllPositions() {
		return allPositions;
	}
    /**
     * this method returns a concatenated text of all positions for the player 
     */
	public void setAllPositions() {
		this.allPositions =  String.join(",", playerPositions);
	}

}
