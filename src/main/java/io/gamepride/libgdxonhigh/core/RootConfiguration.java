package io.gamepride.libgdxonhigh.core;

import io.gamepride.libgdxonhigh.integration.Platform;
import io.gamepride.libgdxonhigh.screen.ScreenType;
import lombok.Builder;
import lombok.Data;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
@Data
@Builder
public final class RootConfiguration {

    private Platform platform;
    private String preferencesName;
    private String bundlePackageName;
    private String bundlePrefix;
    private ScreenType autoOpenScreen;

}
