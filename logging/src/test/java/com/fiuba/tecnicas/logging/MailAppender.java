package com.fiuba.tecnicas.logging;

import com.fiuba.tecnicas.logging.saver.LogSaver;

/**
 * Only for test purposes
 * @author mquiroz
 *
 */
public class MailAppender extends LogSaver{

	private String args = new String();
	
	public MailAppender(String args){
		this.args = args;
	}
	
	@Override
	public String save(String messageToSave) {
		return "Mail-"+messageToSave;
	}
	
	public String getArgs(){
		return args;
	}

}
