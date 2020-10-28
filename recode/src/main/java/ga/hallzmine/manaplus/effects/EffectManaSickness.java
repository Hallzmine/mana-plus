package ga.hallzmine.manaplus.effects;

import com.ma.api.capabilities.IPlayerMagic;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectManaSickness extends Effect {

    public EffectManaSickness(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    public void applyAttributesModifiersToEntity(LivingEntity entityLivingBaseIn, AttributeModifierManager attributeMapIn, int amplifier) {
        super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
        if (entityLivingBaseIn instanceof PlayerEntity) {
            IPlayerMagic playerMagic = (IPlayerMagic)((PlayerEntity)entityLivingBaseIn);
            playerMagic.setMana(playerMagic.getMana()-3);
        }

    }

    public void removeAttributesModifiersFromEntity(LivingEntity entityLivingBaseIn, AttributeModifierManager attributeMapIn, int amplifier) {
        super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
        if (entityLivingBaseIn instanceof PlayerEntity) {
        }

    }
}
