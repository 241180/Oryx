package com.oryx.core.provider;

/**
 * Created by 241180 on 16/01/2017.
 */
public interface ITypeByTokenProvider<T> {
    public Class<T> getClassType(Target target);

    public enum Target {
        ENTITY("ENTITY_CLASS_TYPE"),
        XML_ENTITY("XML_ENTITY_CLASS_TYPE"),
        ENTITY_LIST("ENTITY_LIST_CLASS_TYPE"),
        XML_ENTITY_LIST("XML_ENTITY_LIST_CLASS_TYPE"),
        CRUD_REQUEST("CRUD_REQUEST_CLASS_TYPE"),
        CRUD_RESPONSE("CRUD_RESPONSE_CLASS_TYPE"),
        REQUEST_DESC("REQUEST_DESC_CLASS_TYPE"),
        RESPONSE_DESC("RESPONSE_DESC_CLASS_TYPE");

        private final String meaning;

        private Target(String meaning) {
            this.meaning = meaning;
        }

        public String getMeaning() {
            return meaning;
        }
    }
}
