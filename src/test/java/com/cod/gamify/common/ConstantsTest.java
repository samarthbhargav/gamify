/**
 * 
 */
package com.cod.gamify.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Samarth Bhargav
 * 
 */
public class ConstantsTest {

	@Test
	public void checkMongoParams() {
		assertNotNull(ConfigManager.getString(Constants.MONGO.HOST));
		assertNotNull(ConfigManager.getInt(Constants.MONGO.PORT));
		assertNotNull(ConfigManager.getString(Constants.MONGO.USERNAME));
		assertNotNull(ConfigManager.getString(Constants.MONGO.PASSWORD));
	}

	@Test
	public void checkApiParams() {
		assertNotNull(ConfigManager.getString(Constants.API.AUTH.USERNAME));
		assertNotNull(ConfigManager.getString(Constants.API.AUTH.PASSWORD));
	}

}
