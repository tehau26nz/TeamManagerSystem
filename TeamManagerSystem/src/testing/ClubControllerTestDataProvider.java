package testing;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ClubControllerTestDataProvider {
	
	public static Stream<Arguments> createClubStatsProvider() {
		return Stream.of(
				Arguments.of(7,"Wolverhampton Wanderers",5,1,4,16),
				Arguments.of(8,"Everton",4,2,4,14)
		);
	}
	
//	public static Collection createClubStatsDataProvider() {
//		return Arrays.asList(new Object[][] {
//			{9,"West Ham United",6,2,2,20}
//			{10,"Newcastle United",0,4,6,4}
//		);
//	}

}
