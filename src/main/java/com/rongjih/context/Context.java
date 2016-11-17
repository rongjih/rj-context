package com.rongjih.context;

/**
 * The system context interface
 *
 * @author RJ
 * @since JDK1.8
 */
public interface Context {
	String KEY = Context.class.getName();

	/**
	 * Get the specific attribute value
	 *
	 * @param key the attribute key
	 * @param <V> the expected return type
	 * @return the attribute value
	 */
	<V> V get(String key);

	/**
	 * Set the specific attribute value
	 *
	 * @param key   the attribute key
	 * @param value the attribute value
	 * @return the context instance
	 */
	Context set(String key, Object value);

	/**
	 * Remove the specific attribute
	 *
	 * @param key the attribute key
	 * @param <V> the expected return type
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for <tt>key</tt>.
	 */
	<V> V remove(String key);
}