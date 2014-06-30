package com.fiuba.tecnicas.filters;

public class FileFilter extends Filter {

	@Override
	public boolean passFilter() {
		for(String fileName : log.getFilePaths()){
			if(fileName.matches(filter))
				return true;
		}	
		return false;
	}

}
