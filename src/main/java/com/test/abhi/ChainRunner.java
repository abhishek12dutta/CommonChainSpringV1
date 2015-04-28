package com.test.abhi;

import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.test.springchain.CommonChainSpringContext;

public class ChainRunner{
	
	@Autowired
	private ApplicationContext applicationContext;

	public void runChain(String chainName, CommonChainSpringContext context) {
		try {
			createChain(chainName).execute(context);
		} catch (Exception exc) {
			throw new RuntimeException("Chain \"" + chainName
					+ "\": Execution failed.", exc);
		}
	}

	protected ChainBase createChain(String chainName) {
		return (ChainBase) this.applicationContext.getBean(chainName);
	}

}
