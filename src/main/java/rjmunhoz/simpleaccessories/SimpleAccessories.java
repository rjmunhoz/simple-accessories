package rjmunhoz.simpleaccessories;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import rjmunhoz.simpleaccessories.items.Items;

public class SimpleAccessories implements ModInitializer {
    public static String MOD_ID = "simpleaccessories";

    @Override
    public void onInitialize() {
        Items.register();
        TrinketSlots.addSlot(SlotGroups.HAND, Slots.RING, new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));
    }
}
