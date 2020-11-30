package ga.hallzmine.manaplus.client.model;

import ga.hallzmine.manaplus.entities.SeraphimEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeraphimModel extends AnimatedGeoModel<SeraphimEntity>
{
	@Override
	public ResourceLocation getModelLocation(SeraphimEntity object)
	{
		return new ResourceLocation("mana-plus", "geo/seraphim.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SeraphimEntity object)
	{
		return new ResourceLocation("mana-plus", "textures/entity/angel.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(SeraphimEntity object)
	{
		return new ResourceLocation("mana-plus", "animations/seraphim_animation.json");
	}
}