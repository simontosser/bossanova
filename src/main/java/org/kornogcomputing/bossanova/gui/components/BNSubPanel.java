package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;

/**
 * JPanel extension for sub-panel
 * 
 * @author herve
 * 
 */
public class BNSubPanel extends JPanel implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7003613707563122828L;
	/** component tab to display */
	private transient List<List<Component>> componentsList;
	/** component width */
	private int compwidth = 1;
	/** component height */
	private int compheight = 1;
	/** readOnly mode */
	private transient boolean readOnly;
	/** map for component */
	private Map<String, BNComponent> componentMap;
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;

	/**
	 * constructor with component array, readOnly mode and component size
	 * 
	 * @param componentsList
	 *            component array
	 * @param readOnly
	 *            readOnly mode
	 * @param compwidth
	 *            component width
	 * @param compheight
	 *            component height
	 */
	public BNSubPanel(final List<List<Component>> componentsList,
			final boolean readOnly, final int compwidth, final int compheight) {
		super(new GridBagLayout());
		this.componentsList = componentsList;
		this.readOnly = readOnly;
		this.compwidth = compwidth;
		this.compheight = compheight;
		buildFromList();
	}

	/**
	 * constructor with GridBagLayout
	 * 
	 * @param gridBagLayout
	 *            GridBagLayout
	 */
	public BNSubPanel(final GridBagLayout gridBagLayout) {
		super(gridBagLayout);
	}

	/**
	 * build the panel
	 */
	public void buildFromList() {
		final GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		
		constraint.insets = new Insets(6, 4, 0, 0);
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
						
						componentMap.putAll(((BNButtonBarPanel) comp)
								.getComponentMap());
					}
					if (comp instanceof BNComponent) {
						((BNComponent) comp).setCompListener();
						if (comp.getName() != null) {		
							
							componentMap.put(comp.getName(),
									(BNComponent) comp);
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
		
		setCompEnable(!readOnly);
	}
	@Override
	public int getCompHeight() {
		return compheight;
	}

	/**
	 * get the component height
	 * 
	 * @param comp
	 *            BNComponent in this
	 * @return component height
	 */
	private final int getComponentHeight(final Component comp) {
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

	@Override
	public int getCompWidth() {
		return compwidth;
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
	public final void setCompEnable(final boolean enable) {
		for (final Component comp : getComponents()) {
			if (comp instanceof BNComponent) {
				((BNComponent) comp).setCompEnable(enable);
			}
		}
	}

	@Override
	public void setCompListener() {
		for (final Component comp : getComponents()) {
			if (comp instanceof BNComponent) {
				((BNComponent) comp).setCompListener();
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
	public final void setComponentMap(
			final Map<String, BNComponent> componentMap) {
		this.componentMap = componentMap;
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
	 * @return the compwidth
	 */
	public final int getCompwidth() {
		return compwidth;
	}

	/**
	 * @param compwidth the compwidth to set
	 */
	public final void setCompwidth(final int compwidth) {
		this.compwidth = compwidth;
	}

	/**
	 * @return the compheight
	 */
	public final int getCompheight() {
		return compheight;
	}

	/**
	 * @param compheight the compheight to set
	 */
	public final void setCompheight(final int compheight) {
		this.compheight = compheight;
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
