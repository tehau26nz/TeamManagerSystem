package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import models.PieChartEntry;

public class ClubControllerTestDataProvider {
	
	public static Stream<Arguments> createClubStatsProvider() {
		return Stream.of(
				Arguments.of(7,"Wolverhampton Wanderers",5,1,4,16),
				Arguments.of(8,"Everton",4,2,4,14)
		);
	}
	
	public static Stream<Arguments> createClubPieChartProvider() {
		ArrayList<PieChartEntry> data1 = new ArrayList<>();
		data1.add(new PieChartEntry("Won 70%", 70.0));
		data1.add(new PieChartEntry("Drawn 15%", 15.0));
		data1.add(new PieChartEntry("Lost 15%", 15.0));
		
		ArrayList<PieChartEntry> data2 = new ArrayList<>();
		data2.add(new PieChartEntry("Won 30%", 30.0));
		data2.add(new PieChartEntry("Drawn 40%", 40.0));
		data2.add(new PieChartEntry("Lost 30%", 30.0));
		
		return Stream.of(
				Arguments.of(data1),
				Arguments.of(data2)
		);
	}
	
	public static Collection createClubStatsDataProvider() {
		return Arrays.asList(new Object[][] {
			{9,"West Ham United",6,2,2,20},
			{10,"Newcastle United",0,4,6,4}
			}
		);
	}
	

}
