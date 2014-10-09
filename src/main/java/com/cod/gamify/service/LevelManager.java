/**
 * 
 */
package com.cod.gamify.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cod.gamify.common.ConfigManager;
import com.cod.gamify.common.Constants;
import com.cod.gamify.common.except.IncompleteEntityException;
import com.cod.gamify.common.except.InvalidArgumentException;
import com.cod.gamify.common.except.InvalidConfigException;
import com.cod.gamify.entity.Level;

/**
 * @author Samarth Bhargav
 * 
 */
public class LevelManager {

	private List<Level> levels;

	public LevelManager() throws InvalidConfigException {
		load();
	}

	public void load() throws InvalidConfigException {
		List<Integer> levelNumbers = ConfigManager
				.getIntList(Constants.GAMIFY.LEVELS);
		if (levelNumbers == null || levelNumbers.isEmpty()) {
			throw new InvalidConfigException("Property "
					+ Constants.GAMIFY.LEVELS + " is not defined or is empty");
		}
		levels = new ArrayList<Level>();
		for (int levelNumber : levelNumbers) {
			try {
				levels.add(new Level(levelNumber));
			} catch (IncompleteEntityException e) {
				throw new InvalidConfigException(e);
			}
		}
		Collections.sort(levels, Level.LEVEL_NUMBER_COMPARATOR);

		if (levels.get(0).getPoints() != 0) {
			throw new InvalidConfigException(
					"The lowest level has to have points = 0");
		}
	}

	public Level getLevelForPoints(int points) throws InvalidArgumentException {
		if (points < 0) {
			throw new InvalidArgumentException(
					"Points cannot be less than zero");
		}

		for (int i = levels.size() - 1; i >= 0; i--) {
			if (points >= levels.get(i).getPoints()) {
				return levels.get(i);
			}
		}
		// TODO
		// This should never happen, maybe throw an exception?
		return null;
	}
}
