/**
 * 
 */
package com.cod.gamify.mongo.entity;

import java.util.Map;

/**
 * Entity that defines a contract so that the entity can be persisted
 * 
 * @author Samarth Bhargav
 * 
 */
public abstract class MongoEntity {

	/**
	 * Object is a Map object that contains Property -> Value Mappings <br>
	 * It is the responsibility of the class extending this class to implement
	 * this properly
	 * 
	 * @param object
	 */
	public MongoEntity(Map<String, Object> object) {

	}

	/**
	 * Empty constructor to allow subclasses a lil freedom!
	 */
	public MongoEntity() {

	}

	/**
	 * Converts all relevant Properties to a Property Name -> Value mapping <br>
	 * This map will be persisted
	 * 
	 * @return
	 */
	public abstract Map<String, Object> toMap();
}
