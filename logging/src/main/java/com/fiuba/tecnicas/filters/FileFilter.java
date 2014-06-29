package com.fiuba.tecnicas.filters;

public class FileFilter extends Filter {

	@Override
	public boolean passFilter() {
		for(String fileName : log.getFilePaths()){
			if(filter.matches(fileName))
				return true;
		}	
		return false;
	}

}
