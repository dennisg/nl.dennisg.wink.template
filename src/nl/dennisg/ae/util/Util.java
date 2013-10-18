package nl.dennisg.ae.util;

import com.google.gson.Gson;

public class Util {

	private Util() {}
	
	private static final ThreadLocal<Gson> GSON = new ThreadLocal<Gson>() {
		@Override
		protected Gson initialValue() {
			return new Gson();
		}
	};
	
	public static ThreadLocal<Gson> gson() {
		return GSON;
	}
}
