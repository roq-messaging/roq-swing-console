package org.roqmessaging.management.desktop.wsclient;

import java.util.List;

/**
 * A queue list as provided by the RoQ back-end server
 * @author Maxime Jeanmart
 *
 */
public class QueueList extends Message {
	
	private int results;
	private List<Queue> rows;
	
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public List<Queue> getRows() {
		return rows;
	}
	public void setRows(List<Queue> rows) {
		this.rows = rows;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("QueueList: results="+results+", success="+isSuccess());
		for (Queue q: rows)
			sb.append("\n\t"+q.toString());
		return sb.toString();
	}
	
}
