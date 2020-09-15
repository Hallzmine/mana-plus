package ga.hallzmine.manaplus.blocks;

import ga.hallzmine.manaplus.ManaPlus;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block blockIn) {
        super(blockIn, new Properties().group(ManaPlus.TAB));

    }
}
