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
	 * @see JSONValue#toJSONString(Object, StringBuilder)
	 * 
	 * @param collection
	 * @return JSON text, or "null" if list is null.
	 */
	public static String toJSONString(Collection collection){
		int bufferSize = collection == null || collection.isEmpty() ? 4 : collection.size()*17;
		return toJSONString(collection, new StringBuilder(bufferSize)).toString();
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
			JSONValue.toJSONString(value, sb);
		}
        sb.append(']');
        return sb;
	}
	
	/** Convert an object array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(Object[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 17;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(Object[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');
	}
	
	/** Convert an integer array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(int[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 6;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(int[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');		
	}
	
	/** Convert a long array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(long[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 8;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(long[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');		
	}
	
	/** Convert a short array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(short[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 6;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(short[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');		
	}
	
	/** Convert a float array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(float[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 10;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(float[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');		
	}
	
	/** Convert a double array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(double[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 10;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(double[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');
	}	
	
	/** Convert a byte array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(byte[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 4;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}

	public static StringBuilder toJSONString(byte[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');
	}
	
	
	/** Convert a boolean array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(boolean[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 6;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(boolean[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');
	}	
	
	/** Convert a char array to JSON text.
	 * <p>patched by tomyeh
	 */
	public static String toJSONString(char[] ary) {
		int bufferSize = ary == null || ary.length == 0 ? 4 : ary.length * 2;
		return toJSONString(ary, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(char[] ary, StringBuilder sb) {
		if (ary == null)
			return sb.append("null");

		sb.append('[');
		for (int j = 0; j < ary.length; j++) {
			if (j > 0) sb.append(',');
			JSONValue.toJSONString(ary[j], sb);
		}
		return sb.append(']');		
	}
	

	/** Encodes this object to a JSON string.
	 * It is the same as {@link #toString()}.
	 */	
	public String toJSONString(){
		return toJSONString(this);
	}
	
	public StringBuilder toJSONString(StringBuilder sb) {
		return toJSONString(this, sb);
	}
	
	/** Encodes this object to a JSON string.
	 * It is the same as {@link #toJSONString()}.
	 */	
	public String toString() {
		return toJSONString(new StringBuilder(size()*17+2)).toString();
	}
}