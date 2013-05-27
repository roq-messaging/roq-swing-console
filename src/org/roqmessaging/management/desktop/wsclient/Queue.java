package org.roqmessaging.management.desktop.wsclient;

/**
 * The data related to a RoQ queue
 * @author Maxime Jeanmart
 *
 */
public class Queue {
	private String Name;
	private String Host;
	private boolean State;
	private boolean statisticsEnabled;
	private String ID;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getHost() {
		return Host;
	}
	public void setHost(String host) {
		this.Host = host;
	}
	public boolean isState() {
		return State;
	}
	public void setState(boolean state) {
		this.State = state;
	}
	public boolean isStatisticsEnabled() {
		return statisticsEnabled;
	}
	public void setStatisticsEnabled(boolean statisticsEnabled) {
		this.statisticsEnabled = statisticsEnabled;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String toString(){
		return "Queue: ID="+ID+", Name="+Name+", Host="+Host+", State="+State+", statisticsEnabled="+statisticsEnabled;
	}
}
