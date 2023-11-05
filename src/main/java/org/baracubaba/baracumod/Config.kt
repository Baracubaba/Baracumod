package org.baracubaba.baracumod
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.config.ModConfigEvent
import net.minecraftforge.registries.ForgeRegistries

@Mod.EventBusSubscriber(modid = Baracumod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object Config {

    private val BUILDER = ForgeConfigSpec.Builder()

    private val LOG_DIRT_BLOCK = BUILDER
        .comment("Whether to log the dirt block on common setup")
        .define("logDirtBlock", true)

    private val MAGIC_NUMBER = BUILDER
        .comment("A magic number")
        .defineInRange("magicNumber", 42, 0, Int.MAX_VALUE)

    val MAGIC_NUMBER_INTRODUCTION = BUILDER
        .comment("What you want the introduction message to be for the magic number")
        .define("magicNumberIntroduction", "The magic number is... ")

    private val ITEM_STRINGS = BUILDER
        .comment("A list of items to log on common setup.")
        .defineListAllowEmpty("items", listOf("minecraft:iron_ingot")) { obj ->
            obj is String && ForgeRegistries.ITEMS.containsKey(ResourceLocation(obj))
        }

    val SPEC: ForgeConfigSpec = BUILDER.build()

    var logDirtBlock: Boolean = false
    var magicNumber: Int = 0
    lateinit var magicNumberIntroduction: String
    lateinit var items: Set<Item?>

    @SubscribeEvent
    @JvmStatic
    fun onLoad(event: ModConfigEvent) {
        logDirtBlock = LOG_DIRT_BLOCK.get()
        magicNumber = MAGIC_NUMBER.get()
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get()
        items = ITEM_STRINGS.get().map { itemName ->
            ForgeRegistries.ITEMS.getValue(ResourceLocation(itemName))
        }.toSet()
    }
}