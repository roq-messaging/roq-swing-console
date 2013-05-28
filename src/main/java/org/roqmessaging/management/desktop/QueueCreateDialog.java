package org.roqmessaging.management.desktop;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A dialog to input the data required to create a new queue
 * @author Maxime Jeanmart
 *
 */
class QueueCreateDialog {

	private JTextField name;
	private JComboBox host;
	private boolean success = false;
	
	QueueCreateDialog(JFrame parent, String[] hosts){
		if (hosts==null || hosts.length==0)
			throw new NullPointerException("hosts cannot be null or empty");
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		pane.add(top);
		
		top.add(new JLabel("Name: "));
		name = new JTextField();
		top.add(name);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		pane.add(bottom);
		
		bottom.add(new JLabel("Host: "));
		host = new JComboBox(hosts);
		host.setSelectedIndex(0);
		bottom.add(host);
		
		int result = JOptionPane.showConfirmDialog(parent, pane, "Create a new Queue", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		success = result==JOptionPane.OK_OPTION;
	}
	
	boolean isSuccessful(){
		return success;
	}
	
	String getName(){
		return name.getText();
	}
	
	String getHost(){
		return (String)host.getSelectedItem();
	}
	
	
	
}
