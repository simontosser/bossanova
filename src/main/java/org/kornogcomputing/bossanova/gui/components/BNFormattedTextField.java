package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;
import org.kornogcomputing.bossanova.utils.BNStatic;


/**
 * JFormattedTextField extension for Iktus
 * 
 * @author herve
 * 
 */
public class BNFormattedTextField extends JFormattedTextField implements
		BNComponentWithValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 756649746065051527L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/**
	 * mandatory flag
	 */
	private boolean mandatory;
	
	/** component width */
	private int compWidth = 1;

	/**
	 * constructor
	 */
	public BNFormattedTextField() {
		super();
		setPreferredSize(BNStatic.comboDimension);
	}
	/**
	 * constructor 
	 * @param mandatory the mandatory to set
	 */
	public BNFormattedTextField(
			final boolean mandatory) {
		this.mandatory = mandatory;
	}
	/**
	 * constructor from superclass with an empty item collection
	 * @param mandatory the mandatory to set
	 * @param value the component value to set
	 */
	public BNFormattedTextField(
			final boolean mandatory, final Object value) {
		this.mandatory = mandatory;
		setValue(value);
	}
	/**
	 * constructor from superclass with an empty item collection
	 * @param dimension
	 *            Dimension
	 * @param mandatory the mandatory to set
	 * @param value the component value to set
	 */
	public BNFormattedTextField(final Dimension dimension,
			final boolean mandatory, final Object value) {
		this(mandatory);
		setPreferredSize(dimension);
		setValue(value);

	}
	/**
	 * constructor from superclass with an empty item collection
	 * @param mandatory the mandatory to set
	 * @param dimension
	 *            Dimension
	 */
	public BNFormattedTextField(final Dimension dimension,
			 final boolean mandatory) {
		this(mandatory);
		setPreferredSize(dimension);
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
		setCompEnable(mandatory);
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
		setEnabled(enable);
	}

	@Override
	public void setCompListener() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(final FocusEvent event) {
				if (getFocusLostBehavior() == JFormattedTextField.PERSIST) {
					setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
				}
			}

			@Override
			public void focusLost(final FocusEvent event) {
				if (getText().equals("")) {
					setFocusLostBehavior(JFormattedTextField.PERSIST);
					setValue(null);
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(final KeyEvent evt) {
				getParentPanel().makeCachableButtonVisible(true);
			}
		});

	}

	@Override
	public void setCompValue(final Object value) {
		setValue(value);

	}

	@Override
	public Object getCompValue() {
		if ("".equals(getText())) {
			return null;
		} else {
			return  getText();
		}
	}

	@Override
	public boolean isCompValid() {
		if (mandatory) {
			return !"".equals(getText());
		}
		return true;
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
	public final void setCompWidth(int compWidth) {
		this.compWidth = compWidth;
	}

	@Override
	public void setCompHeight(int height) {
		// TODO Auto-generated method stub
		
	}

}
