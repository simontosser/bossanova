package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;


/**
 * JComboBox extension for Iktus (not use autocompletion)
 * 
 * @author herve
 * 
 */
public class BNSingleComboBox extends JComboBox implements
BNComponentWithValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4284808248473360876L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/**
	 * mandatory flag
	 */
	private boolean mandatory;

	/**
	 * constructor from superclass with an empty item collection
	 * @param mandatory the mandatory to set
	 */
	public BNSingleComboBox(final boolean mandatory) {
		super(new Object[0]);
		this.mandatory = mandatory;
	}

	/**
	 * Constructor 
	 * @param arg0
	 *            Object array
	 * @param dimension
	 *            Dimension
	 * @param renderer
	 *            ListCellRenderer
	 * @param mandatory the mandatory to set
	 */
	public BNSingleComboBox(final Object[] arg0,
			final Dimension dimension, final ListCellRenderer renderer,
			final boolean mandatory) {
		super(arg0);
		this.insertItemAt(null, 0);
		setSelectedIndex(0);
		setRenderer(renderer);
		setPreferredSize(dimension);
		this.mandatory = mandatory;
	}

	@Override
	public int getCompHeight() {
		return 1;
	}

	@Override
	public int getCompWidth() {
		return 1;
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
		setEnabled(enable);
	}

	@Override
	public void setCompListener() {
		addPopupMenuListener(new PopupMenuListener() {			
			@Override
			public void popupMenuCanceled(final PopupMenuEvent event) {
				//
			}

			@Override
			public void popupMenuWillBecomeInvisible(final PopupMenuEvent event) {
				getParentPanel().makeCachableButtonVisible(true);
			}

			@Override
			public void popupMenuWillBecomeVisible(final PopupMenuEvent event) {
				//
			}
		});

	}

	@Override
	public void setCompValue(final Object value) {
		if (value == null) {
			setSelectedIndex(0);
		} else {

			setSelectedItem(value);
		}

	}

	@Override
	public Object getCompValue() {
		return getSelectedItem();
	}

	@Override
	public boolean isCompValid() {
		if (mandatory) {
			return getSelectedIndex() > 0;
		}
		return true;
	}

	/**
	 * @return the mandatory
	 */
	@Override
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * @param mandatory
	 *            the mandatory to set
	 */
	@Override
	public void setMandatory(final boolean mandatory) {
		this.mandatory = mandatory;
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

	@Override
	public void setCompWidth(int width) {

	}

	@Override
	public void setCompHeight(int height) {

	}

}
