package com.rongjih.context;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The thread-local context test
 *
 * @author RJ
 * @since JDK1.8
 */
public class ThreadContextTest {
	@Test
	public void test() {
		// before initialized
		assertNull(ThreadContext.instance());

		// after initialized
		ThreadContext.init(new HashMap<String, Object>() {{
			put("k1", "v1");
		}});
		assertEquals(ThreadContext.instance(), ThreadContext.instance());
		assertEquals("v1", ThreadContext.instance().get("k1"));
		assertNull(ThreadContext.instance().get("k2"));
	}
}