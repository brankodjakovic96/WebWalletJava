package com.webwallet.common.utils.generators;

import org.apache.commons.text.RandomStringGenerator;

public class
PasswordGenerator {
    public static String GeneratePassword(int length) {
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange('0', '9')
                .build();
        return pwdGenerator.generate(length);
    }
}
