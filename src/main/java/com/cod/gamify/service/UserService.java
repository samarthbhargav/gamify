package com.cod.gamify.service;

import java.util.List;

import com.cod.gamify.common.except.InvalidArgumentException;
import com.cod.gamify.common.except.InvalidConfigException;
import com.cod.gamify.entity.LeaderBoard;
import com.cod.gamify.entity.User;
import com.cod.gamify.mongo.dao.UserDAO;

/**
 * Provides services for the User Class
 * 
 * @author Samarth Bhargav
 * 
 */
public class UserService {

	private LevelManager levelManager;
	private UserDAO userDAO;

	public UserService() throws InvalidConfigException {
		levelManager = new LevelManager();
		userDAO = new UserDAO();
	}

	/**
	 * Adds a new User
	 * 
	 * @param id
	 */
	public void addNewUser(String id) {
		User user = new User();
		user.setId(id);
		user.setPoints(0);
		userDAO.insert(user);
	}

	/**
	 * 
	 * Fetches a Existing user
	 * 
	 * @param id
	 * @return
	 * @throws InvalidArgumentException
	 */
	public User getUser(String id) throws InvalidArgumentException {
		User user = this.userDAO.fetchUser(id);
		user.setLevel(this.levelManager.getLevelForPoints(user.getPoints()));
		return user;
	}

	public void removeUser(String id) {
		this.userDAO.remove(User.class, id);
	}

	/**
	 * Returns a Leaderboard Object - with users sorted in descending order of
	 * their points
	 * 
	 * @return
	 * @throws InvalidArgumentException
	 */
	public LeaderBoard getLeaderBoard() throws InvalidArgumentException {
		List<User> users = this.userDAO.fetchUsersSortedBy("Points",
				UserDAO.SORT_ORDER_DESCENDING);
		for (User user : users) {
			user.setLevel(this.levelManager.getLevelForPoints(user.getPoints()));
		}
		LeaderBoard leaderBoard = new LeaderBoard();
		leaderBoard.setUsers(users);
		return leaderBoard;
	}

}
