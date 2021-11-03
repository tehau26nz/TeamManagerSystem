package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import application.TeamsController;

class TeamsControllerTesting {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		TeamsController teamsController = new TeamsController();
	}
	
	
}
