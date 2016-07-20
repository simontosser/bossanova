package org.kornogcomputing.bossanova.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import org.jdesktop.swingx.JXDatePicker;
import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;
import org.kornogcomputing.bossanova.utils.BNStatic;


/**
 * @author Herve LE GALL <herve@kornog-computing.com>
 */
public class BNDateAndTimePanel extends JPanel implements BNComponentWithValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5570961101171332569L;

	/**
	 * datePicker
	 */
	private JXDatePicker datePicker;
	/**
	 * spinnerTime
	 */
	private JSpinner spinnerTime;
	/**
	 * modelTime
	 */
	private SpinnerDateModel modelTime;
	/**
	 * date
	 */
	private Date date;
	/**
	 * Calendar
	 */
	private Calendar gc;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 1;
	/**
	 * mandatory flag
	 */
	private boolean mandatory = true;

	/**
	 * constructor
	 * 
	 * @param date
	 *            Date
	 */
	public BNDateAndTimePanel(final Date date) {
		super();
		this.date = date;
		gc = Calendar.getInstance();
		gc.setTime(date);
		this.add(getDateAndTimePanel());
		this.setOpaque(false);
	}
	/**
	 * Constructor 
	 * @param date
	 *            Date
	 * @param mandatory the mandatory to set
	 */
	public BNDateAndTimePanel(final Date date, final boolean mandatory) {
		this(date);
		this.mandatory = mandatory;
	}


	@Override
	public final int getCompHeight() {
		return 1;
	}
	@Override
	public final int getCompWidth() {
		return compWidth;
	}

	/**
	 * @return the date
	 */
	public final Date getDate() {
		final Calendar tmp = Calendar.getInstance();
		tmp.setTime(datePicker.getDate());
		final Calendar tmpHour = Calendar.getInstance();
		tmpHour.setTime(modelTime.getDate());
		tmp.set(Calendar.HOUR_OF_DAY, tmpHour.get(Calendar.HOUR_OF_DAY));
		tmp.set(Calendar.MINUTE, tmpHour.get(Calendar.MINUTE));
		date = tmp.getTime();
		return date;
	}

	/**
	 * build panel
	 * 
	 * @return contentPanel
	 */
	public final JPanel getDateAndTimePanel() {

		final JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		contentPanel.add(getDatePicker(), c);
		c.gridx = 2;
		c.gridwidth = 1;
		contentPanel.add(getSpinnerTime(), c);

		contentPanel.setOpaque(false);
		return contentPanel;

	}

	/**
	 * 
	 * @return graphic component for date
	 */
	public final JXDatePicker getDatePicker() {
		if (datePicker == null) {
			datePicker = new JXDatePicker();
			datePicker.setFormats(BNStatic.LOCALDATEFORMATS);
			datePicker.setLinkPanel(null);
			datePicker.setPreferredSize(BNStatic.comboDimension);
			datePicker.getEditor().setPreferredSize(BNStatic.comboDimension);
			datePicker.setOpaque(false);
		}
		datePicker.getMonthView().setOpaque(false);
		return datePicker;
	}

	@Override
	public final BNPanel getParentPanel() {
		Component component = this;
		do {
			component = component.getParent();
		} while (!(component instanceof BNPanel));
		return (BNPanel) component;
	}

	/**
	 * @return the spinnerTime
	 */
	public final JSpinner getSpinnerTime() {
		if (spinnerTime == null) {
			modelTime = new SpinnerDateModel();
			spinnerTime = new JSpinner(modelTime);
			final JComponent editor = new JSpinner.DateEditor(spinnerTime,
					"HH:mm");
			spinnerTime.setOpaque(false);
			spinnerTime.setPreferredSize(new Dimension(60, 22));
			spinnerTime.setEditor(editor);
			if (date != null) {
				spinnerTime.setValue(date);

			}

		}
		return spinnerTime;
	}

	@Override	
	public final void setCompEnable(final boolean enable) {
		datePicker.setEnabled(enable);
		spinnerTime.setEnabled(enable);
	}

	@Override
	public final void setCompListener() {
		final BNPanel ip = getParentPanel();
		final KeyListener keyListener = new KeyAdapter() {
			@Override
			public void keyTyped(final KeyEvent evt) {
				ip.makeCachableButtonVisible(true);
			}
		};
		final MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent evt) {
				ip.makeCachableButtonVisible(true);
			}

		};
		for (final java.awt.Component c : getDatePicker().getComponents()) {

			if (c instanceof JTextField) {
				((JTextField) c).addKeyListener(keyListener);
			}
			if (c instanceof JButton) {
				((JButton) c).addMouseListener(mouseListener);
			}

		}
		for (final java.awt.Component c : getSpinnerTime().getComponents()) {
			final DefaultEditor d = (DefaultEditor) getSpinnerTime()
					.getEditor();
			d.getTextField().addKeyListener(keyListener);

			if (c instanceof JButton) {
				((JButton) c).addMouseListener(mouseListener);
			}

		}

	}

	@Override
	public void updateUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (spinnerTime != null) {
					for (final Component c : spinnerTime.getComponents()) {
						if (!(c instanceof JTextField)) {
							c.setBackground(Color.LIGHT_GRAY);
						}
					}
				}
			}
		});
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public final void setDate(final Date date) {
		this.date = date;
		gc = Calendar.getInstance();
		gc.setTime(date);
		datePicker.setDate(date);
		spinnerTime.setValue(date);

	}	

	@Override
	public void setCompValue(final Object value) {
		setDate((Date) value);
	}

	@Override
	public Object getCompValue() {
		return getDate();
	}

	@Override
	public boolean isCompValid() {
		if (mandatory && isVisible()) {
			return date != null;
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
	public final void setLevel(BNLevel level) {
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
