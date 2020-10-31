package ga.hallzmine.manaplus.rituals;

import com.ma.api.rituals.IRitualContext;
import com.ma.api.rituals.RitualEffect;
import net.minecraft.item.DyeColor;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.ma.api.ManaAndArtificeMod.getPortalHelper;

public class RitualEffectOverworld extends RitualEffect {
    public static final Logger LOGGER = LogManager.getLogger();

    public RitualEffectOverworld(ResourceLocation ritualName) {
        super(ritualName);
    }

    @Override
    protected boolean applyRitualEffect(IRitualContext context) {
        getPortalHelper().openPortal(context.getWorld(), Vector3d.copyCentered(context.getCenter()), DyeColor.YELLOW, new BlockPos(context.getCaster().getPosX()+0.5, context.getCaster().getPosY()+0.5, context.getCaster().getPosZ()+0.5), RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("minecraft:overworld")), false);
        return true;
    }

    @Override
    protected int getApplicationTicks(IRitualContext context) {
        return 20;
    }
}
