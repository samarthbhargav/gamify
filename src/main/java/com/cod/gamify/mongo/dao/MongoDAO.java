/**
 * 
 */
package com.cod.gamify.mongo.dao;

import com.cod.gamify.mongo.MongoConnector;
import com.cod.gamify.mongo.entity.MongoEntity;
import com.mongodb.BasicDBObject;

/**
 * Class that handles Mongo Serialization and Deserialization and other common
 * functions
 * 
 * @author Samarth Bhargav
 * 
 */
public class MongoDAO {

	public static int SORT_ORDER_ASCENDING = 1;
	public static int SORT_ORDER_DESCENDING = -1;

	/**
	 * Inserts an Entity
	 * 
	 * @param entity
	 */
	public void insert(MongoEntity entity) {
		MongoConnector.getCollection(entity.getClass()).insert(
				new BasicDBObject(entity.toMap()));
	}

	/**
	 * Removes an Entity with _id <b>id</b>
	 * 
	 * @param clazz
	 * @param id
	 */
	public void remove(Class<? extends MongoEntity> clazz, Object id) {
		MongoConnector.getCollection(clazz)
				.remove(new BasicDBObject("_id", id));
	}

	/**
	 * Returns the number of documents in the collection
	 * 
	 * @param clazz
	 * @return
	 */
	public long count(Class<? extends MongoEntity> clazz) {
		return MongoConnector.getCollection(clazz).count();
	}

	/**
	 * Drops the collection
	 * 
	 * @param clazz
	 */
	public void drop(Class<? extends MongoEntity> clazz) {
		MongoConnector.getCollection(clazz).drop();
	}
}
