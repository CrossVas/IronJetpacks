package com.blakebr0.ironjetpacks.compat.rei;

import com.blakebr0.ironjetpacks.init.ModItems;
import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.forge.REIPluginCommon;

@REIPluginCommon
public class ReiCompat implements REIServerPlugin {

    @Override
    public void registerItemComparators(ItemComparatorRegistry registry) {
        ModItems.JETPACK.ifPresent(registry::registerNbt);
        ModItems.CELL.ifPresent(registry::registerNbt);
        ModItems.THRUSTER.ifPresent(registry::registerNbt);
        ModItems.CAPACITOR.ifPresent(registry::registerNbt);
    }
}
