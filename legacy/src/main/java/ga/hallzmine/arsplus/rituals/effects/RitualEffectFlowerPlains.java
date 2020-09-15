
package ga.hallzmine.arsplus.rituals.effects;

import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.RitualEffect;
import com.ma.recipes.rituals.RitualRecipe;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Resource;
import java.util.Objects;

public class RitualEffectFlowerPlains extends RitualEffect {
    public RitualEffectFlowerPlains(ResourceLocation ritualName) {
        super(ritualName);
    }

    @Override
    protected boolean applyRitualEffect(PlayerEntity playerEntity, ServerWorld serverWorld, BlockPos blockPos, IRitualRecipe iRitualRecipe, NonNullList<ItemStack> nonNullList) {
        ResourceLocation location = new ResourceLocation("arsplus:flower_plains");
        RegistryKey<World> key = RegistryKey.func_240903_a_(Registry.field_239699_ae_, location);
        playerEntity.changeDimension(serverWorld, (ITeleporter) serverWorld.getServer().getWorld(key));
        return true;
    }


    @Override
    protected int getApplicationTicks(ServerWorld world, BlockPos ritualCenter, IRitualRecipe completedrecipe,
                                      NonNullList reagents) {
        return 10;
    }
}