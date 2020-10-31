package ga.hallzmine.manaplus.util;

import com.ma.api.rituals.RitualEffect;
import ga.hallzmine.manaplus.rituals.RitualEffectFlowerPlains;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid="mana-plus", bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualHandler {
    public static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public static void onRitualsRegistry(final RegistryEvent.Register<RitualEffect> event) {
        event.getRegistry().register(new RitualEffectFlowerPlains(new ResourceLocation("mana-plus", "rituals/flower-plains")).setRegistryName(new ResourceLocation("mana-plus", "flower-plains-ritual-effect")));
        event.getRegistry().register(new RitualEffectFlowerPlains(new ResourceLocation("mana-plus", "rituals/overworld")).setRegistryName(new ResourceLocation("mana-plus", "overworld-ritual-effect")));
        LOGGER.debug("[mana-plus] Rituals Registered");
    }
}