package io.gamepride.libgdxonhigh.util;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * @author Marat Kadzhaev
 * @since 0.1.0
 */
public final class WidgetUtils {

    private static final char PASSWORD_MASK = '*';

    public static TextField createTextField(String placeholder, Skin skin) {
        return createTextField(placeholder, skin, false);
    }

    public static TextField createTextField(String placeholder, Skin skin, boolean isPassword) {
        TextField textField = new TextField("", skin);
        textField.setMessageText(placeholder);

        if (isPassword) {
            textField.setPasswordMode(true);
            textField.setPasswordCharacter(PASSWORD_MASK);
        }

        return textField;
    }

}
