package ga.hallzmine.arsplus.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ManaBarrelBlock extends Block {
    public ManaBarrelBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(0.75f,1.0f)
                .notSolid()
                .harvestTool(ToolType.AXE)
                .sound(SoundType.WOOD)
        );
    }
}
