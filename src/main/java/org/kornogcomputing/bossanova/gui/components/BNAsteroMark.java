package org.kornogcomputing.bossanova.gui.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * JPanel extension for build specific label
 * 
 * @author herve
 * 
 */
public class BNAsteroMark extends JPanel implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5605611091497799672L;
	/** exclusive flag */
	private boolean exclusive = true;
	/** markVisible flag */
	public boolean markVisible = true;
	/** MARK label */
	private final static JLabel MARK = new JLabel("*");
	/** text label */
	private final transient BNLabel label;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;

	/**
	 * constructor
	 * 
	 * @param bNLabel
	 *            text label
	 * @param exclusive
	 *            boolean, true if this is appear only in nw mode
	 */
	public BNAsteroMark(final BNLabel bNLabel, final boolean exclusive) {
		this(bNLabel);
		this.exclusive = exclusive;
	}

	/**
	 * constructor
	 * 
	 * @param label
	 *            JLabel
	 */
	public BNAsteroMark(final BNLabel label) {
		super();
		this.label = label;
		build(true);
	}
/**
 * constructor
 * @param text label text
 * @param color label color
 */
	public BNAsteroMark(final String text, final Color color) {
		super();
		label = new BNLabel(text, level, color);
		build(true);
	}
/**
 * constructor
 * @param text label text
 */
	public BNAsteroMark(final String text) {
		super();
		label = new BNLabel(text, level);
		build(true);
	}

	/**
	 * add * to label
	 */
	public void addMark() {
		build(true);
	}

	/**
	 * build panel
	 * 
	 * @param markVisible
	 *            display * or not
	 */
	private void build(final boolean markVisible) {
		removeAll();
		MARK.setForeground(new Color(0x00, 0x80, 0x00));
		MARK.setFont(new Font(MARK.getFont().getFontName(), Font.BOLD, label
				.getFont().getSize() + 2));
		this.setLayout(new BorderLayout());
		if (markVisible) {
			add(MARK, BorderLayout.WEST);
		}
		add(label, BorderLayout.CENTER);
		this.setOpaque(false);
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
	 * exclusive getter
	 * 
	 * @return exclusive
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * remove * from label
	 */
	public void removeMark() {
		build(false);
	}

	@Override
	public void setCompEnable(final boolean enable) {
		//
	}

	@Override
	public void setCompListener() {
		//
	}

	/**
	 * exclusive setter
	 * 
	 * @param exclusive
	 *            boolean
	 */
	public void setExclusive(final boolean exclusive) {
		this.exclusive = exclusive;
	}

	/**
	 * @return the level
	 */
	@Override
	public final BNLevel getLevel() {
		return level;
	}

	
	@Override
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
