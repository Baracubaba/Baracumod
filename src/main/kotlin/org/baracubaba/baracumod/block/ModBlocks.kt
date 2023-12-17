package org.baracubaba.baracumod.block

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.baracubaba.baracumod.Baracumod
import org.baracubaba.baracumod.item.ModItems

object ModBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Baracumod.MODID)

    val BARACUBAMIUM_BLOCK: RegistryObject<Block> = registerBlock("baracubamium_block") {
        Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL))
    }

    val RAW_BARACUBAMIUM_BLOCK: RegistryObject<Block> = registerBlock("raw_baracubamium_block") {
        Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL))
    }

    private fun <T: Block> registerBlock(name: String, block: () -> T): RegistryObject<T> {
        val toReturn = BLOCKS.register(name, block)
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun <T: Block> registerBlockItem(name: String, block: RegistryObject<T>): RegistryObject<Item> {
        return ModItems.ITEMS.register(name) { BlockItem(block.get(), Item.Properties()) }
    }

    fun register(eventBus: IEventBus) {
        BLOCKS.register(eventBus)
    }
}
