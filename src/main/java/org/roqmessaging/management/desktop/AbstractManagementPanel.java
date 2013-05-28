package org.roqmessaging.management.desktop;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.roqmessaging.management.desktop.wsclient.WebServiceClient;

public abstract class AbstractManagementPanel<T extends Object> extends JPanel implements ManagementPanel<T>{

	public static final int REFRESH_RATE = 60*1000;
	
	private static final long serialVersionUID = -4562370608000482047L;
	
	private class RefreshTask extends TimerTask {
	    public void run() {
	    	System.out.println("auto refreshing ");
	      refreshData();
	    }
	}

	private Timer refreshTimer;
	protected T list;
	protected DefaultTableModel dataModel;
	protected JTable table;
	protected RoQDesktop desktop;
	protected WebServiceClient client;
	
	AbstractManagementPanel(RoQDesktop desktop){
		this.desktop = desktop;
		setLayout(new BorderLayout());
		initTableModel();
	    table = new JTable(dataModel);
	    
	    JScrollPane scrollpane = new JScrollPane(table);
	    add(scrollpane, BorderLayout.CENTER);
	    
		refreshTimer = new Timer(true);
		refreshTimer.scheduleAtFixedRate(new RefreshTask(), REFRESH_RATE, REFRESH_RATE);
		
		client = new WebServiceClient(desktop.getConnectionURL());

	}
	
	abstract void initTableModel();

	@Override
	public void dispose() {
		refreshTimer.cancel();
	}

	@Override
	public void setData(T list){
		this.list = list;
		dataModel.fireTableDataChanged();
	}

	@Override
	public T getData() {
		return list;
	}
}

