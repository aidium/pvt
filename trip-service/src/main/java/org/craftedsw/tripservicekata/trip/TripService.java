package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	private TripDAO tripDAO = new TripDAO();
	private UserSession session = UserSession.getInstance();

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		validateHasLoggedInUser();
		return user.isFriendWith(session.getLoggedUser()) ? tripDAO.tripsByUser(user) : new ArrayList<Trip>();
	}

	private void validateHasLoggedInUser() {
		if (session.getLoggedUser() == null) {
			throw new UserNotLoggedInException();
		}
	}
}
