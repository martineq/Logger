package com.fiuba.tecnicas.logging.formatter;

import java.util.ArrayList;
import java.util.List;

import com.fiuba.tecnicas.filters.Filter;
import com.fiuba.tecnicas.filters.FilterConstants;
import com.fiuba.tecnicas.logging.Log;
import com.fiuba.tecnicas.logging.MessageFunctionConstants;
import com.fiuba.tecnicas.logging.pattern.Pattern;
import com.fiuba.tecnicas.logging.pattern.PorcentajePattern;
import com.google.gson.Gson;
/**
 * 
 * Clase que formatea como JSON
 *
 */
public class JsonFormatter implements Formatter {

	private Log log;
	private String customFilters;
	private FilterConstants filtersConstants = new FilterConstants();
	private List<Filter> filters =  new ArrayList<Filter>();
	@Override
	public void setLog(Log log) {
		this.log = log;
		
	}

	@Override
	public String getMessage() {
		this.parseFilters();
		if (isAValidMessage()){
			return this.formatMessage();
		}
		return "";	
	}

	private boolean isAValidMessage() {
		for (Filter filter  : filters) {
			if(!filter.passFilter()){
				return false;
			}
		}
		return true;
	}


	private String formatMessage() {
		LogJson logJson = new LogJson(log);
		Gson gson = new Gson();
		String json = gson.toJson(logJson);
		return json;
	}

	
	private void saveFilter(String part) {
		Filter filter = this.getOption(part);
		if(filter == null){
			return; //No hay nada asociado a ese pattern
		}
		filter.setAttributes(part);
		filter.setLog(log);
		filters.add(filter);
			
	}
	
	/**
	 * 
	 * @param part
	 * Busca una entidad del tipo Filter que represente
	 *  el formato ingresado por el usuario
	 */
	private Filter getOption(String part){
		return filtersConstants.getFunctionName(String.valueOf(part.charAt(0)));
	}

	@Override
	public void setCustomFilters(String customFilters) {
		this.customFilters = customFilters;
		
		
	}

	private void parseFilters() {
		String[] parts = this.customFilters.split("%");
		for (String part : parts){
			if(!part.equals(""))
				this.saveFilter(part);	
		}
			
		
	}

}
