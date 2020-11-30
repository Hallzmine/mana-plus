package ga.hallzmine.manaplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import ga.hallzmine.manaplus.entities.ProtectorEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ProtectorModel<T extends ProtectorEntity> extends EntityModel<T> {
    private final ModelRenderer Head;
    private final ModelRenderer leftarm;
    private final ModelRenderer body;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;

    public ProtectorModel() {
        textureWidth = 64;
        textureHeight = 64;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, -42.0F, 0.0F);
        Head.setTextureOffset(6, 22).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(8.5F, -40.0F, 0.0F);
        leftarm.setTextureOffset(6, 22).addBox(-0.5F, -2.0F, -1.5F, 3.0F, 37.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(-4.0F, -18.0F, 0.0F);
        body.setTextureOffset(6, 22).addBox(-5.0F, 0.0F, -4.0F, 18.0F, 10.0F, 8.0F, 0.0F, false);
        body.setTextureOffset(6, 22).addBox(-4.0F, -24.0F, -3.0F, 16.0F, 24.0F, 6.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-8.0F, -40.0F, 0.0F);
        rightarm.setTextureOffset(6, 22).addBox(-3.0F, -2.0F, -1.5F, 3.0F, 37.0F, 3.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(5.0F, -8.0F, 0.0F);
        leftleg.setTextureOffset(6, 22).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 32.0F, 6.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-5.0F, -8.0F, 0.0F);
        rightleg.setTextureOffset(6, 22).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 32.0F, 6.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        //this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }



    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
