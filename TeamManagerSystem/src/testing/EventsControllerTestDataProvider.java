package testing;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class EventsControllerTestDataProvider {
	
	public static Stream<Arguments> createTeamEventStringProvider() {
		return Stream.of(
						Arguments.of("Chelcea vs Mancity", "London", "2021-12-5"),
						Arguments.of("Spurs vs Arsenal", "Wellington", "2022-01-7")
				);
	}
	
	public static Collection createTeamsDataProvider() {
		return Arrays.asList(new Object[][] {
			{"Chelcea vs Mancity", "London", "2021-12-5"}, 
			{"Spurs vs Arsenal", "Wellington", "2022-01-7"}}
		);
	}
	
	
	
}
