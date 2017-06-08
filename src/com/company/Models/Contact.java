package com.company.Models;

/**
 * Created by pavel on 08.06.17.
 */
public class Contact {
    private ContactType type;
    private String value;

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Contact)) return false;
        if (this.type != ((Contact)o).type) return false;
        if (this.value != ((Contact)o).value) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (17 + value.hashCode() * 35) + (37 + type.hashCode() * 71);
    }
}
