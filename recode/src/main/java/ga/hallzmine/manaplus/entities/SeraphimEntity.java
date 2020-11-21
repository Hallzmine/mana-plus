package ga.hallzmine.manaplus.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class SeraphimEntity extends CreatureEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private boolean attacking = false;
    public SeraphimEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
    }



    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 60.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D)
                .createMutableAttribute(Attributes.);

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this,0.0D, true));
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 90.0F));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1, 100));


    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        this.attacking = false;
        if (super.attackEntityAsMob(entity))
            if (entity instanceof SeraphimEntity)
                this.attacking = true;
            else
                this.attacking = false;
        return this.attacking;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if(this.attacking == false) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.casual", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.attack", false));
        }
        return PlayState.CONTINUE;
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 15 + this.world.rand.nextInt(30);
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_BLAZE_AMBIENT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.BLOCK_STONE_BREAK; }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.BLOCK_STONE_BREAK; }

    @Override
    public void tick() {
        super.tick();
        world.addParticle(ParticleTypes.FLAME, this.getPosX()+ (this.rand.nextGaussian() * 0.05D), this.getPosY()+0.5+ (this.rand.nextGaussian() * 0.05D), this.getPosZ() + (this.rand.nextGaussian() * 0.05D), 0, 0.2, 0);
        world.addParticle(ParticleTypes.FLAME, this.getPosX()+ (this.rand.nextGaussian() * 0.2D), this.getPosY()+0.5+ (this.rand.nextGaussian() * 0.2D), this.getPosZ() + (this.rand.nextGaussian() * 0.2D), 0, 0.3, 0);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
