package ga.hallzmine.arsplus.util;

import com.ma.api.rituals.RitualEffect;
import ga.hallzmine.arsplus.ArsPlus;
import ga.hallzmine.arsplus.blocks.*;
import ga.hallzmine.arsplus.items.ItemBase;
import ga.hallzmine.arsplus.items.PlaceholderArsplus;
import ga.hallzmine.arsplus.items.VintDrink;
import ga.hallzmine.arsplus.rituals.effects.RitualEffectFlowerPlains;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArsPlus.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArsPlus.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Itemerino
    public static final RegistryObject<Item> RIFT = ITEMS.register("rift", ItemBase::new);
    public static final RegistryObject<Item> MB_PLACEHOLDER = ITEMS.register("mana_barrel_placeholder", PlaceholderArsplus::new);
    public static final RegistryObject<Item> VINTDRINK = ITEMS.register("vint_drink", VintDrink::new);
    public static final RegistryObject<Item> DESERT_NOVA_SEED = ITEMS.register("desert_nova_seed", () -> new BlockItem(RegistryHandler.DESERT_NOVA_CROP.get(), new Item.Properties().group(ArsPlus.TAB)));
    public static final RegistryObject<Item> TARMA_ROOT_SEED = ITEMS.register("tarma_root_seed", () -> new BlockItem(RegistryHandler.TARMA_ROOT_CROP.get(), new Item.Properties().group(ArsPlus.TAB)));
    public static final RegistryObject<Item> WAKEBLOOM_SEED = ITEMS.register("wakebloom_seed", () -> new BlockItem(RegistryHandler.WAKEBLOOM_CROP.get(), new Item.Properties().group(ArsPlus.TAB)));
    public static final RegistryObject<Item> AUM_SEED = ITEMS.register("aum_seed", () -> new BlockItem(RegistryHandler.AUM_CROP.get(), new Item.Properties().group(ArsPlus.TAB)));
    public static final RegistryObject<Item> CERUBLOSSOM_SEED = ITEMS.register("cerublossom_seed", () -> new BlockItem(RegistryHandler.CERUBLOSSOM_CROP.get(), new Item.Properties().group(ArsPlus.TAB)));



    //haha block go brrrrrrrrrrrrrrreak
    public static final RegistryObject<Block> MANABARREL_BLOCK = BLOCKS.register("mana_barrel", ManaBarrelBlock::new);
    public static final RegistryObject<Block> DESERT_NOVA_CROP = BLOCKS.register("desert_nova_crop", () -> new DesertNovaCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> TARMA_ROOT_CROP = BLOCKS.register("tarma_root_crop", () -> new TarmaRootCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> WAKEBLOOM_CROP = BLOCKS.register("wakebloom_crop", () -> new WakebloomCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> AUM_CROP = BLOCKS.register("aum_crop", () -> new AumCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> CERUBLOSSOM_CROP = BLOCKS.register("cerublossom_crop", () -> new CerublossomCrop(Block.Properties.from(Blocks.WHEAT)));


    //Noo not my Itemerino! Haha block go brrrrrrrrrrrrrrrrrrrrrrrrreak
    public static final RegistryObject<Item> MANABARREL_ITEM = ITEMS.register("mana_barrel", () -> new BlockItemBase(MANABARREL_BLOCK.get()));

}
