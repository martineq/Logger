package com.fiuba.tecnicas.logging.formatter;

import java.util.ArrayList;
import java.util.List;

import com.fiuba.tecnicas.filters.Filter;
import com.fiuba.tecnicas.filters.FilterConstants;
import com.fiuba.tecnicas.logging.Log;

public abstract class  Formatter {
	
	protected FilterConstants filtersConstants = new FilterConstants();
	protected List<Filter> filters =  new ArrayList<Filter>();
	protected Log log;
	protected String customFilters=".*";
	
	public abstract void setLog(Log log);

	public abstract String getMessage();
	
	public abstract void setCustomFilters(String customFilters);
	
	protected boolean isAValidMessage() {
		for (Filter filter  : filters) {
			if(!filter.passFilter()){
				return false;
			}
		}
		return true;
	}
	
	protected void saveFilter(String part) {
		Filter filter = this.getFilter(part);
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
	private Filter getFilter(String part){
		return filtersConstants.getFunctionName(String.valueOf(part.charAt(0)));
	}
	
	protected void parseFilters() {
		String[] parts = this.customFilters.split("%");
		for (String part : parts){
			if(!part.equals("")){
				this.saveFilter(part);
			}
					
		}
	}


}
