package ga.hallzmine.manaplus.rituals;

import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.RitualEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RitualEffectFlowerPlains extends RitualEffect {
    public static final Logger LOGGER = LogManager.getLogger();

    public RitualEffectFlowerPlains(ResourceLocation ritualName) {
        super(ritualName);
    }

    @Override
    protected boolean applyRitualEffect(PlayerEntity caster, ServerWorld world, BlockPos ritualCenter, IRitualRecipe recipe, NonNullList<ItemStack> reagents) {
        LOGGER.debug("[mana-plus] Ritual Executed");
        return true;
    }

    @Override
    protected int getApplicationTicks(ServerWorld arg0, BlockPos arg1, IRitualRecipe arg2, NonNullList<ItemStack> arg3) {
        return 10;
    }

}
