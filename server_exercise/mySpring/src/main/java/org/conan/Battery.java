package org.conan;

public class Battery implements Chargeable {
    @Override
    public String getMode() {
        return "유선";
    }
}
