package com.mycompany.controls;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * Created by peter on 07/07/16.
 */
public class StatusLabel extends Panel {

  public StatusLabel(String id) {
    super(id);
  }


  public void onInitialize() {
    super.onInitialize();

    Label label = new Label("label", "STATUS HERE");
    this.add(label);

    label.add(AttributeModifier.append("class", Model.of("RED") ) );
  }
}
