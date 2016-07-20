/**
 * 
 */
package org.kornogcomputing.bossanova.utils;

/**
 * 
 * @author herve
 *
 */
public enum BNLevel {
	Level0(0),
	Level1(1),
	Level2(2),
	Default(0);
	
	/**
	 * level value
	 */
	private Integer levelValue;

	/**
	 * @param levelValue the level value to set
	 */
	private BNLevel(Integer levelValue) {
		this.levelValue = levelValue;
	}

	/**
	 * @return the levelValue
	 */
	public final Integer getLevelValue() {
		return levelValue;
	}

	/**
	 * @param levelValue the levelValue to set
	 */
	public final void setLevelValue(Integer levelValue) {
		this.levelValue = levelValue;
	}
	/**
	 * get the enum value for the level value in parameter
	 * @param levelValue the searched level value
	 * @return BNLevel
	 */
	public BNLevel valueByLevelValue(Integer levelValue) {
		for (BNLevel bnLevel : values()) {
			if (levelValue == bnLevel.getLevelValue()) {
				return bnLevel;
			}
		}
		return Default;
	}
	/**
	 * get the enum value for the level value in parameter
	 * @param bnlevel the searched level value
	 * @return BNLevel
	 */
	public static BNLevel valueByString(String bnlevel) {
		if (bnlevel == null) {
			return Default;
		}
		for (BNLevel bnLevel : values()) {			
			if (Integer.valueOf(bnlevel) == bnLevel.getLevelValue()) {
				return bnLevel;
			}
		}
		return Default;
	}
	
}
