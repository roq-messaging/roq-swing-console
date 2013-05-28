package org.roqmessaging.management.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import org.roqmessaging.management.desktop.wsclient.QueueList;
import org.roqmessaging.management.desktop.wsclient.WebServiceClient;

/**
 * The main panel that displays the different RoQ network elements that the user can manage
 * @author Maxime Jeanmart
 *
 */
public class QueueManagementPanel extends AbstractManagementPanel<QueueList> {
	
	private static final long serialVersionUID = 8521606444671752092L;
	
	public static final String ICON_CREATE_QUEUE = "/icons/link_add.png";
	public static final String ICON_REMOVE_QUEUE = "/icons/link_delete.png";
	public static final String ICON_START_QUEUE = "/icons/control_play_blue.png";
	public static final String ICON_STOP_QUEUE = "/icons/control_pause_blue.png";
	
	public static final String TEXT_CREATE_QUEUE = "Create new queue";
	public static final String TEXT_REMOVE_QUEUE = "Remove a queue";
	public static final String TEXT_START_QUEUE = "Start a queue";
	public static final String TEXT_STOP_QUEUE = "Stop a queue";

	private class QueueModel extends DefaultTableModel {
		private static final long serialVersionUID = -4945682960306091564L;

		public int getColumnCount() { 
			 return 5; 
		 }
         public int getRowCount() {
        	 if (list==null)
        		 return 0;
        	 return list.getResults();
         }
         public Object getValueAt(int row, int col) {
        	 switch(col){
        	 case 0:
        		 return list.getRows().get(row).getID();
        	 case 1:
        		 return list.getRows().get(row).getName();
        	 case 2:
        		 return list.getRows().get(row).getHost();
        	 case 3:
        		 return list.getRows().get(row).isState();
        	 case 4:
        		 return list.getRows().get(row).isStatisticsEnabled();
        	 }
        	 return ""; 
         }
         
         @Override
        public Class<?> getColumnClass(int columnIndex) {
        	if (columnIndex==3 || columnIndex==4)
        		return Boolean.class;
        	return super.getColumnClass(columnIndex);
        }
         
         @Override
        public String getColumnName(int column) {
        	return columnNames[column];
        }
        
         @Override
         public boolean isCellEditable(int row, int column){
        	 return false;
         }
	}
	
	private static String[] columnNames = {"ID",
        "Name",
        "Host",
        "State",
        "Statistics enabled"};

	private JButton stopQueue;

	private JButton startQueue;

	private JButton removeQueue;

	private JButton createQueue;
	
	public QueueManagementPanel(RoQDesktop desktop){
		super(desktop);
		initToolbar();
	}
	
	@Override
	void initTableModel() {
		dataModel = new QueueModel();
	}
	
	private void initToolbar(){
		JToolBar toolBar = desktop.getToolBar();
		
		ImageIcon icon = DesktopUtils.createImageIcon(ICON_CREATE_QUEUE, TEXT_CREATE_QUEUE);
        createQueue = new JButton();
        if (icon==null)
        	createQueue.setText(TEXT_CREATE_QUEUE);
        else
        	createQueue.setIcon(icon);
        createQueue.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	createQueue();
        }});
        toolBar.add(createQueue);
        
        icon = DesktopUtils.createImageIcon(ICON_REMOVE_QUEUE, TEXT_REMOVE_QUEUE);
        removeQueue = new JButton();
        if (icon==null)
        	removeQueue.setText(TEXT_REMOVE_QUEUE);
        else
        	removeQueue.setIcon(icon);
        removeQueue.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	removeQueue();
        }});
        toolBar.add(removeQueue);
        
        icon = DesktopUtils.createImageIcon(ICON_START_QUEUE, TEXT_START_QUEUE);
        startQueue = new JButton();
        if (icon==null)
        	startQueue.setText(TEXT_START_QUEUE);
        else
        	startQueue.setIcon(icon);
        startQueue.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	startQueue();
        }});
        toolBar.add(startQueue);

        icon = DesktopUtils.createImageIcon(ICON_STOP_QUEUE, TEXT_STOP_QUEUE);
        stopQueue = new JButton();
        if (icon==null)
        	stopQueue.setText(TEXT_STOP_QUEUE);
        else
        	stopQueue.setIcon(icon);
        stopQueue.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	stopQueue();
        }});
        toolBar.add(stopQueue);

	}
	
	@Override
	public void dispose() {
		JToolBar toolBar = desktop.getToolBar();
		toolBar.remove(stopQueue);
		toolBar.remove(startQueue);
		toolBar.remove(removeQueue);
		toolBar.remove(createQueue);

		super.dispose();
	}
	
	@Override
	public void refreshData(){
		WebServiceClient queueData = new WebServiceClient(desktop.getConnectionURL());
		QueueList list = queueData.listQueues();
		setData(list);
	}
	
	private void createQueue(){
		//TODO: create the queue
	}

	private void removeQueue(){
		//TODO: remove the queue
	}

	private void startQueue(){
		//TODO: start the queue
	}

	private void stopQueue(){
		//TODO: stop the queue
	}

	
}
