/**
 * 
 */
package com.cod.gamify.service;

import org.junit.Assert;
import org.junit.Test;

import com.cod.gamify.common.except.InvalidArgumentException;
import com.cod.gamify.common.except.InvalidConfigException;

/**
 * @author hduser
 * 
 */
public class LevelManagerTest {

	@Test
	public void test() throws InvalidConfigException, InvalidArgumentException {
		LevelManager manager = new LevelManager();
		Assert.assertTrue(manager.getLevelForPoints(0).getLevelNumber() == 1);
		Assert.assertTrue(manager.getLevelForPoints(200).getLevelNumber() == 1);
		Assert.assertTrue(manager.getLevelForPoints(500).getLevelNumber() == 2);
		Assert.assertTrue(manager.getLevelForPoints(666).getLevelNumber() == 2);
		Assert.assertTrue(manager.getLevelForPoints(1000).getLevelNumber() == 3);
		Assert.assertTrue(manager.getLevelForPoints(1100).getLevelNumber() == 3);
		Assert.assertTrue(manager.getLevelForPoints(5000).getLevelNumber() == 4);
		Assert.assertTrue(manager.getLevelForPoints(5002).getLevelNumber() == 4);
		Assert.assertTrue(manager.getLevelForPoints(5001).getLevelNumber() == 4);

	}

	@Test(expected = InvalidArgumentException.class)
	public void testThrowsInvalidArgumentException()
			throws InvalidConfigException, InvalidArgumentException {
		LevelManager manager = new LevelManager();
		manager.getLevelForPoints(-1);
	}

}
