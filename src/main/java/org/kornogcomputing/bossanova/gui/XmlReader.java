package org.kornogcomputing.bossanova.gui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.kornogcomputing.bossanova.exception.NoComponentNameException;
import org.kornogcomputing.bossanova.gui.components.BNAsteroMark;
import org.kornogcomputing.bossanova.gui.components.BNButton;
import org.kornogcomputing.bossanova.gui.components.BNButtonBarPanel;
import org.kornogcomputing.bossanova.gui.components.BNCheckBox;
import org.kornogcomputing.bossanova.gui.components.BNComboBox;
import org.kornogcomputing.bossanova.gui.components.BNDateAndTimePanel;
import org.kornogcomputing.bossanova.gui.components.BNFilePicker;
import org.kornogcomputing.bossanova.gui.components.BNFormattedTextField;
import org.kornogcomputing.bossanova.gui.components.BNLabel;
import org.kornogcomputing.bossanova.gui.components.BNPanel;
import org.kornogcomputing.bossanova.gui.components.BNScrollPane;
import org.kornogcomputing.bossanova.gui.components.BNSeparator;
import org.kornogcomputing.bossanova.gui.components.BNSubPanel;
import org.kornogcomputing.bossanova.utils.BNLevel;
import org.kornogcomputing.bossanova.utils.BNUtils;
import org.kornogcomputing.bossanova.xml.BnAsteroMark;
import org.kornogcomputing.bossanova.xml.BnButton;
import org.kornogcomputing.bossanova.xml.BnButtonBarPanel;
import org.kornogcomputing.bossanova.xml.BnCheckBox;
import org.kornogcomputing.bossanova.xml.BnComboBox;
import org.kornogcomputing.bossanova.xml.BnComponent;
import org.kornogcomputing.bossanova.xml.BnDateAndTime;
import org.kornogcomputing.bossanova.xml.BnFileChooser;
import org.kornogcomputing.bossanova.xml.BnLabel;
import org.kornogcomputing.bossanova.xml.BnLineBreak;
import org.kornogcomputing.bossanova.xml.BnPanel;
import org.kornogcomputing.bossanova.xml.BnScrollPane;
import org.kornogcomputing.bossanova.xml.BnSeparator;
import org.kornogcomputing.bossanova.xml.BnSubPanel;
import org.kornogcomputing.bossanova.xml.BnTextField;
import org.kornogcomputing.bossanova.xml.Row;
import org.kornogcomputing.bossanova.xml.ObjectFactory;

/**
 * 
 * @author herve
 *
 */



public class XmlReader {
	/**
	 * JAXBContext
	 */
	JAXBContext jc;
	/**
	 * ActionListener
	 */
	private ActionListener listener;

	/**
	 * constructor
	 * @param listener the ActionListener
	 */
	public XmlReader(ActionListener listener) {
		super();
		this.listener = listener;

	}
/**
 * 
 * @throws JAXBException JAXBException
 */
	public void writeXml() throws JAXBException {
		File file = new File("out.xml");
		ObjectFactory of = new ObjectFactory();
		BnPanel panel = of.createBnPanel();
		Row colonne = of.createRow();
		panel.getRow().add(colonne);
		BnLabel label = of.createBnLabel();
		label.setText("youkaidi");
		label.setWidth(3);
		label.setBnLevel("1");
		colonne.getValues().add(label);
		BnButtonBarPanel buttonBar = of.createBnButtonBarPanel();
		buttonBar.setWidth(4);
		BnButton button1 = of.createBnButton();
		button1.setActionCommand("SAVE");
		button1.setNav(true);
		button1.setCachable(false);
		button1.setText("Valider");

		buttonBar.getBnButton().add(button1);


		BnButton button2 = of.createBnButton();
		button2.setActionCommand("CANCEL");
		button2.setNav(false);
		button2.setCachable(true);
		button2.setText("Annuler");

		buttonBar.getBnButton().add(button2);

		BnComboBox combo = of.createBnComboBox();
		combo.setMandatory(true);


		colonne.getValues().add(buttonBar);
		colonne.getValues().add(combo);
	
		jc = JAXBContext.newInstance(BnPanel.class);

		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(panel, file);
		
	}
	
	/**
	 * build a panel from xml file in parameter
	 * @param file the file to read
	 * @return a puilt panel
	 * @throws JAXBException JAXBException
	 * @throws FileNotFoundException 
	 * @throws NoComponentNameException 
	 */
	public BNPanel read(File file) throws JAXBException, FileNotFoundException, NoComponentNameException {
		if (!file.exists()) {
			throw new FileNotFoundException("File doesn't exist"); 
		}
		jc = JAXBContext.newInstance(BnPanel.class);
		final Unmarshaller u = jc.createUnmarshaller();
		final BnPanel pan = (BnPanel) u.unmarshal(file);
		return buildFromXml(pan);		
	}

	/**
	 * 
	 * @param pan the BnPanel 
	 * @return built BNPanel
	 * @throws NoComponentNameException 
	 */
	public BNPanel buildFromXml(BnPanel pan) throws NoComponentNameException {
		String title = pan.getTitle();
		if (pan.getTitle().startsWith("$")) {
			title = (String) BNUtils.getFunctionVal(title.substring(1, title.length()));
		}
		BNLevel level = BNLevel.valueByString(pan.getBnLevel());
		boolean readOnly = BNUtils.nullToTrue(pan.isReadOnly());
		// build component array
		return new BNPanel(makeList(pan.getRow()), title, readOnly, level, pan.getBean());

	}
	/**
	 * build a list of list of component via list of rows
	 * @param rows the row list
	 * @return a list of list of component
	 */
	public List<List<Component>> makeList(List<Row> rows) {
		List<List<Component>> components = new ArrayList<List<Component>>();	
		if (rows == null) {			
			return components;
		}
		// 
		for (Row col : rows) {

			List<Component> compColonne = new ArrayList<Component>();
			for (BnComponent xmlComp : col.getValues()) {				
				if (xmlComp.getLabel() != null) {
					String lbl = xmlComp.getLabel();
					if (lbl.startsWith("$")) {
						lbl = (String) BNUtils.getFunctionVal(lbl.substring(1, lbl.length()));
					}
					compColonne.add(new BNLabel(lbl));			
				}
				BNComponent comp = null;

				if (xmlComp instanceof BnTextField) {
					comp = new BNFormattedTextField();					
				} else if (comp instanceof BnAsteroMark) {								
					BnAsteroMark bnLab = (BnAsteroMark) comp;

					comp = new BNAsteroMark(bnLab.getLabel());
				} else if (xmlComp instanceof BnLabel) {
					String lbl = ((BnLabel) xmlComp).getText();
					if (lbl.startsWith("$")) {
						lbl = (String) BNUtils.getFunctionVal(lbl.substring(1, lbl.length()));
					}
					comp = new BNLabel(lbl);					
				} else if (xmlComp instanceof BnCheckBox) {
					comp = new BNCheckBox(((BnCheckBox) xmlComp).getCheckBoxlabel());					
				} else if (xmlComp instanceof BnComboBox) {
					BnComboBox bnTxt = (BnComboBox) xmlComp;		

					Object[] objects = (Object[]) BNUtils.getFunctionVal(bnTxt.getLoadFunction());
					comp = new BNComboBox(objects);			
				} else if (xmlComp instanceof BnButtonBarPanel) {
					comp = makeBnButtonBarPanel((BnButtonBarPanel) xmlComp);
				} else if (xmlComp instanceof BnSeparator) {
					comp = new BNSeparator();						
				} else if (xmlComp instanceof BnScrollPane) {
					comp = new BNScrollPane();						
				} else if (xmlComp instanceof BnFileChooser) {
					comp = new BNFilePicker();						
				} else if (xmlComp instanceof BnDateAndTime) {
					comp = new BNDateAndTimePanel(new Date());
				} else if (xmlComp instanceof BnLineBreak) {
					compColonne.add(null);				
					break;
				} else if (xmlComp instanceof BnSubPanel) {
					BnSubPanel sub = (BnSubPanel) xmlComp;
					comp = new BNSubPanel(makeList(sub.getRow()), !BNUtils.nullToTrue(sub.isReadOnly()),
							BNUtils.nullToOne(sub.getWidth()), BNUtils.nullToOne(sub.getHeight()));
				}

				if (comp != null) {
					comp.setLevel(BNLevel.valueByString(xmlComp.getBnLevel()));
					comp.setCompWidth(BNUtils.nullToOne(xmlComp.getWidth()));	

					comp.setCompHeight(BNUtils.nullToOne(xmlComp.getHeight()));
					if (comp instanceof BNComponentWithValue) {

						((BNComponentWithValue) comp).setMandatory(!BNUtils.nullToTrue(xmlComp.isMandatory()));
					} 
					compColonne.add((Component) comp);		
					if (xmlComp.getParam() != null) {
						((Component) comp).setName(xmlComp.getParam());
					}
					
				}
			}
			components.add(compColonne);				
		}
		return components;
	}
/**
 * build and return a BNButtonBarPanel
 * @param bnbuttonbarpanel the BnButtonBarPanel from xml
 * @return the BNButtonBarPanel built
 */
	private BNButtonBarPanel makeBnButtonBarPanel(BnButtonBarPanel bnbuttonbarpanel) {
		// get buttons
		BNButton[] bnButtons = new BNButton[bnbuttonbarpanel.getBnButton().size()];
		int i = 0;
		for (BnButton button : bnbuttonbarpanel.getBnButton()) {

			bnButtons[i++] = (new BNButton(
					button.getText(), 					
					button.isNav(), 
					button.isCachable(), 
					button.getActionCommand(),
					BNLevel.valueByString(button.getBnLevel()),
					listener));	
		}

		BNButtonBarPanel buttonBar = new BNButtonBarPanel(bnButtons);
		buttonBar.setCompWidth(bnbuttonbarpanel.getWidth());

		return buttonBar;
	}
}
