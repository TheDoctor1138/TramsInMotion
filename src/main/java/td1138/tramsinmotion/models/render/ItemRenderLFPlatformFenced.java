package td1138.tramsinmotion.models.render;

import fexcraft.tmt.slim.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import td1138.tramsinmotion.library.TramsInMotionInfo;
import td1138.tramsinmotion.models.blocks.ModelLFPlatformFenced;

public class ItemRenderLFPlatformFenced implements IItemRenderer {
    private static final ModelLFPlatformFenced modelLFPlatformFenced = new ModelLFPlatformFenced();
    private static final ResourceLocation texture = new ResourceLocation(TramsInMotionInfo.resourceLocation,TramsInMotionInfo.modelTexPrefix + "Low_Floor_Platform.png");

    public ItemRenderLFPlatformFenced() {
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY:
                RenderLFPlatformFenced(0.2f, 1f, 1f);
                return;
            case EQUIPPED:
                RenderLFPlatformFenced(0.2f, 1f, 1f);
                return;

            case EQUIPPED_FIRST_PERSON: {
                RenderLFPlatformFenced(0.2f, 1f, 1f);
                return;
            }
            case INVENTORY: {
                RenderLFPlatformFenced(0f, 0f, 0.7f);
                return;
            }
            default:
                break;
        }
    }

    private void RenderLFPlatformFenced(float x, float y, float z) {
        Tessellator.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y + 0.125f, z);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        modelLFPlatformFenced.render();
        GL11.glPopMatrix();
    }
}
