package org.kornogcomputing.bossanova.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * JButton extension
 * cachable is a parameter to set if button could be disabled/enabled by change another component value
 * navigationButton is for set the button always enable (action to display new panel...) 
 * 
 * @author herve
 * 
 */
public class BNButton extends JButton implements BNComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1850353016457271419L;
	/** navigation flag */
	private boolean navigationButton = false;
	/** cachable flag */
	private boolean cachable = false;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;

	/**
	 * constructor
	 */
	public BNButton() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 *            button text
	 * @param navigationButton
	 *            navigation flag
	 * @param cachable
	 *            cachable flag
	 * @param actionCommand
	 *            actionCommand
	 */
	public BNButton(final String text, final boolean navigationButton,
			final boolean cachable, final String actionCommand) {
		super(text);
		this.navigationButton = navigationButton;
		this.cachable = cachable;
		setActionCommand(actionCommand);
		this.setEnabled(!cachable);
		setName(actionCommand);
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 *            button text
	 * @param navigationButton
	 *            navigation flag
	 * @param cachable
	 *            cachable flag
	 * @param actionCommand
	 *            actionCommand
	 * @param level
	 *            the visibility level to set
	 * @param actionListener
	 *            the action listener to add
	 */
	public BNButton(final String text, final boolean navigationButton,
			final boolean cachable, final String actionCommand,
			final BNLevel level, final ActionListener actionListener) {
		this(text, navigationButton, cachable, actionCommand);		
		this.level = level;	
		this.addActionListener(actionListener);
	}
	
	/**
	 * 
	 * @param text
	 * @param navigationButton
	 * @param cachable
	 * @param actionCommand
	 * @param imagePath
	 * @param level
	 * @param actionListener
	 */
	public BNButton(final String text, final boolean navigationButton,
			final boolean cachable, final String actionCommand,final String imagePath,
			final BNLevel level, final ActionListener actionListener) {
		this(text, navigationButton, cachable, actionCommand,level,actionListener);
		setFont(this.getFont().deriveFont(Font.BOLD));
		setBorderPainted(false);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		setOpaque(false);
		setFocusPainted(false);
		setIcon(new ImageIcon(getClass().getResource(imagePath)));
		this.setText("");
		this.setToolTipText(text);
	}

	/**
	 * Constructor for manager frame button
	 * 	
	 * @param imagePath
	 *            the path of image file
	 * @param actionCommand
	 *            actionCommand
	 */
	public BNButton(final String actionCommand, final String imagePath) {
		super();
		setActionCommand(actionCommand);
		setFont(this.getFont().deriveFont(Font.BOLD));
		setBorderPainted(false);
		setOpaque(false);
		setFocusPainted(false);
		setIcon(new ImageIcon(getClass().getResource(imagePath)));

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
	/**
	 * cachable getter
	 * 
	 * @return cachable
	 */
	public boolean isCachable() {
		return cachable;
	}

	/**
	 * navigationButton getter
	 * 
	 * @return navigationButton
	 */
	public boolean isNavigationButton() {
		return navigationButton;
	}

	/**
	 * cachable setter
	 * 
	 * @param cachable
	 *            boolean
	 */
	public void setCachable(final boolean cachable) {
		this.cachable = cachable;
	}

	@Override
	public void setCompEnable(final boolean enable) {

		if (!navigationButton) {
			setEnabled(enable);
		}
	}

	@Override
	public void setCompListener() {
		//
	}

	/**
	 * navigationButton setter
	 * 
	 * @param navigationButton
	 *            boolean
	 */
	public void setNavigationButton(final boolean navigationButton) {
		this.navigationButton = navigationButton;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCompHeight(int height) {
		// TODO Auto-generated method stub
		
	}
}
