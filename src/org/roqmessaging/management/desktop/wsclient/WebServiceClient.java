package org.roqmessaging.management.desktop.wsclient;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Centralizes all operations related to RoQ back-end
 * @author Maxime Jeanmart
 *
 */
public class WebServiceClient {

	private String connectionLocation;
	private WebResource service;
	
	/**
	 * Initializes the client by providing the base URI of the RoQ back-end
	 * @param connectionLocation the URL of the RoQ back-end
	 */
	public WebServiceClient(String connectionLocation){
		this.connectionLocation = connectionLocation;
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    URI uri = UriBuilder.fromUri(connectionLocation).build();
	    service = client.resource(uri);
	}

	/**
	 * The connection String used to retrieve the queue data.
	 */
	public String getBackEndLocation(){
		return connectionLocation;
	}
	
	/**
	 * Provides the list of queues
	 */
	public QueueList listQueues(){
		// example: http://localhost:3000/queues/list?_dc=1364626756034&page=1&start=0&limit=6
		String query = service.path("queues").accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("serialized result:\n"+query);
		Gson gson = new Gson();
		QueueList list = gson.fromJson(query, QueueList.class);
		return list;
	}
	
	
	/**
	 * Provides the list of hosts
	 */
	public HostList listHosts(){
		String query = service.path("hosts").accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("serialized result:\n"+query);
		Gson gson = new Gson();
		HostList list = gson.fromJson(query, HostList.class);
		return list;
		
	}

}
