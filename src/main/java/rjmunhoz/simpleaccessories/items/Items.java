package rjmunhoz.simpleaccessories.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import rjmunhoz.simpleaccessories.SimpleAccessories;
import rjmunhoz.simpleaccessories.items.cloaks.InvisibilityCloak;
import rjmunhoz.simpleaccessories.items.cloaks.RegularCloak;
import rjmunhoz.simpleaccessories.items.rings.GemlessRing;
import rjmunhoz.simpleaccessories.items.rings.SpeedRing;

public class Items {
  public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(SimpleAccessories.MOD_ID, "general"))
    .icon(() -> new ItemStack(Items.GEMLESS_RING))
    .build();

  public static final GemlessRing GEMLESS_RING = new GemlessRing();
  public static final SpeedRing SPEED_RING = new SpeedRing();
  public static final InvisibilityCloak INVISIBILITY_CLOAK = new InvisibilityCloak();
  public static final RegularCloak REGULAR_CLOAK = new RegularCloak();

  public static void register() {
    Registry.register(Registry.ITEM, Items.GEMLESS_RING.getIdentifier(), Items.GEMLESS_RING);
    Registry.register(Registry.ITEM, Items.SPEED_RING.getIdentifier(), Items.SPEED_RING);
    Registry.register(Registry.ITEM, Items.INVISIBILITY_CLOAK.getIdentifier(), Items.INVISIBILITY_CLOAK);
    Registry.register(Registry.ITEM, Items.REGULAR_CLOAK.getIdentifier(), Items.REGULAR_CLOAK);
  }
}
