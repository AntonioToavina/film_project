package com.antonio.spring_mvc.Service;


    public class FieldUtil {
        String fieldName;
        Object value;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public FieldUtil() {
        }

        public FieldUtil(String fieldName, Object value) {
            setFieldName(fieldName);
            setValue(value);

        }


    }

