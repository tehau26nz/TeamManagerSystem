package application;
import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private int height;
	private String birthplace;
	private List<String> playerPositions = new ArrayList<>();

	public Player(String name, int height, String birthplace, String[] positions) {
		super();
		this.name = name;
		this.height = height;
		this.birthplace = birthplace;
		for (String s : positions) {
			this.playerPositions.add(s);
		}
	}
	
	//Method to get player name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public List<String> getPlayerPositions() {
		return playerPositions;
	}

	public void setPlayerPositions(List<String> playerPositions) {
		this.playerPositions = playerPositions;
	}

	// Method
	public void addPosition(String p) {
		playerPositions.add(p);
	}
}
