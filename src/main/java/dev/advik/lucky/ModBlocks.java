package dev.advik.lucky;

import dev.advik.lucky.Lucky;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Lucky.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Lucky.MODID);

    public static final DeferredBlock<Block> LUCKY_BLOCK = BLOCKS.register("lucky_block",
            () -> new LuckyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).strength(0.5F)));

    public static final DeferredItem<BlockItem> LUCKY_BLOCK_ITEM = ITEMS.register("lucky_block",
            () -> new BlockItem(LUCKY_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
