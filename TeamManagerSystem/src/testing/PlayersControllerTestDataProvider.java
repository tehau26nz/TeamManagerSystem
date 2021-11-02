package testing;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class PlayersControllerTestDataProvider {
	
	public static Stream<Arguments>createPlayerDataProvider(){
		return Stream.of(
					Arguments.of("Ferren Torres",184,"Spain","M,F"),
					Arguments.of("Ilkay Gündogan",180,"Germany","M")
				);
	}

}
