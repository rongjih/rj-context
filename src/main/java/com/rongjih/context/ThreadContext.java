/**
 *
 */
package com.rongjih.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The thread-local context implements
 *
 * @author RJ
 * @since JDK1.8
 */
public final class ThreadContext implements Context, Serializable {
	// use thread-local variable to keep de system context
	private static ThreadLocal<Context> holder = new ThreadLocal<Context>() {
		@Override
		public void set(Context context) {
			super.set(context);
		}
	};

	// hole all the context attribute data
	private final Map<String, Object> attrs = new HashMap<>();

	/**
	 * create a new instance with the specific data
	 *
	 * @param data the context data
	 */
	private ThreadContext(Map<String, Object> data) {
		if (data != null) attrs.putAll(data);
		holder.set(this);
	}

	/**
	 * Initial a new ThreadContext instance and keep it in thread-local variable
	 *
	 * @param data the context data
	 * @return the initialized context instance
	 */
	public static Context init(Map<String, Object> data) {
		holder.set(new ThreadContext(data));
		return holder.get();
	}

	/**
	 * Get the context from thread-local variable
	 *
	 * @return the context instance save in thread-local variable
	 */
	public static Context instance() {
		return holder.get();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) attrs.get(key);
	}

	@Override
	public Context set(String key, Object value) {
		attrs.put(key, value);
		return this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <V> V remove(String key) {
		return (V) attrs.remove(key);
	}
}
