package com.mycompany;

import com.mycompany.pages.SupplierDetailPage;
import org.apache.wicket.behavior.InvalidBehaviorIdException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		// why do BookmarkablePageLink take a type parameter?
		add(new BookmarkablePageLink<InvalidBehaviorIdException>("detailPage", SupplierDetailPage.class));
	}
}
