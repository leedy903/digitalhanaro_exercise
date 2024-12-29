package org.conan.mysecurity.constant;

import jakarta.persistence.ElementCollection;

public enum SubscriberRole {
    @ElementCollection
    USER, MANAGER, ADMIN;
}
