package com.fiuba.tecnicas.logging;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Log {

		
	private Date date;
	private String level;
	
	public Log(String level){
		date = new Date();
		this.level = level;
	}
	public Date getDate() {
		return this.date;
		
	}
	//aca hay q ver 3 cosas. SI se loguea x consola el save hace print. si se guarda en archivo fwrite y si ambas las 2
	public void save(){
		//fichero = new FileWriter(configuracion.getRutaArchivo(),true);
		//pw = new PrintWriter(fichero);
	}
	public void setConfig(LoggerSettings configuracion) {
		
		
	}

}
