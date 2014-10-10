/**
 * 
 */
package com.cod.gamify.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import com.cod.gamify.entity.User;
import com.cod.gamify.mongo.MongoConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * DAO for User entities
 * 
 * @author Samarth Bhargav
 * 
 */
public class UserDAO extends MongoDAO {

	/**
	 * Fetches a user with id <b>id</b>
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User fetchUser(String id) {
		DBObject object = MongoConnector.getCollection(User.class).findOne(
				new BasicDBObject("_id", id));
		if (object == null) {
			return null;
		}

		return new User(object.toMap());
	}

	/**
	 * @param sortField
	 * @param order
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> fetchUsersSortedBy(String sortField, int order) {
		DBCursor cursor = MongoConnector.getCollection(User.class).find()
				.sort(new BasicDBObject(sortField, order));
		if (cursor == null || cursor.size() == 0) {
			return null;
		}

		List<User> users = new ArrayList<User>();
		for (DBObject object : cursor) {
			users.add(new User(object.toMap()));
		}
		return users;
	}

	/**
	 * @param id
	 * @param pointsToAddOrSubtract
	 */
	public void incrementPointsForUser(String id, int pointsToAddOrSubtract) {
		MongoConnector.getCollection(User.class).update(
				new BasicDBObject("_id", id),
				new BasicDBObject("$inc", new BasicDBObject("Points",
						pointsToAddOrSubtract)));
	}
}
