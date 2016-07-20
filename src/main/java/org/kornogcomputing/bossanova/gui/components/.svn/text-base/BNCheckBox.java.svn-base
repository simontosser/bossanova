package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;


/**
 * JCheckBox extension
 * 
 * @author herve
 * 
 */
public class BNCheckBox extends JCheckBox implements BNComponentWithValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9183840360439020499L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/**
	 * comp width
	 */
	private int compWidth = 1;

	/**
	 * constructor
	 */
	public BNCheckBox() {
		super();
		initialize();

	}
	/**
	 * constructor with label, width and field name
	 * @param label label to display
	 * @param compWidth component width (ie: Gridbagconstraint.width)
	 */
	public BNCheckBox(final String label, final int compWidth) {
		super(label);
		this.compWidth = compWidth;
		initialize();
	}

	
	/**
	 * constructor with label
	 * @param label label to display	
	 */
	public BNCheckBox(final String label) {
		super(label);
		initialize();
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
	public void setCompValue(final Object value) {
		setSelected((Boolean) value);
	}

	/**
	 * initialize this get specific imageIcon for checkbox status
	 */
	private void initialize() {
		setIcon(new ImageIcon(getClass().getResource(
		"/images/icon_checkbox_no.gif")));
		setSelectedIcon(new ImageIcon(getClass().getResource(
		"/images/icon_checkbox_yes.gif")));
		setDisabledIcon(new ImageIcon(getClass().getResource(
		"/images/icon_checkbox_no.gif")));
		setDisabledSelectedIcon(new ImageIcon(getClass().getResource(
		"/images/icon_checkbox_yes.gif")));
	}

	@Override
	public void setCompEnable(final boolean enable) {
		setEnabled(enable);

	}

	@Override
	public void setCompListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent event) {
				// getParentPanel().makeCachableButtonVisible(true);
			}
		});
		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(final ChangeEvent event) {
				 AbstractButton abstractButton =
			          (AbstractButton) changeEvent.getSource();
			        ButtonModel buttonModel = abstractButton.getModel();   						       
			    if (buttonModel.isPressed()) {
					getParentPanel().makeCachableButtonVisible(true);
				}
			}
		});
	}

	@Override
	public Object getCompValue() {
		return isSelected();
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
