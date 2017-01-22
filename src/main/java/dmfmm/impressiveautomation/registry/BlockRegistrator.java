package dmfmm.impressiveautomation.registry;

import dmfmm.impressiveautomation.util.Log;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * File created by mincrmatt12 on 1/21/2017.
 * Originally written for ImpressiveAutomation.
 * <p>
 * See LICENSE.txt for license information.
 */
public class BlockRegistrator {


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        for (Field field : BlockRegistrator.class.getDeclaredFields()) {
            if (field.getType() == Block.class) {
                try {
                    registry.register((Block)field.get(null));
                } catch (IllegalAccessException e) {
                    Log.warn("Somehow failed to get a block from its registrator. WAT?");
                }
            }
        }
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        for (Field field : BlockRegistrator.class.getDeclaredFields()) {
            if (field.getType() == Block.class) {
                try {
                    Block theBlock = (Block) field.get(null);
                    registry.register(new ItemBlock(theBlock).setRegistryName(theBlock.getRegistryName()));
                } catch (IllegalAccessException e) {
                    Log.warn("Somehow failed to get a block from its registrator. WAT?");
                }
            }
        }
    }
}
