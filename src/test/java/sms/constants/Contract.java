package sms.constants;

import lombok.Getter;

public enum Contract {
    FULL_TIME("Full Time"), TEMPORARY("Temporary"), PART_TIME("Part Time");

    @Getter
    private final String contract;

    Contract(String contract) {
        this.contract = contract;
    }
}
