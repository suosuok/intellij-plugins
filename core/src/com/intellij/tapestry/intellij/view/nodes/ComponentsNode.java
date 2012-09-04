package com.intellij.tapestry.intellij.view.nodes;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.openapi.module.Module;
import com.intellij.psi.PsiDirectory;
import com.intellij.tapestry.core.model.Library;
import icons.TapestryCoreIcons;

public class ComponentsNode extends PackageNode {

    public ComponentsNode(Library library, PsiDirectory psiDirectory, Module module, AbstractTreeBuilder treeBuilder) {
        super(library, psiDirectory, module, treeBuilder);

        init(psiDirectory, new PresentationData(psiDirectory.getName(), psiDirectory.getName(),
                                                TapestryCoreIcons.Components, null));
    }

    public ComponentsNode(PsiDirectory psiDirectory, Module module, AbstractTreeBuilder treeBuilder) {
        super(psiDirectory, module, treeBuilder);

        init(psiDirectory, new PresentationData(psiDirectory.getName(), psiDirectory.getName(),
                                                TapestryCoreIcons.Components, null));
    }
}
