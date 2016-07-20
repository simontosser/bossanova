package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;
/**
 * JSpinner extension for Iktus
 * @author herve
 *
 */
public class BNSpinner extends JSpinner implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7276644245476316232L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 1;
	/**
	 * constructor from superclass with SpinnerDateModel
	 * @param modelTime SpinnerDateModel
	 */
	public BNSpinner(final SpinnerDateModel modelTime) {
		super(modelTime);
	}
	/**
	 * constructor from superclass with SpinnerNumberModel
	 * @param spinnerModel SpinnerNumberModel
	 */
	public BNSpinner(final SpinnerNumberModel spinnerModel) {
		super(spinnerModel);

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
		for (final java.awt.Component comp : getComponents()) {
			final DefaultEditor editor = (DefaultEditor) getEditor();
			editor.getTextField().addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(final KeyEvent evt) {
					getParentPanel().makeCachableButtonVisible(true);
				}
			});

			if (comp instanceof JButton) {
				((JButton) comp).addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(final MouseEvent evt) {
						getParentPanel().makeCachableButtonVisible(true);
					}

				});
			}
		}
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
