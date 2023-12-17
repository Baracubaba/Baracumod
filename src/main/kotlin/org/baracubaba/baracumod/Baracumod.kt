package org.baracubaba.baracumod

import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.baracubaba.baracumod.block.ModBlocks
import org.baracubaba.baracumod.item.ModItems
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

@Mod(Baracumod.MODID)
object Baracumod {
    const val MODID = "baracumod"
    private val LOGGER = LogManager.getLogger(MODID)

    init {
        ModItems.register(MOD_BUS)
        ModBlocks.register(MOD_BUS)

        MinecraftForge.EVENT_BUS.register(this)
        MOD_BUS.addListener(::commonSetup)
        MOD_BUS.addListener(::addCreative)

        runForDist(
            clientTarget = { MOD_BUS.addListener(::onClientSetup) },
            serverTarget = { MOD_BUS.addListener(::onServerSetup) }
        )
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        // Common setup code
    }

    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BARACUBAMIUM)
            event.accept(ModItems.RAW_BARACUBAMIUM)
        }
        if(event.tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BARACUBAMIUM_BLOCK);
            event.accept(ModBlocks.RAW_BARACUBAMIUM_BLOCK);
        }
    }


    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        // Server starting code
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.info("Initializing client...")
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.info("Server starting...")
    }
}