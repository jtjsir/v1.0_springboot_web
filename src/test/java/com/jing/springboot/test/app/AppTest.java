package com.jing.springboot.test.app;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import junit.framework.TestCase;

/**
 * @author jingsir
 **
 * 
 */
public class AppTest extends TestCase {

	public void testAppResources(){
		try {
			Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/jing/springboot/mapper/*.xml") ;
			for(Resource resource : resources){
				System.err.println(resource.getURL().getFile());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
