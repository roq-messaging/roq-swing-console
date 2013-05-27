package org.roqmessaging.management.desktop;

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
	
	public QueueManagementPanel(RoQDesktop desktop){
		super(desktop);
	}
	
	@Override
	void initTableModel() {
		dataModel = new QueueModel();
	}
	
	@Override
	public void refreshData(){
		WebServiceClient queueData = new WebServiceClient(desktop.getConnectionURL());
		QueueList list = queueData.listQueues();
		setData(list);
		System.out.println(" received items: "+list.getResults());
	}

	
}
