package com.oryx.core.javajin.key;

/**
 * Created by 241180 on 08/02/2017.
 */
public interface JavaJinKeyWord extends JavaJinKeyModifier, JavaJinAccessorPrefix, JavaJinKeyType, JavaJinKeyChar {
    final String THIS = "this";

    final String EXTENDS = "extends";
    final String IMPLEMENTS = "implements";

    final String IMPORT = "import";
    final String RETURN = "return";

    final String UNKNOWN = "UNKNOWN";
}
