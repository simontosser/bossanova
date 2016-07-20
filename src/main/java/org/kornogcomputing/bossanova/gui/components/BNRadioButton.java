package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * JCheckBox extension for Iktus
 * 
 * @author herve
 * 
 */
public class BNRadioButton extends JRadioButton implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3159727459028725931L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/**
	 * component width
	 */
	private int compWidth = 1;

	/**
	 * constructor
	 */
	public BNRadioButton() {
		super();

	}
	/**
	 * constructor
	 * @param label check box label
	 * @param compWidth component width
	 */
	public BNRadioButton(final String label, final int compWidth) {
		super(label);
		this.compWidth = compWidth;
	}

	/**
	 * constructor with check box label
	 * 
	 * @param label
	 *            check box label
	 */
	public BNRadioButton(final String label) {
		super(label);
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent event) {
				// getParentPanel().makeCachableButtonVisible(true);
			}
		});
		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(final ChangeEvent event) {

				getParentPanel().makeCachableButtonVisible(true);

			}
		});
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
