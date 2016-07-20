package org.kornogcomputing.bossanova.gui.components;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.kornogcomputing.bossanova.gui.BNComponent;
import org.kornogcomputing.bossanova.utils.BNLevel;

import com.jgoodies.forms.builder.ButtonBarBuilder;

/**
 * this class is made for display a horizontal panel containing buttons
 * separate by a gap
 * 
 * it take in parameter an array of BNButton to be displayed from left to right
 * 
 * while the panel is built, a list of disable/enable button is feed too for set to main panel 
 * which button have to change its enable parameter when another component value change
 * @author herve
 *
 */
public class BNButtonBarPanel extends JPanel implements BNComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6394963784849725169L;
	/** array of BNButton */
	private final transient BNButton[] buttons;
	
	/** component width */
	private int compWidth = 4;
	
	/** array of cachableButton in button bar */
	private List<BNButton> cachableButton = new ArrayList<BNButton>();
	
	/** map for component */
	private Map<String, BNComponent> componentMap;
	
	/**
	 * display level
	 */
	private BNLevel level = BNLevel.Default;
/**
 * constructor
 * @param buttons array of BNButton to build button bar
 */
	public BNButtonBarPanel(final BNButton[] buttons) {
		super();
		this.buttons = buttons.clone();
		final ButtonBarBuilder bbb = new ButtonBarBuilder();
		bbb.getPanel().setOpaque(false);
		// init component map
		componentMap = new HashMap<String, BNComponent>();
		for (final BNButton button : buttons) {
			if (button != null) {
				bbb.addFixed(button);
				bbb.addRelatedGap();
				if (button.isCachable()) {
					cachableButton.add(button);
					button.setCompEnable(false);
				}				
				if (button.getName() != null) {
					componentMap.put(button.getName(), (BNComponent) button);
				}
			}

		}
		add(bbb.getPanel());
	}
/**
 * constructor 
 * @param buttons buttons array of BNButton to build button bar
 * @param compWidth component width
 */
	public BNButtonBarPanel(final BNButton[] buttons, final int compWidth) {
		this(buttons);
		this.compWidth = compWidth;
	}
/**
 * cachableButton getter
 * @return cachableButton
 */
	public List<BNButton> getCachableButton() {
		return cachableButton;
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
	/**
	 * cachableButton setter
	 * @param cachableButton ArrayList<BNButton>
	 */
	public void setCachableButton(final List<BNButton> cachableButton) {
		this.cachableButton = cachableButton;
	}

	@Override
	public void setCompEnable(final boolean enable) {

		for (final BNButton button : buttons) {
			if (button != null) {
				button.setCompEnable(enable);
			}
		}
	}

	@Override
	public void setCompListener() {
		//
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
	/**
	 * @return the componentMap
	 */
	public Map<String, BNComponent> getComponentMap() {
		return componentMap;
	}
	/**
	 * @param componentMap the componentMap to set
	 */
	public void setComponentMap(Map<String, BNComponent> componentMap) {
		this.componentMap = componentMap;
	}
	
}
