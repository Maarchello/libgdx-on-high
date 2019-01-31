package io.gamepride.libgdxonhigh;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.I18NBundle;
import io.gamepride.libgdxonhigh.screen.ScreenManager;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public interface Root {

    I18NBundle getBundle();
    Preferences getPreferences();
    AssetManager getAssetManager();
    ScreenManager getScreenManager();
    void setScreen(Screen screen);

}
