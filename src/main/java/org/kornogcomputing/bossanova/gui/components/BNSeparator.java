package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;

import javax.swing.JSeparator;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;
/**
 * JSeparator extension for Iktus
 * @author herve
 *
 */
public class BNSeparator extends JSeparator implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3623244178143805480L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 4;
	
	@Override
	public int getCompHeight() {
		return 1;
	}

	@Override
	public int getCompWidth() {
		return compWidth;
	}

	@Override
	public BNPanel getParentPanel() {
		Component component = this;
		while (!(component instanceof BNPanel)) {		
			component = component.getParent();
		} 
		return (BNPanel) component;
	}

	@Override
	public void setCompEnable(final boolean enable) {
		//
	}

	@Override
	public void setCompListener() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the level
	 */
	public final BNLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public final void setLevel(final BNLevel level) {
		this.level = level;
	}

	/**
	 * @param compWidth the compWidth to set
	 */
	public final void setCompWidth(final int compWidth) {
		this.compWidth = compWidth;
	}

	@Override
	public void setCompHeight(int height) {
		// TODO Auto-generated method stub
		
	}
}
