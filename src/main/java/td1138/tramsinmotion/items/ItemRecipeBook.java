//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package td1138.tramsinmotion.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import td1138.tramsinmotion.TramsInMotion;
import td1138.tramsinmotion.library.TramsInMotionInfo;

public class ItemRecipeBook extends Item {
    public static int page = 0;
    public static int recipe = 0;

    public ItemRecipeBook() {
        this.maxStackSize = 1;
        this.setCreativeTab(TramsInMotion.tabTramsInMotion);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        NBTTagCompound var3 = stack.getTagCompound();
        if (var3 == null) {
            var3 = new NBTTagCompound();
            stack.setTagCompound(var3);
            stack.getTagCompound().setInteger("currPage", page);
            stack.getTagCompound().setInteger("currRecipe", recipe);
        } else {
            stack.getTagCompound().setInteger("currPage", page);
            stack.getTagCompound().setInteger("currRecipe", recipe);
        }
        player.openGui(TramsInMotion.instance, 79, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return stack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("§7Contains everything");
        par3List.add("§7you should know");
        par3List.add("§7about TramsIM");
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

    public boolean getShareTag() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(TramsInMotionInfo.modID + ":item_book_black");
    }
}
