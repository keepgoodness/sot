package org.sot.enums;

/**
 * Emun that represent life cicle of object. 
 * 
 * @author Jordan
 */
public enum LifeStatus {
	/**
     * EXISTING indicates that it's currently in place.
	 * <p>Represented as <b>int 0</b> in case of order. 
     */
	EXISTING,
	/**
     * RENAMED indicates that it's has received a new name in the past.
	 * <p>Represented as <b>int 1</b> in case of order.
     */
	RENAMED,
	/**
     * CLOSED indicates that it's no longer exist.
	 * <p>Represented as <b>int 2</b> in case of order.
     */
	CLOSED,
	
}
