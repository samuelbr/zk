/*
 * $Id: JSONObject.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package org.zkoss.json;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A JSON object. Key value pairs are in the order of adding.
 * JSONObject supports java.util.Map interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public class JSONObject extends LinkedHashMap<Object, Object> implements Map<Object, Object>, JSONAware {
	private static final long serialVersionUID = -503443796854799292L;
	
	/**
	 * Convert (aka., encode) a map to JSON text. The result is a JSON object. 
	 * If this map is also a JSONAware, JSONAware specific behaviors will be omitted at this top level.
	 * 
	 * @see JSONValue#toJSONString(Object)
	 * 
	 * @param map
	 * @return JSON text, or "null" if map is null.
	 */
	public static String toJSONString(Map map){
		int bufferSize = map == null || map.isEmpty() ? 4 : map.size()*32;
		return toJSONString(map, new StringBuilder(bufferSize)).toString();
	}
	
	public static StringBuilder toJSONString(Map map, StringBuilder sb){
		if(map == null)
			return sb.append("null");
		
        boolean first = true;
		Iterator iter=map.entrySet().iterator();
		
        sb.append('{');
		while(iter.hasNext()){
            if(first)
                first = false;
            else
                sb.append(',');
            
			Map.Entry entry=(Map.Entry)iter.next();
			toJSONString(String.valueOf(entry.getKey()),entry.getValue(), sb);
		}
        sb.append('}');
		return sb;
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
	
	private static String toJSONString(String key,Object value, StringBuilder sb){
		sb.append('\"');
        if(key == null)
            sb.append("null");
        else
            JSONValue.escape(key, sb);
		sb.append('\"').append(':');
		
		sb.append(JSONValue.toJSONString(value));
		
		return sb.toString();
	}

	/** Encodes this object to a JSON string.
	 * It is the same as {@link #toJSONString()}.
	 */	
	public String toString(){
		return toJSONString();
	}

	public static String toString(String key,Object value){
		StringBuilder sb = new StringBuilder();
		toJSONString(key, value, sb);
        return sb.toString();
	}
}
