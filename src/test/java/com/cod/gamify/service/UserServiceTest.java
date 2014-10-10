/**
 * 
 */
package com.cod.gamify.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cod.gamify.common.except.InvalidArgumentException;
import com.cod.gamify.common.except.InvalidConfigException;
import com.cod.gamify.entity.LeaderBoard;
import com.cod.gamify.mongo.dao.UserDAO;

/**
 * @author Samarth Bhargav
 * 
 */
public class UserServiceTest {

	private static UserService service;

	@BeforeClass
	public static void setUpBeforeClass() throws InvalidConfigException {
		service = new UserService();
		service.addNewUser("Samarth");
		service.addNewUser("Risabh");
		service.addNewUser("Karthik");
	}

	@AfterClass
	public static void tearDownAfterClass() throws InvalidConfigException {
		service.removeUser("Samarth");
		service.removeUser("Risabh");
		service.removeUser("Karthik");
	}

	@Test
	public void testLeaderBoard() throws InvalidArgumentException {
		LeaderBoard leaderBoard = service.getLeaderBoard();
		System.out.println(leaderBoard);
	}
}
