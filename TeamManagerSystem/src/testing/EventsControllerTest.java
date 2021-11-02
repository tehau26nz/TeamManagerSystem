package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.EventsController;
import javafx.event.Event;
import models.TeamEvent;

class EventsControllerTest {

	private static EventsController eventsController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		eventsController = new EventsController();
	}

	@ParameterizedTest
	@MethodSource("testing.EventsControllerTestDataProvider#createTeamEventStringProvider")
	public void createTeamEventTest(String name, String location, String date) {
		TeamEvent teamEvent = eventsController.createTeamEvent(name, location, date);
		assertNotNull(teamEvent);
		assertEquals(teamEvent.getEventName(), name);
		assertEquals(teamEvent.getEventLocation(), location);
		assertEquals(teamEvent.getEventDate(), date);
	}

	@ParameterizedTest(name = "{index}: createTeamEventTest(0,1,2)")
	@MethodSource("testing.EventsControllerTestDataProvider#createTeamsDataProvider")
	public void createTeamEventTest1(String name, String location, String date) {
		TeamEvent teamEvent = eventsController.createTeamEvent(name, location, date);
		assertNotNull(teamEvent);
		assertEquals(teamEvent.getEventName(), name);
		assertEquals(teamEvent.getEventLocation(), location);
		assertEquals(teamEvent.getEventDate(), date);
	}

	@ParameterizedTest
	@MethodSource("testing.EventsControllerTestDataProvider#createTeamEventStringProvider")
	public void getEventByLocationTest(String name, String location, String date) {
		eventsController.createTeamEventAndAdd(name, location, date);
		TeamEvent teamEvent = eventsController.getEventByLocation(location);
		assertEquals(teamEvent.getEventLocation(), location);

	}

}
