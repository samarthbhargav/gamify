/**
 * 
 */
package com.cod.gamify.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.cod.gamify.common.except.IncompleteEntity;

/**
 * @author Samarth Bhargav
 * 
 */
public class LevelTest {

	@Test
	public void testSorting() {
		Level l1 = new Level();
		l1.setLevelNumber(1);
		Level l2 = new Level();
		l2.setLevelNumber(2);
		List<Level> levels = Arrays.asList(l2, l1);
		Collections.sort(levels, Level.LEVEL_NUMBER_COMPARATOR);
		assertTrue(levels.get(0).getLevelNumber() == 1);
		assertTrue(levels.get(1).getLevelNumber() == 2);
	}

	@Test
	public void testLevelLoading() throws IncompleteEntity {
		Level l1 = new Level(1);
		assertNotNull(l1.getLevelName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLevelLoadingExceptIllegalArugmentForLevelNumber() {
		Level l = new Level();
		l.setLevelNumber(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLevelLoadingExceptIllegalArugmentForPoints() {
		Level l = new Level();
		l.setPoints(-2);
	}

	@Test(expected = IncompleteEntity.class)
	public void testLevelLoadingExceptIncompleteEntity()
			throws IncompleteEntity {
		@SuppressWarnings("unused")
		Level l = new Level(22);
	}

}
