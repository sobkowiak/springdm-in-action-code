package com.manning.sdmia.wicket.pages;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.IModel;

public class OddEvenListItem extends ListItem {
	private static final String CLASS_ODD = "odd";
	private static final String CLASS_EVEN = "even";

	public OddEvenListItem(int index, IModel model)	{
		super(index, model);
	}

	protected void onComponentTag(ComponentTag tag)	{
		super.onComponentTag(tag);
		tag.put("class", (getIndex() % 2 == 0) ? CLASS_EVEN : CLASS_ODD);
	}
}
