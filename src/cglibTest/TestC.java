package cglibTest;

import org.junit.Test;

public class TestC {
	@Test
	public void test1(){
		ProductTarget productTarget = new ProductTarget();
		CglibProxyTest cglibProxyTest = new CglibProxyTest(productTarget);
		ProductTarget proxyObject = (ProductTarget) cglibProxyTest.getProxyObject();
		proxyObject.save();
	}

}
