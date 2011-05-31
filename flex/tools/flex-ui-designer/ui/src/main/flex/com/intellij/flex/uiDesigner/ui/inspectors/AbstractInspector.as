package com.intellij.flex.uiDesigner.ui.inspectors {
import cocoa.FlexDataGroup;
import cocoa.Panel;

import org.flyti.plexus.Injectable;

public class AbstractInspector extends Panel implements Injectable {
  public var list:FlexDataGroup;

  override protected function skinAttached():void {
    super.skinAttached();

    list.laf = laf;
  }
}
}
