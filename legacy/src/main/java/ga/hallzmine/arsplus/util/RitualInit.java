package ga.hallzmine.arsplus.util;

import com.ma.api.rituals.RitualEffect;
import ga.hallzmine.arsplus.ArsPlus;
import ga.hallzmine.arsplus.rituals.effects.RitualEffectFlowerPlains;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
/*
@Mod.EventBusSubscriber(modid="arsplus", bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualInit {
    @SubscribeEvent
    public static void registerRitualEffects(RegistryEvent.Register event) {
        event.getRegistry().registerAll(
                new RitualEffectFlowerPlains(new ResourceLocation("arsplus", "rituals/flower_plains"))
                        .setRegistryName(new ResourceLocation("arsplus", "ritual-effect-flower-plains"))
        );
        ArsPlus.LOGGER.debug("Hallzmine's Mana+: Rituals Registered");
    }
}
*/