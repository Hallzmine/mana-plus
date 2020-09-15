package ga.hallzmine.arsplus;

import com.ma.api.rituals.RitualEffect;
import ga.hallzmine.arsplus.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("arsplus")
public class ArsPlus
{

    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "arsplus";

    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


    public ArsPlus() {

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.DESERT_NOVA_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.TARMA_ROOT_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.WAKEBLOOM_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.AUM_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CERUBLOSSOM_CROP.get(), RenderType.getCutout());
    }

    public static final ItemGroup TAB = new ItemGroup("arsPlusTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RIFT.get());
        }
    };
}
