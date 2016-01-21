package io.github.deathcap.bukkit2sponge.text;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextFactory;
import org.spongepowered.api.text.translation.Translation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;

public class ShinyTextFactory implements TextFactory {

    public static void inject() {
        try {
            Field field = Texts.class.getDeclaredField("factory");
            field.setAccessible(true);

            // remove private final - https://gist.github.com/asaskevich/4c6dee9169095fa2477f
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, new ShinyTextFactory());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Text parseJson(String json) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Text parseJsonLenient(String json) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toPlain(Text text) {
        if (text instanceof Text.Literal) {
            return ((Text.Literal) text).getContent();
        } else if (text instanceof Text.Translatable) {
            Text.Translatable translatable = (Text.Translatable) text;
            Translation translation = translatable.getTranslation();
            return translation.get(Locale.ENGLISH); // TODO: configurable
        }
        return text.toString(); // TODO: other types
    }

    @Override
    public String toPlain(Text text, Locale locale) {
        return this.toPlain(text); // TODO: localization
    }

    @Override
    public String toJson(Text text) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toJson(Text text, Locale locale) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public char getLegacyChar() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Text.Literal parseLegacyMessage(String text, char code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String stripLegacyCodes(String text, char code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String replaceLegacyCodes(String text, char from, char to) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toLegacy(Text text, char code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toLegacy(Text text, char code, Locale locale) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
