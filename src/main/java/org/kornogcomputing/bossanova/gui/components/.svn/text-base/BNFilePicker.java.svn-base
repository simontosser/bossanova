/**
 * 
 */
package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;
import org.kornogcomputing.bossanova.utils.BNStatic;

/**
 * @author herve
 *
 */
public class BNFilePicker extends JPanel implements BNComponentWithValue, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5824922523587476697L;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
	/** component width */
	private int compWidth = 1;
	/**
	 * mandatory flag
	 */
	private boolean mandatory;
	/** 
	 * text field
	 */
	private BNFormattedTextField textField;
	/**
	 * file chooser
	 */
	private JFileChooser fileChooser;
	/**
	 * mode
	 */
	private int mode = 1;
	/** open mode */
	public static final int MODE_OPEN = 1;
	/** save mode */
	public static final int MODE_SAVE = 2;
	
	/**
	 * constructor
	 */
	public BNFilePicker() {
		this("choisir le repertoire data");
	}
	/**
	 * constructor
	 * @param textFieldLabel the text field to display
	 */
	public BNFilePicker(String textFieldLabel) {
		super(new GridBagLayout());
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		textField = new BNFormattedTextField(false, BNStatic.bigCompDimension);
		textField.setValue(textFieldLabel);
		final GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridy = 0;
		constraint.gridx = 0;
		constraint.gridwidth = 2;
		
		add(textField, constraint);
		
		constraint.gridx = 2;
		constraint.gridwidth = 1;
		add(new BNButton("select", false, false, "SHOW", level, this), constraint);

	}

	/**
	 * 
	 * @param mode the mode to set
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}
	/**
	 * 
	 * @return textField.getText()
	 */
	public String getSelectedFilePath() {
		return textField.getText();
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
	public void setCompWidth(int width) {
		compWidth = width;		
	}

	@Override
	public void setCompHeight(int height) {
		// 		
	}

	@Override
	public final BNPanel getParentPanel() {
		Component component = this;
		do {
			component = component.getParent();
		} while (!(component instanceof BNPanel));
		return (BNPanel) component;
	}

	@Override
	public BNLevel getLevel() {
		return level;
	}

	@Override
	public void setLevel(BNLevel level) {
		this.level = level;
	}

	@Override
	public void setCompEnable(boolean enable) {
		setEnabled(enable);
	}

	@Override
	public void setCompListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCompValue(Object value) {
		textField.setValue(value);
	}

	@Override
	public Object getCompValue() {

		return fileChooser.getSelectedFile();
	}

	@Override
	public boolean isCompValid() {
		return true;
	}

	@Override
	public boolean isMandatory() {		
		return mandatory;
	}

	@Override
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (mode == MODE_OPEN) {
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				setCompValue(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (mode == MODE_SAVE) {
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				setCompValue(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
		getParentPanel().actionPerformed(e);
		
	}

}
