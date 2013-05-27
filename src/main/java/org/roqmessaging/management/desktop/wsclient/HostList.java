package org.roqmessaging.management.desktop.wsclient;

import java.util.List;

public class HostList extends Message {
	private int results;
	private List<String> rows;
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public List<String> getRows() {
		return rows;
	}
	public void setRows(List<String> rows) {
		this.rows = rows;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("HostsList: results="+results+", success="+isSuccess());
		for (String q: rows)
			sb.append("\n\t"+q);
		return sb.toString();
	}
	
}
