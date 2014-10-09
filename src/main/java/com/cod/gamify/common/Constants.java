/**
 * 
 */
package com.cod.gamify.common;

/**
 * @author Smarth Bhargav
 * 
 */
public class Constants {

	public static class APPLICATION {
		public static final String CONFIG_FILE = "";
	}

	public static class MONGO {
		public static final String HOST = "mongo.host";
		public static final String PORT = "mongo.port";
		public static final String USERNAME = "mongo.username";
		public static final String PASSWORD = "mongo.password";
	}

	public static class API {
		public static class AUTH {
			public static final String USERNAME = "api.auth.username";
			public static final String PASSWORD = "api.auth.password";
		}
	}

	public static class GAMIFY {
		public static final String LEVELS = "gamify.levels";
		public static final String LEVEL_PREFIX = "gamify.level";

		public static class LEVEL {
			public static String getName(int level) {
				return LEVEL_PREFIX + "." + level + ".name";
			}

			public static String getPoints(int level) {
				return LEVEL_PREFIX + "." + level + ".points";
			}
		}
	}
}
