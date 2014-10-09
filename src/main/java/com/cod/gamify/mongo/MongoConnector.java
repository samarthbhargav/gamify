/**
 * 
 */
package com.cod.gamify.mongo;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.cod.gamify.common.ConfigManager;
import com.cod.gamify.common.Constants;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author Samarth Bhargav
 * 
 */
public class MongoConnector {

	public static MongoClient client;
	public static Map<String, DBCollection> collectionMap = new HashMap<String, DBCollection>();

	static {
		String username = ConfigManager.getString(Constants.MONGO.USERNAME);
		String password = ConfigManager.getString(Constants.MONGO.USERNAME);
		int port = ConfigManager.getInt(Constants.MONGO.PORT);
		String host = ConfigManager.getString(Constants.MONGO.USERNAME);

		try {
			if (username != null && username.length() != 0 && password != null
					&& password.length() != 0) {
				MongoCredential credential = MongoCredential
						.createMongoCRCredential(username, password,
								password.toCharArray());
				client = new MongoClient(new ServerAddress(host, port),
						Arrays.asList(credential));
			} else {
				client = new MongoClient(new ServerAddress(host, port));
			}
		} catch (UnknownHostException e) {
			throw new IllegalStateException(e);
		}
	}

	public static DBCollection getCollection(Class<?> clazz) {
		if (!collectionMap.containsKey(clazz.getSimpleName())) {
			collectionMap.put(clazz.getSimpleName(),
					client.getDB(ConfigManager.getString(Constants.MONGO.DB))
							.getCollection(clazz.getSimpleName()));
		}
		return collectionMap.get(clazz.getSimpleName());
	}
}
