package org.roqmessaging.management.desktop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

/**
 * The main window for the RoQ management desktop application
 * @author Maxime Jeanmart
 *
 */
public class RoQDesktop {
	
	public static final String ICON_DISCONNECT = "/icons/door_out.png";
	public static final String ICON_REFRESH = "/icons/arrow_rotate_clockwise.png";
	public static final String ICON_QUEUES_PANEL = "/icons/table_multiple.png";
	public static final String ICON_CLUSTER_PANEL = "/icons/chart_organisation.png";
	
	public static final String TEXT_QUEUES_MANAGEMENT = "Queues management";
	public static final String TEXT_CLUSTER_MANAGEMENT = "Cluster management";
	public static final String TEXT_EXIT = "Exit";
	public static final String TEXT_REFRESH = "Refresh";
	
	private JFrame frame;
	private JPanel mainPanel;
	private String connectionString;
	private ConnectionPanel cp;
	private ManagementPanel<?> panel;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exitItem;

	private JToolBar toolBar;
	private JButton refreshTool;
	private JButton showQueues;
	private JButton showCluster;
	

	/**
	 * Opens a new RoQ management application
	 */
	public RoQDesktop(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
		}
		frame = new JFrame("RoQ Management - not connected");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        setMenu();
        setToolBar();
        setMenuState(false);
        
        mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel);
        BorderLayout bl = new BorderLayout();
        mainPanel.setLayout(bl);
        
        showConnectionPanel();
        frame.setLocationRelativeTo(null); // center the frame
        frame.setVisible(true);
	}
	
	private void setMenu(){
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        exitItem = new JMenuItem();
        exitItem.setText("Exit");
        exitItem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	System.exit(0);
        }});
        fileMenu.add(exitItem);		
	}
	
	private void setToolBar(){
		toolBar = new JToolBar("Main toolbar");
        frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
        
        ImageIcon icon = DesktopUtils.createImageIcon(ICON_DISCONNECT,"get me out of here");
        JButton exitTool = new JButton();
        if (icon==null)
        	exitTool.setText(TEXT_EXIT);
        else {
        	exitTool.setIcon(icon);
        	exitTool.setToolTipText(TEXT_EXIT);
        }
        exitTool.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	System.exit(0);
        }});
        toolBar.add(exitTool);
        
        icon = DesktopUtils.createImageIcon(ICON_REFRESH, "more data, more data");
        refreshTool = new JButton();
        if (icon==null)
        	refreshTool.setText(TEXT_REFRESH);
        else {
        	refreshTool.setIcon(icon);
        	refreshTool.setToolTipText(TEXT_REFRESH);
        }
        refreshTool.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	panel.refreshData();
        }});
        toolBar.add(refreshTool);
        
        toolBar.addSeparator();
        
        icon = DesktopUtils.createImageIcon(ICON_QUEUES_PANEL, "Look at my queues");
        showQueues = new JButton();
        if (icon==null)
        	showQueues.setText(TEXT_QUEUES_MANAGEMENT);
        else {
        	showQueues.setIcon(icon);
        	showQueues.setToolTipText(TEXT_QUEUES_MANAGEMENT);
        }
        showQueues.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	if (panel instanceof QueueManagementPanel)
        		return;
        	hideCurrentPanel();
        	showQueuePanel();
        }});
        toolBar.add(showQueues);
        
        icon = DesktopUtils.createImageIcon(ICON_CLUSTER_PANEL, "That's my cluster");
        showCluster = new JButton();
        if (icon==null)
        	showCluster.setText(TEXT_CLUSTER_MANAGEMENT);
        else {
        	showCluster.setIcon(icon);
        	showCluster.setToolTipText(TEXT_CLUSTER_MANAGEMENT);
        }
        showCluster.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        	if (panel instanceof ClusterManagementPanel)
        		return;
        	hideCurrentPanel();
        	showClusterPanel();
        }});
        toolBar.add(showCluster);
        
        toolBar.addSeparator();
        
        // panel buttons inserted here (by the panels)
	}
	
	JToolBar getToolBar(){
		return toolBar;
	}
	
	JFrame getMainFrame(){
		return frame;
	}
	
	private void setMenuState(boolean connected){
		refreshTool.setEnabled(connected);
		showQueues.setEnabled(connected);
		showCluster.setEnabled(connected);
	}
	
	private void showConnectionPanel(){
		cp = new ConnectionPanel(this);
		mainPanel.add(cp, BorderLayout.CENTER);
	}
	
	/**
	 * A method called by the <code>ConnectionPanel</code> as soon as the user confirms a URL to connect to.
	 * @param url the url to connect to
	 */
	public void readyForConnection(String url){
		this.connectionString = url;
		frame.setTitle("RoQ Management - "+connectionString);
		mainPanel.remove(cp);
		cp=null;
		connectionString=url;
		showQueuePanel();
	}
	
	public String getConnectionURL(){
		return connectionString;
	}
	
	private void showQueuePanel(){
		panel = new QueueManagementPanel(this);
		mainPanel.add((Component)panel, BorderLayout.CENTER);
		panel.refreshData();
		
		setMenuState(true);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
		
	private void showClusterPanel(){
		panel = new ClusterManagementPanel(this);
		mainPanel.add((Component)panel, BorderLayout.CENTER);
		panel.refreshData();
				
		setMenuState(true);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	private void hideCurrentPanel(){
		setMenuState(false);
		panel.dispose();
		mainPanel.remove((Component)panel);
		panel = null;
	}

	

}
