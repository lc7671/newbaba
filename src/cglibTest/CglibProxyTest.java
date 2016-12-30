package cglibTest;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyTest implements MethodInterceptor{
	//注入目标对象
	private ProductTarget ct;
	
	public CglibProxyTest() {
		super();
	}
	public CglibProxyTest(ProductTarget ct) {
		super();
		this.ct = ct;
	}
	public Object getProxyObject(){
		//1.实例化cglib代理增强器-
		Enhancer enhancer = new Enhancer();
		
		//2.在增强器上设置相应的属性值
		//设置目标的类:通过目标类对象来生成代理子对象
		enhancer.setSuperclass(ct.getClass());
		//设置回调方法函数,参数：回调的对象（写增强方法的代码）
		enhancer.setCallback(this);
//		Callback
		//3.-通过增强器得到代理对象
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		Long t1 =System.currentTimeMillis();
		Object invokeSuper = arg3.invokeSuper(arg0, arg2);
		Long t2 =System.currentTimeMillis();
		System.out.println(t2-t1+"毫秒");
		return invokeSuper;
	}
	
	
}
