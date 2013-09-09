package org.roqmessaging.management.desktop.wsclient;

public class QueueCreator {
	private String Name;
	private String Host;
	
	public QueueCreator(String name, String host){
		setName(name);
		setHost(host);
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getHost() {
		return Host;
	}
	public void setHost(String host) {
		Host = host;
	}

}
