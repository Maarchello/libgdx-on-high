package io.gamepride.libgdxonhigh.screen;

import com.badlogic.gdx.Screen;
import java.util.Objects;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class ScreenType {

    private String name;
    private Class<? extends Screen> clazz;

    public ScreenType(String name, Class<? extends Screen> clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public Class<? extends Screen> getClazz() {
        return clazz;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScreenType that = (ScreenType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
