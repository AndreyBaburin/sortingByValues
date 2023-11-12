package com.andrey_baburin.domain;

import java.util.Objects;

public class Value {

    private String incomingValue;

    public Value(String incomingValue) {
        this.incomingValue = incomingValue;
    }

    public String getIncomingValue() {
        return incomingValue;
    }

    public void setIncomingValue(String incomingValue) {
        this.incomingValue = incomingValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return Objects.equals(incomingValue, value.incomingValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incomingValue);
    }
}
