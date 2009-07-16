package com.intellij.tapestry.intellij.lang.descriptor;

import com.intellij.psi.PsiElement;
import com.intellij.psi.meta.PsiWritableMetaData;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlTag;
import com.intellij.tapestry.core.model.presentation.Component;
import com.intellij.tapestry.core.model.presentation.PresentationLibraryElement;
import com.intellij.tapestry.intellij.core.java.IntellijJavaClassType;
import com.intellij.util.IncorrectOperationException;
import com.intellij.xml.XmlAttributeDescriptor;
import com.intellij.xml.XmlElementDescriptor;
import com.intellij.xml.XmlNSDescriptor;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Alexey Chmutov
 *         Date: Jun 10, 2009
 *         Time: 3:56:33 PM
 */
public class TapestryTagDescriptor implements XmlElementDescriptor, PsiWritableMetaData {
  private final PresentationLibraryElement myComponent;
  private final String myNamespacePrefix;

  public TapestryTagDescriptor(@NotNull PresentationLibraryElement component, @Nullable String namespacePrefix) {
    myComponent = component;
    myNamespacePrefix = namespacePrefix;
  }

  public String getQualifiedName() {
    return getDefaultName();
  }

  public String getDefaultName() {
    String name = myComponent.getName().toLowerCase();
    if (myNamespacePrefix != null && myNamespacePrefix.length() > 0) name = myNamespacePrefix + ":" + name;
    return name;
  }

  public XmlElementDescriptor[] getElementsDescriptors(XmlTag context) {
    XmlElementDescriptor htmlDescriptor = findHtmlDescriptorOfParent(context);
    // todo
    return DescriptorUtil.getElementDescriptors(context);
  }

  private XmlElementDescriptor findHtmlDescriptorOfParent(XmlTag context) {
    return null;  //To change body of created methods use File | Settings | File Templates.
  }

  public XmlElementDescriptor getElementDescriptor(XmlTag childTag, XmlTag contextTag) {
    return DescriptorUtil.getDescriptor(childTag);
  }

  public XmlAttributeDescriptor[] getAttributesDescriptors(@Nullable XmlTag context) {
    return context != null
           ? DescriptorUtil.getAttributeDescriptors(context)
           : DescriptorUtil.getAttributeDescriptors((Component)myComponent);
  }

  public XmlAttributeDescriptor getAttributeDescriptor(@NonNls String attributeName, @Nullable XmlTag context) {
    return context != null
           ? DescriptorUtil.getAttributeDescriptor(attributeName, context)
           : DescriptorUtil.getAttributeDescriptor(attributeName, (Component)myComponent);
  }

  public XmlAttributeDescriptor getAttributeDescriptor(XmlAttribute attribute) {
    return DescriptorUtil.getAttributeDescriptor(attribute.getLocalName(), attribute.getParent());
  }

  public XmlNSDescriptor getNSDescriptor() {
    return TapestryNamespaceDescriptor.INSTANCE;
  }

  public int getContentType() {
    return CONTENT_TYPE_ANY;
  }

  public PsiElement getDeclaration() {
    return ((IntellijJavaClassType)myComponent.getElementClass()).getPsiClass();
  }

  public String getName(PsiElement context) {
    return getDefaultName();
  }

  public String getName() {
    return getDefaultName();
  }

  public void init(PsiElement element) {
  }

  public Object[] getDependences() {
    return new Object[0];
  }

  public void setName(String name) throws IncorrectOperationException {
    //To change body of implemented methods use File | Settings | File Templates.
  }

}
