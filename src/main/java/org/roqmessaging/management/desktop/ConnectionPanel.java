package org.roqmessaging.management.desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A panel that appears when the desktop application is not connected to any RoQ management server or back-end.
 * @author Maxime Jeanmart
 *
 */
public class ConnectionPanel extends JPanel {

	private static final long serialVersionUID = -3026309191266029622L;
	private JTextField field;
	private Box vertical;
	private Box horizontal;
	
	public ConnectionPanel(final RoQDesktop desktop){
		setLayout(new BorderLayout());
		vertical = Box.createVerticalBox();
		add(vertical, BorderLayout.CENTER);
		vertical.add(Box.createGlue());
		
		horizontal = Box.createHorizontalBox();
		horizontal.add(Box.createHorizontalStrut(10));
		JLabel label = new JLabel("Connection URL:");
		horizontal.add(label);
		horizontal.add(Box.createHorizontalStrut(10));
		
		field = new JTextField();
		field.setMaximumSize(new Dimension(Short.MAX_VALUE, field.getPreferredSize().height));
		horizontal.add(field);
		field.setText("http://localhost:3000");
		
		JButton connect = new JButton("Connect");
		connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				desktop.readyForConnection(getConnectionURL());
			}
		});
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(connect);
		horizontal.add(Box.createHorizontalStrut(10));
		vertical.add(horizontal);
		
		vertical.add(Box.createGlue());
	}
	
	public String getConnectionURL(){
		return field.getText();
	}
	
}
