/* BindRowRenderer.java

	Purpose:
		
	Description:
		
	History:
		Aug 16, 2011 10:34:50 AM, Created by henrichen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.bind.impl;

import org.zkoss.bind.IterationStatus;
import org.zkoss.lang.Objects;
import org.zkoss.xel.VariableResolverX;
import org.zkoss.xel.XelContext;
import org.zkoss.xel.XelException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.util.Template;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Rows;

/**
 * Row renderer for binding.
 * @author henrichen
 * @since 6.0.0
 */
public class BindRowRenderer extends AbstractRenderer implements RowRenderer<Object> {
	private static final long serialVersionUID = 1463169907348730644L;
	public void render(final Row row, final Object data, final int index) {
		final Rows rows = (Rows)row.getParent();
		final Grid grid = (Grid)rows.getParent();
		final Template tm = resoloveTemplate(grid,row,data,index,"model");
		if (tm == null) {
			final Label label = newRenderLabel(Objects.toString(data));
			label.applyProperties();
			label.setParent(row);
			row.setValue(data);
		} else {
			final IterationStatus iterStatus = new AbstractIterationStatus(){//provide iteration status in this context
				private static final long serialVersionUID = 1L;
				@Override
				public int getIndex() {
					return index;
				}
			};
			
			final String var = (String) tm.getParameters().get(EACH_ATTR);
			final String varnm = var == null ? EACH_VAR : var; //var is not specified, default to "each"
			final String itervar = (String) tm.getParameters().get(STATUS_ATTR);
			final String itervarnm = itervar == null ? varnm+STATUS_POST_VAR : itervar; //provide default value if not specified
			
			final Component[] items = tm.create(rows, row,
				new VariableResolverX() {//this resolver is for EL ${} not for binding 
					public Object resolveVariable(String name) {
						//shall never call here
						return varnm.equals(name) ? data : null;
					}

					public Object resolveVariable(XelContext ctx, Object base, Object name) throws XelException {
						if (base == null) {
							if(varnm.equals(name)){
								return data;
							}else if(itervarnm.equals(name)){//iteration status
								return iterStatus;
							}
						}
						return null;
					}
				}, null);
			if (items.length != 1)
				throw new UiException("The model template must have exactly one row, not "+items.length);

			final Row nr = (Row)items[0];
			nr.setAttribute(BinderImpl.VAR, varnm);
			addItemReference(nr, index, varnm); //kept the reference to the data, before ON_BIND_INIT
			
			nr.setAttribute(itervarnm, iterStatus);
			
			//add template dependency
			addTemplateTracking(grid, nr, data, index);
			
			if (nr.getValue() == null) //template might set it
				nr.setValue(data);
			row.setAttribute("org.zkoss.zul.model.renderAs", nr);
				//indicate a new row is created to replace the existent one
			row.detach();
		}
	}
	
	/** Returns the label for the cell generated by the default renderer.
	 */
	private static Label newRenderLabel(String value) {
		final Label label =
			new Label(value != null && value.length() > 0 ? value: " ");
		label.setPre(true); //to make sure &nbsp; is generated, and then occupies some space
		return label;
	}
}
