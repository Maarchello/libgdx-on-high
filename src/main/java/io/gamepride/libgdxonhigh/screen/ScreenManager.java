package io.gamepride.libgdxonhigh.screen;

import com.badlogic.gdx.Screen;
import io.gamepride.libgdxonhigh.core.Root;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class ScreenManager {

    private final Root root;
    private final Map<ScreenType, Screen> screens = new HashMap<>();

    public ScreenManager(final Root root) {
        this.root = root;
    }

    public void changeScreen(ScreenType screenType, Object...args) {
        Screen screen = screens.get(screenType);
        if (screen == null) {
            try {
                screen = screenType.getClazz().getDeclaredConstructor(Root.class, Object[].class).newInstance(root, args);
                screens.put(screenType, screen);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        root.setScreen(screen);
    }

}
