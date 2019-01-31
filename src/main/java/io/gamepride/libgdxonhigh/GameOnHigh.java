package io.gamepride.libgdxonhigh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;
import io.gamepride.libgdxonhigh.core.Root;
import io.gamepride.libgdxonhigh.core.RootConfiguration;
import io.gamepride.libgdxonhigh.integration.Platform;
import io.gamepride.libgdxonhigh.screen.ScreenManager;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class GameOnHigh extends Game implements Root {

    private final RootConfiguration configuration;

    private Platform platform;
    private I18NBundle bundle;
    private Preferences preferences;
    private AssetManager assetManager;
    private ScreenManager screenManager;


    public GameOnHigh() {
        this(null);
    }

    public GameOnHigh(RootConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void create() {
        init();

        if (configuration != null && configuration.getAutoOpenScreen() != null) {
            screenManager.changeScreen(configuration.getAutoOpenScreen());
        }
    }

    @Override
    public I18NBundle getBundle() {
        return bundle;
    }

    @Override
    public Preferences getPreferences() {
        return preferences;
    }

    @Override
    public AssetManager getAssetManager() {
        return assetManager;
    }

    @Override
    public ScreenManager getScreenManager() {
        return screenManager;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }

    private void init() {
        i18n();
        preferences();
        screenManager();
        assetManager();

        platform = configuration.getPlatform();
    }

    private void i18n() {
        if (configuration != null) {
            String bundlePackageName = configuration.getBundlePackageName();
            String bundlePrefix = configuration.getBundlePrefix();
        }
        FileHandle fileHandle = Gdx.files.internal("i18n/MyBundle"); // todo
        this.bundle = I18NBundle.createBundle(fileHandle);
    }

    private void preferences() {
        // todo
    }

    private void screenManager() {
        this.screenManager = new ScreenManager(this);
    }

    private void assetManager() {
        assetManager = new AssetManager();
    }
}
