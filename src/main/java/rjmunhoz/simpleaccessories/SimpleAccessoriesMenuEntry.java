package rjmunhoz.simpleaccessories;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

import java.util.Map;

public class SimpleAccessoriesMenuEntry implements ModMenuApi {
    @Override
    public String getModId() {
        return SimpleAccessories.MOD_ID;
    }
}
