package io.gamepride.libgdxonhigh.core;

import com.badlogic.gdx.graphics.Camera;
import io.gamepride.libgdxonhigh.integration.Platform;
import io.gamepride.libgdxonhigh.screen.ScreenType;
import lombok.Data;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
public final class RootConfiguration {

    private Platform platform;
    private String preferencesName;
    private String i18nBundlePath;
    private ScreenType autoOpenScreen;
    private Class<? extends Camera> camera;
    private int applicationWidth, applicationHeight;

    public static Builder builder(int applicationWidth, int applicationHeight) {
        return new Builder(applicationWidth, applicationHeight);
    }

    public static class Builder {

        private final int applicationWidth, applicationHeight;
        private Platform platform;
        private String preferencesName;
        private String i18nBundlePath;
        private ScreenType autoOpenScreen;
        private Class<? extends Camera> camera;

        public Builder(int applicationWidth, int applicationHeight) {
            this.applicationWidth = applicationWidth;
            this.applicationHeight = applicationHeight;
        }

        public Builder platform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public Builder preferencesName(String preferencesName) {
            this.preferencesName = preferencesName;
            return this;
        }

        public Builder i18nBundlePath(String i18nBundlePath) {
            this.i18nBundlePath = i18nBundlePath;
            return this;
        }

        public Builder autoOpenScreen(ScreenType screenType) {
            this.autoOpenScreen = screenType;
            return this;
        }

        public Builder camera(Class<? extends Camera> camera) {
            this.camera = camera;
            return this;
        }

        public RootConfiguration build() {
            RootConfiguration configuration = new RootConfiguration();
            configuration.setApplicationHeight(applicationHeight);
            configuration.setApplicationWidth(applicationWidth);
            configuration.setCamera(camera);
            configuration.setI18nBundlePath(i18nBundlePath);
            configuration.setAutoOpenScreen(autoOpenScreen);
            configuration.setPreferencesName(preferencesName);
            configuration.setPlatform(platform);
            return configuration;
        }

    }

}
