package org.kornogcomputing.bossanova.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.gui.BNTableInterface;
import org.kornogcomputing.bossanova.utils.BNLevel;
/**
 * JScrollPane extension for Iktus
 * @author herve
 *
 */
public class BNScrollPane extends JScrollPane implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4658455852205557431L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 4;
	
	/**
	 * minimal constructor
	 */
	public BNScrollPane() {
		super();
	}
	/**
	 * constructor with component width
	 * @param compWidth int
	 */
	public BNScrollPane(final int compWidth) {
		super();		
		this.compWidth = compWidth;
	}

	@Override
	public int getCompHeight() {
		return 4;
	}

	@Override
	public void updateUI() {	
		super.updateUI();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				for (Component component : getVerticalScrollBar().getComponents()) {
					component.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
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
	/**
	 * resizeTable
	 */
	public void resizeTable() {
		for (final Component comp : getViewport().getComponents()) {
			if (comp instanceof BNTableInterface) {
				((BNTableInterface) comp).resizeTable();
			}
		}
	}

	@Override
	public void setCompEnable(final boolean enable) {
		//
	}

	@Override
	public void setCompListener() {
		final MouseListener listener = new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent event) {
				getParentPanel().makeCachableButtonVisible(true);
			}
		};
		for (final Component comp : getComponents()) {
			if (comp instanceof BNTableInterface) {
				comp.addMouseListener(listener);
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
