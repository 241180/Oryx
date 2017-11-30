package com.oryx.core.javajin;

import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.key.JavaJinKeyWord;

import java.util.List;

/**
 * Created by 241180 on 08/02/2017.
 */
public class JinMethodBuilder extends AbstractJinMethodBuilder<JinMethodBuilder> {
    private Object returnType;
    private StringBuffer code = new StringBuffer();

    public JinMethodBuilder() {
        super();
    }

    public JinMethodBuilder(List<EnumJinModifier> modifiers, JinGenericType returnType, String name, List<JinFieldBuilder> inputArgs) {
        this.modifiers = modifiers;
        this.returnType = returnType;
        this.name = name;
        this.inputArgs = inputArgs;
    }

    public JinMethodBuilder setReturnType(JinGenericType returnType) {
        this.returnType = returnType;
        return this;
    }

    public JinMethodBuilder setReturnType(String returnTypeStr) {
        this.returnType = returnTypeStr;
        return this;
    }

    @Override
    public JinMethodBuilder addArguemnt(JinFieldBuilder arg) {
        this.inputArgs.add(arg);
        return this;
    }

    @Override
    public JinMethodBuilder addArguemnts(List args) {
        this.inputArgs.addAll(args);
        return this;
    }

    public JinMethodBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public JinMethodBuilder addModifier(EnumJinModifier modifier) {
        modifiers.add(modifier);
        return this;
    }

    public StringBuffer getCode() {
        return code;
    }

    public void save(StringBuffer buffer, List<String> importPackages, boolean headerOnly) {
        buffer.append(JavaJinKeyWord.TAB);

        saveTypeModifiers(buffer);

        if (returnType instanceof JinGenericType) {
            ((JinGenericType) returnType).save(buffer, importPackages);

            if (((JinGenericType) returnType).getGenericType() instanceof Class) {
                if (((Class) ((JinGenericType) returnType).getGenericType()).getPackage() != null)
                    importPackages.add(((Class) ((JinGenericType) returnType).getGenericType()).getPackage().getName());
            }
        } else if (returnType instanceof String) {
            buffer.append((String) returnType.toString())
                    .append(JavaJinKeyWord.SPACE);
        }

        buffer.append(name);

        beginOfArgs(buffer);

        //Method Args
        saveInputArgs(buffer, importPackages);

        endOfArgs(buffer);

        if (!headerOnly) {
            beginOfBlock(buffer);

            buffer.append(this.code);

            endOfBlock(buffer, 1);
        } else
            buffer.append(JavaJinKeyWord.EOI)
                    .append(JavaJinKeyWord.EOL);
    }
}
