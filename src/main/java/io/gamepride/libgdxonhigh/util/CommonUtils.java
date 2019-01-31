package io.gamepride.libgdxonhigh.util;

import com.badlogic.gdx.utils.Array;
import java.util.Random;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public final class CommonUtils {

    private static final Random random = new Random();

    public static <T> Array<T> arrayOf(T... t) {
        Array<T> list = new Array<>();

        for (T elem : t) {
            list.add(elem);
        }

        return list;
    }

    public static int randomIntBetween(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max argument must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }

    public static int randomInt(int range) {
        return random.nextInt(range);
    }

}
