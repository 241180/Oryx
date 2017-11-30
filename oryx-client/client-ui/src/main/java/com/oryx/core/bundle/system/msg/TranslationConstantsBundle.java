package com.oryx.core.bundle.system.msg;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Translation details")
public interface TranslationConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Translation")
    public String XmlTranslation();

    @DefaultStringValue("Language")
    public String language();

    @DefaultStringValue("Text")
    public String text();

    @DefaultStringValue("Translation")
    public String translation();

    @DefaultStringValue("Bundle origin")
    public String bundleOrigin();

    @DefaultStringValue("ITALIAN")
    public String ITA();

    @DefaultStringValue("ENGLISH")
    public String ENG();

    @DefaultStringValue("DEUTCH")
    public String DEU();

    @DefaultStringValue("FRENSH")
    public String FRA();

    @DefaultStringValue("SPANISH")
    public String SPA();

    @DefaultStringValue("ARABIC")
    public String ARA();
}
