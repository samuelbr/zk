/*
 * $Id: JSONArray.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package org.zkoss.json;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * A JSON array. JSONObject supports java.util.List interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public class JSONArray extends LinkedList<Object> implements List<Object>, JSONAware {
	private static final long serialVersionUID = 3957988303675231981L;

	/**
	 * Convert a list to JSON text. The result is a JSON array. 
	 * If this list is also a JSONAware, JSONAware specific behaviors will be omitted at this top level.
	 * 
	 * @see JSONValue#toJSONString(Object)
	 * 
	 * @param collection
	 * @return JSON text, or "null" if list is null.
	 */
	public static String toJSONString(Collection collection){
		return toJSONString(collection, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(Collection collection, StringBuilder sb){
		if(collection == null)
			return sb.append("null");
		
        boolean first = true;
		Iterator iter=collection.iterator();
        
        sb.append('[');
		while(iter.hasNext()){
            if(first)
                first = false;
            else
                sb.append(',');
            
			Object value=iter.next();
			if(value == null){
				sb.append("null");
				continue;
			}
			sb.append(JSONValue.toJSONString(value));
		}
        sb.append(']');
        return sb;
	}
	
	/** Convert an object array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(Object[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(Object[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');
	}
	
	/** Convert an integer array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(int[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(int[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');		
	}
	
	/** Convert a long array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(long[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(long[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');		
	}
	
	/** Convert a short array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(short[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(short[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');		
	}
	
	/** Convert a float array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(float[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(float[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');		
	}
	
	/** Convert a double array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(double[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(double[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');
	}	
	
	/** Convert a byte array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(byte[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}

	public static StringBuilder toJSONString(byte[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');
	}
	
	
	/** Convert a boolean array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(boolean[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(boolean[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');
	}	
	
	/** Convert a char array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(char[] ary) {
		return toJSONString(ary, new StringBuilder()).toString();
	}
	
	public static StringBuilder toJSONString(char[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			sb.append(JSONValue.toJSONString(ary[j]));
		}
		return sb.append(']');		
	}
	

	/** Encodes this object to a JSON string.
	 * It is the same as {@link #toString()}.
	 */	
	public String toJSONString(){
		return toJSONString(this);
	}
	
	public void toJSONString(StringBuilder sb) {
		// TODO Auto-generated method stub
	}
	
	/** Encodes this object to a JSON string.
	 * It is the same as {@link #toJSONString()}.
	 */	
	public String toString() {
		return toJSONString();
	}
}