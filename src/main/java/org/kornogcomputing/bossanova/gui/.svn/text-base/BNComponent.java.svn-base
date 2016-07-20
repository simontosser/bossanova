package org.kornogcomputing.bossanova.gui;

import org.kornogcomputing.bossanova.gui.components.BNPanel;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * Interface for common component behavior such as component width, set comp enabled ...
 * @author herve
 *
 */
public interface BNComponent {
	
	
	/** get the component height on the gridbagconstraint 
	 * @return component height on the gridbagconstraint */
	int getCompHeight();

	/** get the component width on the gridbagconstraint 
	 *  @return component width on the gridbagconstraint */
	int getCompWidth();
	/**
	 * 
	 * @param width the width to set
	 */
	void setCompWidth(int width);
	/**
	 * 
	 * @param height the height to set
	 */
	void setCompHeight(int height);
	/** get the BNPanel parent of the component 
	 * @return the BNPanel parent of the component */
	BNPanel getParentPanel();
	/**
	 * get the level of display for the component
	 * @return the level of display for the component
	 */
	BNLevel getLevel();
	/**
	 * set the level of display for the component
	 * @param level the level of display for the component
	 */
	void setLevel(BNLevel level);
	/** set the component enable or not 
	 * @param enable boolean */
	void setCompEnable(boolean enable);

	/** listener to make cachable button visible */
	void setCompListener();

	/**
	 * set the component enable
	 * @param enable the enable to set
	 */
	void setEnabled(boolean enable);
	
	


}
