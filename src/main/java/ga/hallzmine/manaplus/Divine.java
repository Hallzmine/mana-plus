package ga.hallzmine.manaplus;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Divine extends DimensionRenderInfo {
    public Divine() {
        super(128.0F, true, FogType.NONE, false, false);
    }

    public Vector3d func_230494_a_(Vector3d p_230494_1_, float p_230494_2_) {
        return p_230494_1_.mul((double)(p_230494_2_ * 0.94F + 0.06F), (double)(p_230494_2_ * 0.94F + 0.06F), (double)(p_230494_2_ * 0.91F + 0.09F));
    }

    public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
        return false;
    }
}
