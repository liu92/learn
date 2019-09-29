package org.learn.boot.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义 明文的加密方式
 * @ClassName: CustomerPasswordEncoder
 * @Description:
 * @Author: lin
 * @Date: 2019/9/28 9:11
 * History:
 * @<version> 1.0
 */
public class CustomerPasswordEncoder implements PasswordEncoder{
    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
