package com.cod.gamify.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cod.gamify.common.except.InvalidArgumentException;
import com.cod.gamify.common.except.InvalidConfigException;
import com.cod.gamify.common.except.MongoException;
import com.cod.gamify.entity.LeaderBoard;
import com.cod.gamify.entity.User;

/**
 * @author Samarth Bhargav
 * 
 */
public class UserServiceTest {

	private static UserService service;

	@BeforeClass
	public static void setUpBeforeClass() throws InvalidConfigException,
			MongoException {
		service = new UserService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws InvalidConfigException {
		removeUsers();
	}

	private static void addUsers() throws MongoException {
		service.addNewUser("Samarth");
		service.addNewUser("Risabh");
		service.addNewUser("Karthik");

	}

	private static void removeUsers() {
		service.removeUser("Samarth");
		service.removeUser("Risabh");
		service.removeUser("Karthik");
	}

	@Test
	public void testPoints() throws InvalidArgumentException, MongoException {
		addUsers();
		service.addPointsToUser("Samarth", 100);
		service.addPointsToUser("Risabh", 20);
		User user = service.getUser("Samarth");
		Assert.assertTrue(user.getPoints() == 100);
		user = service.getUser("Risabh");
		Assert.assertTrue(user.getPoints() == 20);
		service.addPointsToUser("Samarth", -10);
		user = service.getUser("Samarth");
		Assert.assertTrue(user.getPoints() == 90);
		removeUsers();
	}

	@Test
	public void testGetUser() throws MongoException, InvalidArgumentException {
		addUsers();
		User samarth = service.getUser("Samarth");
		Assert.assertTrue(samarth.getId().equals("Samarth"));
		removeUsers();
	}

	@Test
	public void testLeaderBoard() throws InvalidArgumentException,
			MongoException {
		addUsers();
		service.addPointsToUser("Samarth", 100);
		service.addPointsToUser("Risabh", 20);
		LeaderBoard leaderBoard = service.getLeaderBoard();
		Assert.assertTrue(leaderBoard.getUsers().get(0).getId()
				.equals("Samarth"));
		Assert.assertTrue(leaderBoard.getUsers().get(1).getId()
				.equals("Risabh"));
		removeUsers();
	}
}
