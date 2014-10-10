/**
 * 
 */
package com.cod.gamify.entity;

import java.util.HashMap;
import java.util.Map;

import com.cod.gamify.mongo.entity.MongoEntity;

/**
 * 
 * Class that represents a User
 * 
 * @author Samarth Bhargav
 * 
 */
public class User extends MongoEntity {

	private String id;
	private int points;
	private Level level;

	/**
	 * Creates a User object from a Map
	 * 
	 * @param object
	 */
	public User(Map<String, Object> object) {

		if (object.containsKey("_id")) {
			this.id = object.get("_id").toString();
		}

		if (object.containsKey("Points")) {
			this.points = (Integer) object.get("Points");
		}
	}

	/**
	 * Creates a User
	 */
	public User() {
	}

	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", id);
		map.put("Points", points);
		return map;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", points=" + points + ", level=" + level
				+ "]";
	}

}
