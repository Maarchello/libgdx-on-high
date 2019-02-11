package io.gamepride.libgdxonhigh.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import io.gamepride.libgdxonhigh.core.Root;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public class AbstractScreen extends ScreenAdapter {

    private static final float DEFAULT_BACKGROUND_COLOR = 34 / 255f;

    private final boolean autoStageUpdate;

    protected Object[] args;
    protected final Root root;
    protected final Stage stage;

    public AbstractScreen(Root root, Object... args) {
        this(root, true, args);
    }

    public AbstractScreen(Root root, boolean autoStageUpdate, Object... args) {
        this.root = root;
        this.args = args;
        this.stage = new Stage(new FillViewport(root.getApplicationWidth(), root.getApplicationHeight(), root.getCamera()));
        this.autoStageUpdate = autoStageUpdate;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(DEFAULT_BACKGROUND_COLOR, DEFAULT_BACKGROUND_COLOR, DEFAULT_BACKGROUND_COLOR, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (autoStageUpdate) {
            updateStage(delta);
        }
    }

    protected void updateStage(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {
        stage.clear();
    }
}
