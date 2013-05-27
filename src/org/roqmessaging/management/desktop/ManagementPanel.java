package org.roqmessaging.management.desktop;

/**
 * A view in the management application
 * @author Maxime Jeanmart
 */
public interface ManagementPanel<T extends Object> {

	/**
	 * Defines the data to display on the panel
	 */
	public void setData(T data);
	
	/**
	 * the displayed data
	 */
	public T getData();
	
	/**
	 * asks the panel to refresh its data
	 */
	abstract void refreshData();
	
	/**
	 * cleanup the panel when it's closed
	 */
	public void dispose();
}
