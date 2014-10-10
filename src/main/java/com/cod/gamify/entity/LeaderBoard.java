/**
 * 
 */
package com.cod.gamify.entity;

import java.util.List;

/**
 * @author Samarth Bhargav
 * 
 */
public class LeaderBoard {

	List<User> users;

	/**
	 * 
	 */
	public LeaderBoard() {
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LeaderBoard [users=" + users + "]";
	}

}
