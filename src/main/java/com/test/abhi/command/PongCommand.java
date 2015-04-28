package com.test.abhi.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.test.springchain.CommonChainSpringContext;
 
public class PongCommand implements Command {
 
	
	public boolean execute( Context context ) throws Exception {
		if(context.containsKey(CommonChainSpringContext.PING_COMMAND_MESSAGE)){
			System.out.println("ping command already executed");
		}
		context.put(CommonChainSpringContext.PONG_COMMAND_MESSAGE, "I am done in PongCommand");
		return false;
	}
}