package org.roqmessaging.management.desktop;

import javax.swing.table.DefaultTableModel;

import org.roqmessaging.management.desktop.wsclient.HostList;
import org.roqmessaging.management.desktop.wsclient.WebServiceClient;

public class ClusterManagementPanel extends AbstractManagementPanel<HostList> {

	private static final long serialVersionUID = -2019454595926524906L;

	private class HostModel extends DefaultTableModel {
		
		private static final long serialVersionUID = 7247063217500762758L;

		public int getColumnCount() { 
			 return 1; 
		 }
         public int getRowCount() {
        	 if (list==null)
        		 return 0;
        	 return list.getResults();
         }
         public Object getValueAt(int row, int col) {
        	 switch(col){
        	 case 0:
        		 return list.getRows().get(row);
        	 }
        	 return ""; 
         }
         
         @Override
        public Class<?> getColumnClass(int columnIndex) {
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
	
	private static String[] columnNames = {"Name"};
	
	public ClusterManagementPanel(RoQDesktop desktop){
		super(desktop);
	}

	@Override
	void initTableModel() {
		dataModel = new HostModel();
	}
	
	@Override
	public void refreshData(){
		WebServiceClient queueData = new WebServiceClient(desktop.getConnectionURL());
		HostList list = queueData.listHosts();
		setData(list);
		System.out.println(" received items: "+list.getResults());
	}
	
	
}
