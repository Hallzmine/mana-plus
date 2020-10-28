package ga.hallzmine.manaplus;

import com.ma.api.guidebook.RegisterGuidebooksEvent;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
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

import ga.hallzmine.manaplus.util.RegistryHandler;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mana-plus")
public class ManaPlus
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mana-plus";
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public ManaPlus() {
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRegisterGuidebooks(RegisterGuidebooksEvent event) {
        event.getRegistry().addGuidebookPath(new ResourceLocation("mana-plus", "guide"));
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(RegistryHandler.PROTECTOR.get(), ProtectorEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.DESERT_NOVA_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.TARMA_ROOT_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.WAKEBLOOM_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.AUM_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CERUBLOSSOM_CROP.get(), RenderType.getCutout());
    }

    public static final ItemGroup TAB = new ItemGroup("manaPlusTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.CERUBLOSSOM_SEED.get());
        }
    };
}
