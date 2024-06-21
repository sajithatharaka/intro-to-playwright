package sms.constants;

import lombok.Getter;

public enum Gender {
    MALE("male"), FEMALE("female"), OTHER("other");

    @Getter
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
