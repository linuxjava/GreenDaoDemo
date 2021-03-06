package com.guochang.greendaodemo.db.entity;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table app_property.
 */
public class AppProperty {

    /** Not-null value. */
    private String propertyKey;
    private String propertyValue;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public AppProperty() {
    }

    public AppProperty(String propertyKey, String propertyValue) {
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
    }

    /** Not-null value. */
    public String getPropertyKey() {
        return propertyKey;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
