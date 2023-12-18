package org.baracubaba.baracumod.item

import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject
import org.baracubaba.baracumod.Baracumod
import org.baracubaba.baracumod.block.ModBlocks

object ModCreativeModeTabs {
    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Baracumod.MODID)

    val BARACUMOD_TAB: RegistryObject<CreativeModeTab> = CREATIVE_MODE_TABS.register("baracumod_tab") {
        CreativeModeTab.builder()
            .icon { ItemStack(ModItems.BARACUBAMIUM.get()) }
            .title(Component.translatable("creativetab.baracumod_tab"))
            .displayItems { displayParameters, output ->
                output.accept(ModItems.BARACUBAMIUM.get())
                output.accept(ModItems.RAW_BARACUBAMIUM.get())

                output.accept(ModBlocks.BARACUBAMIUM_BLOCK.get())
                output.accept(ModBlocks.RAW_BARACUBAMIUM_BLOCK.get())
            }
            .build()
    }

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(eventBus)
    }
}
