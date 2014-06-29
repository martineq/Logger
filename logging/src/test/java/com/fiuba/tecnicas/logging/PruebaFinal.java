package com.fiuba.tecnicas.logging;

import java.util.ArrayList;

public class PruebaFinal {
	
	private static PruebaFinal Instance = new PruebaFinal();
	private static ArrayList<String> logs; 
	
	private PruebaFinal(){
		logs = new ArrayList<String>();
	}
	
	public static PruebaFinal getInstance(){
		if (Instance == null) { 
            Instance = new PruebaFinal();
        }
		return Instance;
		
	}

	public void saveLog(String messageToSave) {
		this.logs.add(messageToSave);
		
	}
}
