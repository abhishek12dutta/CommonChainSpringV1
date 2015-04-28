package com.test.springchain;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.abhi.ChainRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations={ "classpath:chain-config.xml"} )
public class ChainTest {
	@Resource
	ChainRunner chainRunner;
 
	@Test
	public void driveTheChain() {
		CommonChainSpringContext context =  new CommonChainSpringContext();
		context.put(CommonChainSpringContext.USER_NAME_KEY, "abhishek");
		System.out.println("Starting up...      [Ok]");
		chainRunner.runChain( "pingPongChain",context );
		System.out.println("Finised...          [Ok]");
		
		System.out.println("+++++++++++++++++++++++RESULT FROM WHOLE OPERATION++++++++++++++++++++++++"+System.lineSeparator());
		System.out.println(context.get(CommonChainSpringContext.PING_COMMAND_MESSAGE)+System.lineSeparator());
		System.out.println(context.get(CommonChainSpringContext.PONG_COMMAND_MESSAGE)+System.lineSeparator());
		System.out.println(context.get(CommonChainSpringContext.USER_NAME_KEY)+System.lineSeparator());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}
}
