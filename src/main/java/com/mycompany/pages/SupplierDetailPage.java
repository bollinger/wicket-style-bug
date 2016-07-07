package com.mycompany.pages;

import com.mycompany.controls.StatusLabel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  Initial render: <head></head> does not contain a link to status.css
 *  Press the button: <head></head> contains incorrect link.                <link type="null" href="status.css" rel="stylesheet" id="null">
 *  Press F5 force full page refresh: <head></head> contains correct link.  <link href="status.css" rel="stylesheet">
 *
 *
 * Created by peter on 07/07/16.
 */
public class SupplierDetailPage extends WebPage {

  Model<Boolean> showStatus = Model.of(false);

  Model<ArrayList<String>> rowsModel = new Model(new ArrayList(Arrays.asList("apple","orange","grape")));


  protected void onInitialize() {
    super.onInitialize();


    final WebMarkupContainer tableWMC = new WebMarkupContainer("tableWMC");
    tableWMC.setOutputMarkupId(true);
    this.add(tableWMC);


    AjaxLink button = new AjaxLink("btn") {
      public void onClick(AjaxRequestTarget art) {
        showStatus.setObject( !showStatus.getObject() );
        art.add(tableWMC);
      }
    };
    this.add(button);



    ListView<String> list = new ListView<String>("row", rowsModel) {
      protected void populateItem(ListItem<String> li) {
        String str = li.getModelObject();


        li.add(new Label("name", str));

        li.add(new StatusLabel("status") {
          protected void onConfigure() {
            super.onConfigure();
            setVisible(showStatus.getObject());
          }
        });

      }
    };
    tableWMC.add(list);
  }
}
