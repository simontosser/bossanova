package org.kornogcomputing.bossanova.gui.components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * JLabel extension 
 * 
 * 
 * @author herve
 * 
 */
public class BNLabel extends JLabel implements BNComponentWithValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4598434896475487803L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 1;

	/**
	 * constructor from superclass
	 * 
	 * @param text
	 *            String
	 */
	public BNLabel(final String text) {
		super(text);

	}

	/**
	 * constructor
	 * 
	 * @param text
	 *            String
	 * @param level
	 *            display level
	 */
	public BNLabel(final String text, final BNLevel level) {
		this(text);
		this.level = level;

	}

	/**
	 * constructor with text color and nw flag
	 * 
	 * @param text
	 *            String
	 * @param level
	 *            display level
	 * @param color
	 *            text color
	 */
	public BNLabel(final String text, final BNLevel level,
			final Color color) {
		this(text, level);		
		setForeground(color);

	}

	/**
	 * constructor with text color
	 * 
	 * @param text
	 *            String
	 * @param color
	 *            text color
	 */
	public BNLabel(final String text, final Color color) {
		this(text);
		setForeground(color);
	}

	/**
	 * constructor with text color and component width
	 * 
	 * @param text
	 *            String
	 * @param color
	 *            text color
	 * @param compWidth
	 *            component width
	 */
	public BNLabel(final String text, final Color color, final int compWidth) {
		this(text);
		this.compWidth = compWidth;
		setForeground(color);

	}

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
		//
	}


	@Override
	public void setCompValue(final Object value) {
		setText((String) value);

	}

	@Override
	public Object getCompValue() {
		return getText();
	}

	@Override
	public boolean isCompValid() {
		return true;
	}

	@Override
	public boolean isMandatory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMandatory(final boolean mandatory) {
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
