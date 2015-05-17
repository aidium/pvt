package org.craftedsw.tripservicekata.trip;

import static org.craftedsw.tripservicekata.trip.TripServiceTest.UserBuilder.aUser;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(value = MockitoJUnitRunner.class)
public class TripServiceTest {

	private static final User NOT_LOGGED_IN_USER = null;
	private static final User LOGGED_IN_USER = aUser().build();

	@Mock
	private TripDAO tripDAO;
	@Mock
	private UserSession session;
	@InjectMocks
	private TripService service = new TripService();

	@Test(expected = UserNotLoggedInException.class)
	public void shouldThrowWhenNotLoggedIn() throws Exception {
		given(session.getLoggedUser()).willReturn(NOT_LOGGED_IN_USER);
		service.getTripsByUser(aUser().build());
	}

	@Test
	public void shouldNotReturnAnyTripsIfNotFriendWithUser() throws Exception {
		given(session.getLoggedUser()).willReturn(LOGGED_IN_USER);

		User user = aUser().withTrips(new Trip()).withFriends(aUser().build()).build();

		List<Trip> tripsByUser = service.getTripsByUser(user);

		assertThat(tripsByUser.isEmpty(), is(true));
	}

	@Test
	public void shouldReturnTripsIfFriendWithUser() throws Exception {
		given(session.getLoggedUser()).willReturn(LOGGED_IN_USER);

		User user = aUser().withTrips(new Trip()).withFriends(aUser().build(), LOGGED_IN_USER).build();

		given(tripDAO.tripsByUser(user)).willReturn(user.trips());

		List<Trip> tripsByUser = service.getTripsByUser(user);

		assertThat(tripsByUser.isEmpty(), is(false));
	}

	public static class UserBuilder {
		private Trip[] trips = new Trip[0];
		private User[] friends = new User[0];

		public static UserBuilder aUser() {
			return new UserBuilder();
		}

		public UserBuilder withTrips(Trip... trips) {
			this.trips = trips;
			return this;
		}

		public UserBuilder withFriends(User... friends) {
			this.friends = friends;
			return this;
		}

		public User build() {
			User user = new User();
			for (User friend : friends) {
				user.addFriend(friend);
			}
			for (Trip trip : trips) {
				user.addTrip(trip);
			}
			return user;
		}
	}

}