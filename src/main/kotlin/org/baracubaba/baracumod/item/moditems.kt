package org.baracubaba.baracumod.item

import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.baracubaba.baracumod.Baracumod

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Baracumod.MODID)

    public val BARACUBAMIUM: RegistryObject<Item> = ITEMS.register("baracubamium") { Item(Item.Properties()) }
    public val RAW_BARACUBAMIUM: RegistryObject<Item> = ITEMS.register("raw_baracubamium") { Item(Item.Properties()) }

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}
