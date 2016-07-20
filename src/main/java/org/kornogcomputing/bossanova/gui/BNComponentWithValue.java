package org.kornogcomputing.bossanova.gui;
/**
 * this interface define component who had a value to store
 * it extends BNComponent 
 * @author herve
 *
 */
public interface BNComponentWithValue extends BNComponent {
	
	/**
	 * set value to component 
	 * ex : setText for a text field, setSelectedIndex for a combo box
	 * @param value the value to set
	 */
	void setCompValue(Object value);
	/**
	 * get value from component
	 * ex : getText for a textField, getSelectedItem for a combo box
	 * @return the component value
	 */
	Object getCompValue();
	/**
	 * get if component is correctly filled
	 * ex: getText not equals to "", getSelectedIndex > -1
	 * @return true if comp valid, false elsewhere
	 */
	boolean isCompValid();
	/**
	 * Get if component must be filled
	 * @return true if madatory, false elsewhere
	 */
	boolean isMandatory();
	/**
	 * set if component is mandatory
	 * @param mandatory true if the component must be filled
	 */
	void setMandatory(boolean mandatory);	
	
	
}
