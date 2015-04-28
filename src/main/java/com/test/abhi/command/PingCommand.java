package com.test.abhi.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.test.springchain.CommonChainSpringContext;

public class PingCommand implements Command {

	public boolean execute(Context context) throws Exception {
		System.out.println(context.get(CommonChainSpringContext.USER_NAME_KEY));
		context.put(CommonChainSpringContext.PING_COMMAND_MESSAGE, "I am done in PingCommand");
		return false;
	}
}
