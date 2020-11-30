package ga.hallzmine.manaplus.client.render;

import ga.hallzmine.manaplus.ManaPlus;
import ga.hallzmine.manaplus.client.model.ProtectorModel;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class ProtectorRenderer extends MobRenderer<ProtectorEntity, ProtectorModel<ProtectorEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation("minecraft","textures/block/stone.png");
    public ProtectorRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ProtectorModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(ProtectorEntity entity) {
        return TEXTURE;
    }
}
