package com.blakebr0.ironjetpacks.crafting;

import com.blakebr0.ironjetpacks.IronJetpacks;
import com.blakebr0.ironjetpacks.crafting.recipe.JetpackUpgradeRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRecipeSerializers {
    public static final IRecipeSerializer<JetpackUpgradeRecipe> CRAFTING_JETPACK_UPGRADE = new JetpackUpgradeRecipe.Serializer();

    @SubscribeEvent
    public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        IForgeRegistry<IRecipeSerializer<?>> registry = event.getRegistry();

        registry.register(CRAFTING_JETPACK_UPGRADE.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "crafting_jetpack_upgrade")));
    }
//
//	@SubscribeEvent
//	public static void onRegisterRecipes(RegistryEvent.Register<IRecipe> event) {
//		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.STRAP), " I ", "LLL", " I ", 'I', "nuggetIron", 'L', Items.LEATHER);
//		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.BASIC_COIL), "  R", " I ", "R  ", 'R', "dustRedstone", 'I', "ingotIron");
//		if (Loader.isModLoaded("thermalfoundation")) {
//			IRecipe recipe = new ShapedOreRecipe(new ResourceLocation("", ""), new ItemStack(ModItems.ADVANCED_COIL), "R  ", " G ", "  R", 'R', "dustRedstone", 'G', "ingotGold").setMirrored(false);
//			recipe.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "advanced_coil"));
//			event.getRegistry().register(recipe);
//		} else {
//			RecipeHelper.addShapedRecipe(new ItemStack(ModItems.ADVANCED_COIL), "  R", " G ", "R  ", 'R', "dustRedstone", 'G', "ingotGold");
//		}
//
//		JetpackRegistry jetpacks = JetpackRegistry.getInstance();
//		for (Jetpack jetpack : jetpacks.getAllJetpacks()) {
//			ItemPlaceholder mat = jetpack.craftingMaterial;
//			Item thruster = jetpack.thruster;
//			Item capacitor = jetpack.capacitor;
//			Item cell = jetpack.cell;
//			Item strap = ModItems.STRAP;
//			int tier = jetpack.tier;
//			Item coil = jetpacks.getCoilForTier(tier);
//			ShapedOreRecipe jetpackRecipeBasic = null;
//			JetpackUpgradeRecipe jetpackRecipeUpgrade = null;
//			ShapedOreRecipe thrusterRecipe = null;
//			ShapedOreRecipe capacitorRecipe = null;
//			ShapedOreRecipe cellRecipe = null;
//			boolean forceRecipes = jetpack.forceRecipe;
//
//			if (mat != null) {
//				if (mat.getValue() instanceof String) {
//					if (!OreDictionary.getOres(mat.getOreName(), false).isEmpty() || forceRecipes) {
//						if (ModConfigs.confBasicRecipes) {
//							jetpackRecipeBasic = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "jetpack"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getOreName(), 'T', thruster, 'E', capacitor, 'J', strap);
//						}
//
//						if (ModConfigs.confUpgradeRecipes) {
//							if (tier > jetpacks.getLowestTier()) {
//								jetpackRecipeUpgrade = new JetpackUpgradeRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "upgrade"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getOreName(), 'T', thruster, 'E', capacitor, 'J', "jetpackTier" + (tier - 1));
//							} else if (!ModConfigs.confBasicRecipes) {
//								jetpackRecipeBasic = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "jetpack"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getOreName(), 'T', thruster, 'E', capacitor, 'J', strap);
//							}
//						}
//
//						thrusterRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "thruster"), thruster, "ICI", "CEC", "IFI", 'I', mat.getOreName(), 'C', coil, 'E', cell, 'F', Blocks.FURNACE);
//						capacitorRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "capacitor"), capacitor, "ICI", "ICI", "ICI", 'I', mat.getOreName(), 'C', cell);
//						cellRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "cell"), cell, " R ", "ICI", " R ", 'I', mat.getOreName(), 'C', coil, 'R', "dustRedstone");
//					}
//				} else if (mat.getValue() instanceof ItemStack) {
//					if (!mat.getStack().isEmpty() || forceRecipes) {
//						if (ModConfigs.confBasicRecipes) {
//							jetpackRecipeBasic = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "jetpack"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getStack(), 'T', thruster, 'E', capacitor, 'J', strap);
//						}
//
//						if (ModConfigs.confUpgradeRecipes) {
//							if (tier > jetpacks.getLowestTier()) {
//								jetpackRecipeUpgrade = new JetpackUpgradeRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "upgrade"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getStack(), 'T', thruster, 'E', capacitor, 'J', "jetpackTier" + (tier - 1));
//							} else if (!ModConfigs.confBasicRecipes) {
//								jetpackRecipeBasic = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "jetpack"), jetpack.item, "IEI", "IJI", "T T", 'I', mat.getStack(), 'T', thruster, 'E', capacitor, 'J', strap);
//							}
//						}
//
//						thrusterRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "thruster"), thruster, "ICI", "CEC", "IFI", 'I', mat.getStack(), 'C', coil, 'E', cell, 'F', Blocks.FURNACE);
//						capacitorRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "capacitor"), capacitor, "ICI", "ICI", "ICI", 'I', mat.getStack(), 'C', cell);
//						cellRecipe = new ShapedOreRecipe(new ResourceLocation(IronJetpacks.MOD_ID, "cell"), cell, " R ", "ICI", " R ", 'I', mat.getStack(), 'C', coil, 'R', "dustRedstone");
//					}
//				}
//
//				if (jetpackRecipeBasic != null) {
//					jetpackRecipeBasic.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "jetpack_" + jetpack.name));
//					event.getRegistry().register(jetpackRecipeBasic);
//				}
//
//				if (jetpackRecipeUpgrade != null) {
//					jetpackRecipeUpgrade.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "upgrade_" + jetpack.name));
//					event.getRegistry().register(jetpackRecipeUpgrade);
//				}
//
//				if (thrusterRecipe != null) {
//					thrusterRecipe.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "thruster_" + jetpack.name));
//					event.getRegistry().register(thrusterRecipe);
//				}
//
//				if (capacitorRecipe != null) {
//					capacitorRecipe.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "capacitor_" + jetpack.name));
//					event.getRegistry().register(capacitorRecipe);
//				}
//
//				if (cellRecipe != null) {
//					cellRecipe.setRegistryName(new ResourceLocation(IronJetpacks.MOD_ID, "cell_" + jetpack.name));
//					event.getRegistry().register(cellRecipe);
//				}
//			}
//		}
//	}
}