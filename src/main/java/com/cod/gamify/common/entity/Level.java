/**
 * 
 */
package com.cod.gamify.common.entity;

import java.util.Comparator;
import java.util.Map;

import com.cod.gamify.common.ConfigManager;
import com.cod.gamify.common.Constants;
import com.cod.gamify.common.except.IncompleteEntityException;


/**
 * @author Samarth Bhargav
 * 
 */
public class Level {

	private String levelName;
	private int levelNumber;
	private int points;

	public Level() {
	}

	public Level(Map<String, Object> map) {
		// TODO
	}

	public Map<String, Object> toMap() {
		// TODO
		return null;
	}

	public Level(int levelNumber) throws IncompleteEntityException {
		this.setLevelNumber(levelNumber);

		String lName = ConfigManager.getString(Constants.GAMIFY.LEVEL
				.getName(levelNumber));

		if (lName == null) {
			throw new IncompleteEntityException("Field "
					+ Constants.GAMIFY.LEVEL.getName(levelNumber)
					+ " cannot be null");
		}

		this.setLevelName(lName);

		Integer points = ConfigManager.getInt(Constants.GAMIFY.LEVEL
				.getPoints(levelNumber));

		if (points == null) {
			throw new IncompleteEntityException("Field "
					+ Constants.GAMIFY.LEVEL.getPoints(levelNumber)
					+ " cannot be null");
		}

		this.setPoints(points);
	}

	public static Comparator<Level> LEVEL_NUMBER_COMPARATOR = new Comparator<Level>() {
		public int compare(Level o1, Level o2) {
			return o1.getLevelNumber() - o2.getLevelNumber();
		}
	};

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		if (levelNumber < 0) {
			throw new IllegalArgumentException(
					"Level Number cannot be less than zero");
		}
		this.levelNumber = levelNumber;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		if (points < 0) {
			throw new IllegalArgumentException(
					"Points cannot be less than zero");
		}
		this.points = points;
	}

	@Override
	public String toString() {
		return "Level [levelName=" + levelName + ", levelNumber=" + levelNumber
				+ ", points=" + points + "]";
	}

}
