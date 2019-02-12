package io.gamepride.libgdxonhigh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.I18NBundle;
import io.gamepride.libgdxonhigh.core.Root;
import io.gamepride.libgdxonhigh.core.RootConfiguration;
import io.gamepride.libgdxonhigh.integration.Platform;
import io.gamepride.libgdxonhigh.screen.ScreenManager;
import io.gamepride.libgdxonhigh.util.Assert;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class GameOnHigh extends Game implements Root {

    private static final String DEFAULT_PREFERENCES_NAME = "on_high_preferences";

    private final RootConfiguration configuration;

    private I18NBundle bundle;
    private Preferences preferences;
    private AssetManager assetManager;
    private ScreenManager screenManager;
    private Camera camera;

    public GameOnHigh(RootConfiguration configuration) {
        Assert.notNull(configuration);
        this.configuration = configuration;
    }

    @Override
    public void create() {
        init();

        if (configuration.getAutoOpenScreen() != null) {
            screenManager.changeScreen(configuration.getAutoOpenScreen());
        }
    }

    @Override
    public I18NBundle getBundle() {
        if (bundle == null) {
            throw new IllegalStateException("You must provide path to bundles in RootConfiguration");
        }

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
        return null; //todo
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public int getApplicationWidth() {
        return configuration.getApplicationWidth();
    }

    @Override
    public int getApplicationHeight() {
        return configuration.getApplicationHeight();
    }

    private void init() {
        i18n();
        preferences();
        screenManager();
        assetManager();
        camera();
    }

    private void camera() {
        Class<? extends Camera> camera = configuration.getCamera();
        if (camera != null) {
            try {
                this.camera = camera.getDeclaredConstructor(Float.class, Float.class).newInstance((float)configuration.getApplicationWidth(), (float)configuration.getApplicationHeight());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private void i18n() {
        String i18nBundlePath = configuration.getI18nBundlePath();
        if (i18nBundlePath != null && !i18nBundlePath.isEmpty()) {
            FileHandle fileHandle = Gdx.files.internal(i18nBundlePath);
            this.bundle = I18NBundle.createBundle(fileHandle);
        }
    }

    private void preferences() {
        String preferencesName = configuration.getPreferencesName();
        if (preferencesName == null) {
            preferences = Gdx.app.getPreferences(DEFAULT_PREFERENCES_NAME);
        } else {
            Assert.notEmpty(preferencesName);
            preferences = Gdx.app.getPreferences(configuration.getPreferencesName());
        }
    }

    private void screenManager() {
        this.screenManager = new ScreenManager(this);
    }

    private void assetManager() {
        assetManager = new AssetManager();
    }
}
