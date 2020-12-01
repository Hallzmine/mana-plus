package ga.hallzmine.manaplus.rituals;

import com.ma.api.IPortalHelper;
import com.ma.api.capabilities.IRitualTeleportLocation;
import com.ma.api.capabilities.IWorldMagic;
import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.IRitualContext;
import com.ma.api.rituals.RitualEffect;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPlayerPositionLookPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.*;
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

import static com.ma.api.ManaAndArtificeMod.getPortalHelper;

public class RitualEffectFlowerPlains extends RitualEffect {
    public static final Logger LOGGER = LogManager.getLogger();

    public RitualEffectFlowerPlains(ResourceLocation ritualName) {
        super(ritualName);
    }

    @Override
    protected boolean applyRitualEffect(IRitualContext context) {
        if(context.getWorld() == context.getWorld().getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("mana-plus:flower_plains")))) {
            getPortalHelper().openPortal(context.getWorld(), Vector3d.copyCentered(context.getCenter()), DyeColor.GREEN, new BlockPos(context.getCaster().getPosX() + 0.5, context.getCaster().getPosY() + 0.5, context.getCaster().getPosZ() + 0.5), RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("minecraft:overworld")), true);
        } else {
            getPortalHelper().openPortal(context.getWorld(), Vector3d.copyCentered(context.getCenter()), DyeColor.YELLOW, new BlockPos(context.getCaster().getPosX() + 0.5, context.getCaster().getPosY() + 0.5, context.getCaster().getPosZ() + 0.5), RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("mana-plus:flower_plains")), true);
        }

        return true;
    }

    @Override
    protected int getApplicationTicks(IRitualContext context) {
        return 20;
    }


}
