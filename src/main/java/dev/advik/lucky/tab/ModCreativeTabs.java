package dev.advik.lucky.tab;

import dev.advik.lucky.Lucky;
import dev.advik.lucky.ModBlocks;
import dev.advik.lucky.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.core.registries.Registries;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Lucky.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.lucky"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> ModBlocks.LUCKY_BLOCK_ITEM.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                output.accept(ModItems.EXAMPLE_ITEM.get());
                                output.accept(ModBlocks.LUCKY_BLOCK_ITEM.get());
                            }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
