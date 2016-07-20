package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ListCellRenderer;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;

import com.jidesoft.swing.AutoCompletionComboBox;


/**
 * AutoCompletionComboBox extension
 * 
 * @author herve
 * 
 */
public class BNComboBox extends AutoCompletionComboBox implements
BNComponentWithValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5545289631495881905L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;

	/** layingOut flag */
	private transient boolean layingOut = false;
	/** comp width */
	private int compWidth = 1;
	/**
	 * mandatory flag
	 */
	private boolean mandatory;
	/** current selection index */
	private transient int index = -1;

	/**
	 * minimal constructor
	 * @param mandatory the mandatory to set
	 */
	public BNComboBox(final boolean mandatory) {
		this(new Object[0], mandatory);
	}

	/**
	 * constructor
	 * 
	 * @param dimension
	 *            Dimension
	 * @param mandatory the mandatory to set       	 *         
	 */
	public BNComboBox(final Dimension dimension,
			final boolean mandatory) {
		super();
		setPreferredSize(dimension);
		this.mandatory = mandatory;
	}



	/**
	 * constructor with Object[] array and add null item flag
	 * 
	 * @param arg0
	 *            Object[]
	 * @param mandatory the mandatory to set
	 */
	public BNComboBox(final Object[] arg0, 
			final boolean mandatory) {
		super(arg0);

		this.mandatory = mandatory;
		// if null is allowed, add possibility to remove value
		this.insertItemAt(null, 0);
		setEditable(true);
		setSelectedItem(null);

		getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_DELETE) {
					setSelectedItem(null);
				}
				getParentPanel().makeCachableButtonVisible(true);
			}
		});
	}

	/**
	 * constructor with Object[] array and Dimension
	 * 
	 * @param arg0
	 *            Object[]
	 * @param dimension
	 *            Dimension
	 * @param mandatory the mandatory to set
	 */
	public BNComboBox(final Object[] arg0, final Dimension dimension,
			final boolean mandatory) {
		this(arg0, mandatory);
		setPreferredSize(dimension);
	}

	/**
	 * constructor with Object[] array, Dimension and ListCellRenderer
	 * 
	 * @param arg0
	 *            Object[]
	 * @param dimension
	 *            Dimension
	 * @param renderer
	 *            ListCellRenderer
	 * @param mandatory the mandatory to set
	 */
	public BNComboBox(final Object[] arg0, final Dimension dimension,
			final ListCellRenderer renderer, 
			final boolean mandatory) {
		this(arg0, mandatory);
		setRenderer(renderer);
		setPreferredSize(dimension);

	}

	/**
	 * constructor with Object[] array and ListCellRenderer
	 * 
	 * @param arg0
	 *            Object[]
	 * @param renderer
	 *            ListCellRenderer
	 * @param mandatory the mandatory to set 
	 */
	public BNComboBox(final Object[] arg0, final ListCellRenderer renderer,
			final boolean mandatory) {
		this(arg0, mandatory);
		setRenderer(renderer);
	}
	/**
	 * constructor with Object[] array, Dimension and ListCellRenderer
	 * 
	 * @param arg0
	 *            Object[]
	 * @param dimension
	 *            Dimension
	 * @param compWidth
	 *            component width
	 * @param mandatory the mandatory to set
	 */
	public BNComboBox(final Object[] arg0, final Dimension dimension,
			final int compWidth, final boolean mandatory) {
		this(arg0, mandatory);
		setPreferredSize(dimension);
		this.compWidth = compWidth;
	}
	/**
	 * constructor 
	 * @param list the model list
	 */
	public BNComboBox(final Object[] list) {
		super(list);
	}
	/**
	 * minimal constructor
	 */
	public BNComboBox() {
		super();
	}

	@Override
	public void doLayout() {
		try {
			layingOut = true;
			super.doLayout();
		} finally {
			layingOut = false;
		}
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
	public Dimension getSize() {

		final Dimension dim = super.getSize();
		if (!layingOut) {
			dim.width = Math.max(dim.width, getPreferredSize().width);
		}
		return dim;
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
				index = getSelectedIndex();
			}

			@Override
			public void popupMenuWillBecomeVisible(final PopupMenuEvent event) {
				//
			}
		});

	}

	@Override
	public void setCompValue(final Object value) {
		setSelectedItem(value);
	}

	@Override
	public Object getCompValue() {
		if (getSelectedIndex() > -1) {
			return getSelectedItem();
		} else if (index > -1) {
			setSelectedIndex(index);
			return getSelectedItem();
		} else {
			return null;
		}
	}

	@Override
	public boolean isCompValid() {
		if (mandatory && isVisible()) {
			return getSelectedIndex() > -1;
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
