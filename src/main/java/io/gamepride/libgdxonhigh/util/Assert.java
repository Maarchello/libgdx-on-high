package io.gamepride.libgdxonhigh.util;

/**
 * Assertion utility class that assists in validating arguments.
 * Useful for identifying programmer errors early and clearly at runtime.
 * This class is similar to JUnit's assertion library. If an argument value is
 * deemed invalid, an {@link IllegalArgumentException} is thrown (typically).
 *
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public abstract class Assert {

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(String value) {
        if (value.isEmpty() || value.trim().isEmpty()) {
            throw new IllegalArgumentException("[Assertion failed] - this argument is cannot be empty");
        }
    }

}
