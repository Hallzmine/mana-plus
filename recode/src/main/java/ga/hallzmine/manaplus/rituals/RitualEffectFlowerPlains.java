package ga.hallzmine.manaplus.rituals;

import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.RitualEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class RitualEffectFlowerPlains extends RitualEffect {
    public static final Logger LOGGER = LogManager.getLogger();

    public RitualEffectFlowerPlains(ResourceLocation ritualName) {
        super(ritualName);
    }
    @Override
    protected boolean applyRitualEffect(PlayerEntity caster, ServerWorld world, BlockPos ritualCenter, IRitualRecipe recipe, NonNullList<ItemStack> reagents) {
        ResourceLocation location = new ResourceLocation("mana-plus:flower_plains");
        RegistryKey<World> key = RegistryKey.func_240903_a_(Registry.field_239699_ae_, location);
        ServerWorld destination = world.getWorld().getServer().getWorld(key);
        caster.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                entity = repositionEntity.apply(false);
                entity.setPositionAndUpdate(caster.getPosX(), caster.getPosY(), caster.getPosZ());
                return entity;
            }
        });
        LOGGER.debug("[mana-plus] Ritual Executed");
        return true;
    }

    @Override
    protected int getApplicationTicks(ServerWorld arg0, BlockPos arg1, IRitualRecipe arg2, NonNullList<ItemStack> arg3) {
        return 10;
    }

}
