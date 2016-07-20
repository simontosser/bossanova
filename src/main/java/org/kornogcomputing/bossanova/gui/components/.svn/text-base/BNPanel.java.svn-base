package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import org.kornogcomputing.bossanova.exception.NoComponentNameException;
import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.gui.BNComponentWithValue;
import org.kornogcomputing.bossanova.utils.BNLevel;
import org.kornogcomputing.bossanova.utils.BNStatic;
import org.kornogcomputing.bossanova.utils.BNUtils;
import org.kornogcomputing.bossanova.xml.BnFileChooser;

/**
 * JPanel extension for Iktus
 * 
 * @author herve
 * 
 */
public class BNPanel extends JPanel implements BNComponent, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4708800345934308856L;
	/** list of cachable button */
	private List<BNButton> cachableButtons = new ArrayList<BNButton>();
	/** Panel title */
	private transient String title;
	/** readOnly mode */
	private boolean readOnly;
	/** validation flag */
	private boolean canValidate = false;

	/** component tab to display */
	private transient List<List<Component>> componentsList;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;

	/** map for component */
	private Map<String, BNComponent> componentMap;
	/**
	 * the bean class displayed in this panel
	 */
	private String beanClass;
	/**
	 * Action list on this
	 */
	protected List<ActionListener> listeners = new ArrayList<ActionListener>();


	/**
	 * Constructor
	 * 
	 * @param componentsList
	 *            Component[][] first array for column, second for row
	 * @param title
	 *            panel title
	 * @param readOnly
	 *            readOnly mode
	 * @param level the display level to set
	 * @param beanClass the bean class displayed in this panel
	 * @throws NoComponentNameException 
	 * 
	 */
	public BNPanel(final List<List<Component>> componentsList, final String title,
			final boolean readOnly, final BNLevel level, final String beanClass) throws NoComponentNameException {
		super(new GridBagLayout());
		this.componentsList = componentsList;
		this.title = title;
		this.readOnly = readOnly;
		this.level = level;
		this.beanClass = beanClass;
		setOpaque(true);
		buildFromList();
	}


	/**
	 * constructor with GridBagLayout
	 * 
	 * @param gridBagLayout
	 *            GridBagLayout
	 */
	public BNPanel(final GridBagLayout gridBagLayout) {
		super(gridBagLayout);
	}
	/**
	 * minimal contructor
	 */
	public BNPanel() {
		super();
	}
	
	/**
	 * add action listener to this
	 * @param l the ActionListener to add
	 */
	public void addActionListener(final ActionListener l) {
		listeners.add(l);
	}
	
	/**
	 * notify listener that action event happened
	 * @param e the action event to notify
	 */
	public void notifyListeners(final ActionEvent e) {
		for (final ActionListener l : listeners) {
			l.actionPerformed(e);
		}
	}
	/**
	 * build the panel
	 * @throws NoComponentNameException 
	 */
	public void buildFromList() throws NoComponentNameException {
		final GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		if (title != null) {
			constraint.gridx = 0;
			constraint.gridy = 0;
			constraint.gridwidth = 4;
			final JLabel labelInfo = new JLabel(title);
			labelInfo.setForeground(BNStatic.SPECIALBLUE);
			add(labelInfo, constraint);
			constraint.gridy = 1;
			constraint.gridwidth = 4;
			add(new JSeparator(), constraint);
		}
		constraint.insets = new Insets(6, 4, 0, 0);
		cachableButtons.clear();
		// init component map
		componentMap = new HashMap<String, BNComponent>();
		int x = 2;
		for (List<Component> list : componentsList) {
			constraint.gridy = x;
			constraint.gridx = 0;
			int maxHeight = 1;
			for (final Component comp : list) {
				if (comp == null)  {
					constraint.gridx++;
				} else {					
					constraint.gridwidth = getComponentWidth(comp);
					constraint.gridheight = getComponentHeight(comp);
					maxHeight = Math.max(maxHeight, constraint.gridheight);
					add(comp, constraint);
					// if comp is cachable button, add to arraylist
					if (comp instanceof BNButtonBarPanel) {
						cachableButtons.addAll(((BNButtonBarPanel) comp)
								.getCachableButton());
						componentMap.putAll(((BNButtonBarPanel) comp)
								.getComponentMap());
					}
					if (comp instanceof BNComponent) {
						((BNComponent) comp).setCompListener();
						if (comp.getName() != null) {		

							componentMap.put(comp.getName(),
									(BNComponent) comp);
						} else if (comp instanceof BNComponentWithValue 
								&& !(comp instanceof BNLabel)) {
							throw new NoComponentNameException("no param tag defined for the component " + comp.getClass());
						}
					}
					if (comp instanceof BNPanel) {
						componentMap.putAll(((BNPanel) comp)
								.getComponentMap());
					}

					if (comp instanceof BNScrollPane) {
						addComponentListener(new ComponentAdapter() {
							@Override
							public void componentResized(
									final ComponentEvent event) {
								((BNScrollPane) comp).resizeTable();
							}
						});
					}
					constraint.gridx += constraint.gridwidth;
				} 

			}
			x += maxHeight;
		}
		levelling();
		setCompEnable(!readOnly);
	}

	/**
	 * get the component height
	 * 
	 * @param comp
	 *            BNComponent in this
	 * @return component height
	 */
	private int getComponentHeight(final Component comp) {
		if (comp instanceof BNComponent) {
			return ((BNComponent) comp).getCompHeight();
		}
		return 1;
	}

	/**
	 * get the component width
	 * 
	 * @param comp
	 *            BNComponent in this
	 * @return component width
	 */
	private int getComponentWidth(final Component comp) {
		if (comp instanceof BNComponent) {
			return ((BNComponent) comp).getCompWidth();
		}
		if (comp instanceof JPanel) {
			return 2;
		}
		return 1;
	}

	/**
	 * canValidate getter
	 * 
	 * @return canValidate
	 */
	public boolean isCanValidate() {
		return canValidate;
	}

	/**
	 * set the cachable button (defined in BNButton), enabled or not
	 * 
	 * @param visible
	 *            boolean
	 */
	public void makeCachableButtonVisible(final boolean visible) {		
		if ((!cachableButtons.isEmpty()) && !readOnly) {
			for (final BNButton button : cachableButtons) {
				button.setCompEnable(visible);
			}
			canValidate = visible;
		}
	}

	/**
	 * canValidate setter
	 * 
	 * @param canValidate
	 *            boolean
	 */
	public void setCanValidate(final boolean canValidate) {
		this.canValidate = canValidate;
	}

	/**
	 * set the component in this panel enabled or not
	 * 
	 * @param enable
	 *            boolean
	 */
	@Override
	public final void setCompEnable(final boolean enable) {
		for (final Component comp : getComponents()) {
			if (comp instanceof BNComponent) {
				((BNComponent) comp).setCompEnable(enable);
			}
		}
	}

	/**
	 * make norway component appear or disappear according to the application
	 * mode
	 */
	public final void levelling() {

		for (final BNComponent comp : componentMap.values()) {
			((Component) comp)
			.setVisible(comp.getLevel().getLevelValue() <= level
			.getLevelValue());

		}
		for (final Component comp : getComponents()) {
			if (comp instanceof BNComponent) {
				if (comp instanceof BNAsteroMark) {
					if (!((BNAsteroMark) comp).isExclusive()
							&& ((BNAsteroMark) comp).getLevel().getLevelValue() == level
							.getLevelValue()) {
						((BNAsteroMark) comp).removeMark();
					} else if (((BNAsteroMark) comp).getLevel().getLevelValue() <= level
							.getLevelValue()) {
						((BNAsteroMark) comp).addMark();
					}
				}
				comp.setVisible(((BNComponent) comp).getLevel().getLevelValue() <= level
						.getLevelValue());

			}
		}

	}

	/**
	 * @return the componentMap
	 */
	public final Map<String, BNComponent> getComponentMap() {
		return componentMap;
	}

	/**
	 * @param componentMap
	 *            the componentMap to set
	 */
	public void setComponentMap(final Map<String, BNComponent> componentMap) {
		this.componentMap = componentMap;
	}
	/**
	 * get a specific component value defined by its key
	 * @param key the key in componentMap
	 * @return the comp value
	 */
	public Object getComponentValue(String key) {
		if (componentMap.containsKey(key) && componentMap.get(key) instanceof BNComponentWithValue) {
			return ((BNComponentWithValue) componentMap.get(key)).getCompValue();
		}
		return null;
	}
	@Override
	public final int getCompHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final int getCompWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final BNPanel getParentPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void setCompListener() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the level
	 */
	@Override
	public final BNLevel getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	@Override
	public final void setLevel(final BNLevel level) {
		this.level = level;
	}

	/**
	 * @return the cachableButtons
	 */
	public final List<BNButton> getCachableButtons() {
		return cachableButtons;
	}

	/**
	 * @param cachableButtons
	 *            the cachableButtons to set
	 */
	public final void setCachableButtons(final List<BNButton> cachableButtons) {
		this.cachableButtons = cachableButtons;
	}

	/**
	 * @return the readOnly
	 */
	public final boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly
	 *            the readOnly to set
	 */
	public final void setReadOnly(final boolean readOnly) {
		this.readOnly = readOnly;
	}
	@Override
	public void setCompWidth(int width) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setCompHeight(int height) {
		// TODO Auto-generated method stub

	}
	

	/**
	 * use bean's setter and component values to build object and return it
	 * @return object built
	 */
	public Object presentationToModel() {
		@SuppressWarnings("rawtypes")
		Class clazz; 
		Object object;
		try {
			clazz = Class.forName(getBeanClass());
			object = clazz.newInstance();
			Method method = null;


			for (String field : getComponentMap().keySet()) {			
				method = BNUtils.getSetter(clazz, field);
				if (getComponentMap().get(field) instanceof BNComponentWithValue
						&& !(getComponentMap().get(field) instanceof BNFilePicker)) {			
					try {
						System.out.println("field " + field + " method " + method.getName());
						method.invoke(object, ((BNComponentWithValue) getComponentMap().get(field)).getCompValue());
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} 
				}
			}
			return object;

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * use bean getter to display value in components
	 * @param object the bean to display
	 */
	public void modelToPresentation(Object object) {
		Method method = null;
		for (String field : getComponentMap().keySet()) {			
			try {				
				method = BNUtils.getGetter(object.getClass(), field);				
				if (getComponentMap().get(field) instanceof BNComponentWithValue
						 && !(getComponentMap().get(field) instanceof BNFilePicker)) {
					((BNComponentWithValue) getComponentMap().get(field)).setCompValue(method.invoke(object, new Object[0]));
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * get if all mandatory components in this panel are valid
	 * @return true if all components are valid
	 */
	public boolean isValidable() {
		for (BNComponent comp : getComponentMap().values()) {				
			if (comp instanceof BNComponentWithValue) {
				if (((BNComponentWithValue) comp).isMandatory() 
						&& !((BNComponentWithValue) comp).isCompValid()) {
					return false;
				}
			}

		}
		return true;
	}


	/**
	 * @return the beanClass
	 */
	public String getBeanClass() {
		return beanClass;
	}


	/**
	 * @param beanClass the beanClass to set
	 */
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		notifyListeners(e);
		
	}
}
