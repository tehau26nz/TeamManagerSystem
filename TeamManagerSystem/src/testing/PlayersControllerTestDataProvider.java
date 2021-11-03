package testing;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import models.Player;

public class PlayersControllerTestDataProvider {
	
	public static Stream<Arguments>createPlayerDataProvider(){
		return Stream.of(
					Arguments.of("Ferren Torres",184,"Spain","M,F"),
					Arguments.of("Ilkay Gündogan",180,"Germany","M")
				);
	}
	
	public static Stream<Arguments>addPlayerDataProvider(){
		return Stream.of(
					Arguments.of("Declan Rice",185,"England","DM")
				);
	}
	
//	public static Collection addPlayerCollectionDataProvider() {
//		return Arrays.asList(new Object[][] {
//			{new Player("Ferren Torres",184,"Spain","M,F")}, 
//			{new Player("Ilkay Gündogan",180,"Germany","M")}
//			});
//	}

}
