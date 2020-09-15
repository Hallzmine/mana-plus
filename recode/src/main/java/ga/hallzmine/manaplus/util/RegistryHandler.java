package ga.hallzmine.manaplus.util;

import ga.hallzmine.manaplus.ManaPlus;
import ga.hallzmine.manaplus.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ManaPlus.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ManaPlus.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> DESERT_NOVA_SEED = ITEMS.register("desert_nova_seed", () -> new BlockItem(RegistryHandler.DESERT_NOVA_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> TARMA_ROOT_SEED = ITEMS.register("tarma_root_seed", () -> new BlockItem(RegistryHandler.TARMA_ROOT_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> WAKEBLOOM_SEED = ITEMS.register("wakebloom_seed", () -> new BlockItem(RegistryHandler.WAKEBLOOM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> AUM_SEED = ITEMS.register("aum_seed", () -> new BlockItem(RegistryHandler.AUM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));
    public static final RegistryObject<Item> CERUBLOSSOM_SEED = ITEMS.register("cerublossom_seed", () -> new BlockItem(RegistryHandler.CERUBLOSSOM_CROP.get(), new Item.Properties().group(ManaPlus.TAB)));

    //Blocks
    public static final RegistryObject<Block> DESERT_NOVA_CROP = BLOCKS.register("desert_nova_crop", () -> new DesertNovaCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> TARMA_ROOT_CROP = BLOCKS.register("tarma_root_crop", () -> new TarmaRootCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> WAKEBLOOM_CROP = BLOCKS.register("wakebloom_crop", () -> new WakebloomCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> AUM_CROP = BLOCKS.register("aum_crop", () -> new AumCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> CERUBLOSSOM_CROP = BLOCKS.register("cerublossom_crop", () -> new CerublossomCrop(Block.Properties.from(Blocks.WHEAT)));
}
