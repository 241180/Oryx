package com.oryx.core.javajin;

import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 08/02/2017.
 */
public class JinConstructorBuilder extends AbstractJinMethodBuilder {
    private JinTypeBuilder parent;
    private List<JinFieldBuilder> inputArgs = new ArrayList<>();

    public JinConstructorBuilder(JinTypeBuilder parent) {
        this.parent = parent;
    }

    public JinConstructorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public JinConstructorBuilder addArguemnt(JinFieldBuilder arg) {
        this.inputArgs.add(arg);
        return this;
    }

    @Override
    public AbstractJinMethodBuilder addArguemnts(List args) {
        this.inputArgs.addAll(args);
        return this;
    }

    public JinConstructorBuilder addModifier(EnumJinModifier modifier) {
        modifiers.add(modifier);
        return this;
    }

    public void save(StringBuffer buffer, List<String> importPackages) {
        buffer.append(JavaJinKeyWord.EOL)
                .append(JavaJinKeyWord.TAB)
                .append(JavaJinKeyWord.PUBLIC)
                .append(JavaJinKeyWord.SPACE)
                .append(parent.getName());

        beginOfArgs(buffer);

        //Method Args
        saveInputArgs(buffer, importPackages);

        endOfArgs(buffer);

        beginOfBlock(buffer);

        endOfBlock(buffer, 1);
    }
}
