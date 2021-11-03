package testing;

import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ClubControllerTestPieChartProvider {
	public static Stream<Arguments> createClubPieChartProvider() {
		HashMap<String, Integer>data1 = new HashMap<>();
		HashMap<String, Integer>data2 = new HashMap<>();
		data1.put("Won 70%", 70);
		data1.put("Drawn 15%", 15);
		data1.put("Lost 15%", 15);
		data2.put("Won 30%", 30);
		data2.put("Drawn 40%", 40);
		data2.put("Lost 30%", 30);
		return Stream.of(
				Arguments.of(data1),
				Arguments.of(data2)
		);
	}
}
