package dev.advik.lucky;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class LuckyBlock extends Block {
    public LuckyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state,
                              net.minecraft.world.level.block.entity.BlockEntity blockEntity,
                              net.minecraft.world.item.ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);

        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            Random random = new Random();
            switch (random.nextInt(3)) {
                case 0 -> serverLevel.addFreshEntity(new ItemEntity(serverLevel, pos.getX(), pos.getY(), pos.getZ(),
                        new net.minecraft.world.item.ItemStack(Items.DIAMOND, 3)));
                case 1 -> serverLevel.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, Level.ExplosionInteraction.TNT);
                case 2 -> {
                    var zombie = new Zombie(serverLevel);
                    zombie.setPos(pos.getX(), pos.getY(), pos.getZ());
                    serverLevel.addFreshEntity(zombie);
                }
            }
        }
    }
}
