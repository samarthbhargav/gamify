/**
 * 
 */
package com.cod.gamify.mongo.dao;

import org.junit.Assert;
import org.junit.Test;

import com.cod.gamify.entity.Level;

/**
 * 
 */
public class MongoDAOTest {

	public void testInsert() {
		Level l = new Level();
		l.setLevelName("Blah");
		l.setLevelNumber(1);
		l.setPoints(12);
		new MongoDAO().insert(l);
		Assert.assertEquals(new MongoDAO().count(Level.class), 1);
	}

	@Test
	public void testRemove() {
		testInsert();
		new MongoDAO().remove(Level.class, 1);
		Assert.assertEquals(new MongoDAO().count(Level.class), 0);
	}

}
