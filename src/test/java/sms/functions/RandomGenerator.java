package sms.functions;

import java.util.UUID;

public class RandomGenerator {
    public static String generateRandomUuidString() {
        return UUID.randomUUID().toString();
    }
}
