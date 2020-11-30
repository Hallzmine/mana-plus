package ga.hallzmine.manaplus.client.render;

import ga.hallzmine.manaplus.client.model.SeraphimModel;
import ga.hallzmine.manaplus.entities.SeraphimEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SeraphimRenderer extends GeoEntityRenderer<SeraphimEntity> {

    public SeraphimRenderer(EntityRendererManager renderManager) {
        super(renderManager, new SeraphimModel());
    }
}
