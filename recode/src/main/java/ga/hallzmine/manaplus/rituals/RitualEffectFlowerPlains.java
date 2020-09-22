package ga.hallzmine.manaplus.rituals;

import com.ma.api.capabilities.IRitualTeleportLocation;
import com.ma.api.capabilities.IWorldMagic;
import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.RitualEffect;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPlayerPositionLookPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
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
            //caster.changeDimension(destination, ITeleporter);
            LOGGER.debug("[mana-plus] Ritual Executed");
            return true;
    }

    @Override
    protected int getApplicationTicks(ServerWorld arg0, BlockPos arg1, IRitualRecipe arg2, NonNullList<ItemStack> arg3) {
        return 10;
    }


}
