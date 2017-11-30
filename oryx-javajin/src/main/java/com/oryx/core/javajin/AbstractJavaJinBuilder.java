package com.oryx.core.javajin;

import com.oryx.core.javajin.enums.EnumJinModifier;
import com.oryx.core.javajin.key.JavaJinKeyWord;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 241180 on 10/02/2017.
 */
public abstract class AbstractJavaJinBuilder<E> {
    final static Logger logger = Logger.getLogger(AbstractJavaJinBuilder.class);
    protected String name;
    protected List<EnumJinModifier> modifiers = new ArrayList<>();

    public String getName() {
        return name;
    }

    protected void beginOfBlock(StringBuffer buffer, Integer tabCount) {
        for (int count = 0; count < tabCount; count++)
            buffer.append(JavaJinKeyWord.TAB);

        buffer.append(JavaJinKeyWord.BOB)
                .append(JavaJinKeyWord.EOL);
    }

    protected void endOfBlock(StringBuffer buffer, Integer tabCount) {
        buffer.append(JavaJinKeyWord.EOL);

        for (int count = 0; count < tabCount; count++)
            buffer.append(JavaJinKeyWord.TAB);

        buffer.append(JavaJinKeyWord.EOB)
                .append(JavaJinKeyWord.EOL);
    }

    protected void beginOfBlock(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.BOB)
                .append(JavaJinKeyWord.EOL);
    }

    protected void endOfBlock(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.EOL)
                .append(JavaJinKeyWord.EOB)
                .append(JavaJinKeyWord.EOL);
    }

    protected void beginOfArgs(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.BOA);
    }

    protected void endOfArgs(StringBuffer buffer) {
        buffer.append(JavaJinKeyWord.EOA);
    }

    protected void saveTypeModifiers(StringBuffer buffer) {
        for (EnumJinModifier enumJinModifier : this.modifiers) {
            switch (enumJinModifier) {
                case ABSTRACT:
                    buffer.append(JavaJinKeyWord.ABSTRACT);
                    break;
                case PUBLIC:
                    buffer.append(JavaJinKeyWord.PUBLIC);
                    break;
                case PRIVATE:
                    buffer.append(JavaJinKeyWord.PRIVATE);
                    break;
                case PROTECTED:
                    buffer.append(JavaJinKeyWord.PROTECTED);
                    break;
                case STATIC:
                    buffer.append(JavaJinKeyWord.STATIC);
                    break;
                case FINAL:
                    buffer.append(JavaJinKeyWord.FINAL);
                    break;
            }
            buffer.append(JavaJinKeyWord.SPACE);
        }
    }

    protected StringBuffer genReturnInstruction(JinFieldBuilder jinFieldBuilder) {
        return new StringBuffer()
                .append(JavaJinKeyWord.RETURN)
                .append(JavaJinKeyWord.SPACE)
                .append(JavaJinKeyWord.THIS)
                .append(JavaJinKeyWord.PNT)
                .append(jinFieldBuilder.getName())
                .append(JavaJinKeyWord.EOI);
    }

    protected StringBuffer genAffectationInstruction(JinFieldBuilder jinFieldBuilder) {
        return new StringBuffer()
                .append(JavaJinKeyWord.THIS)
                .append(JavaJinKeyWord.PNT)
                .append(jinFieldBuilder.getName())
                .append(JavaJinKeyWord.SPACE)
                .append(JavaJinKeyWord.EQ)
                .append(JavaJinKeyWord.SPACE)
                .append(jinFieldBuilder.getName())
                .append(JavaJinKeyWord.EOI);
    }
}
