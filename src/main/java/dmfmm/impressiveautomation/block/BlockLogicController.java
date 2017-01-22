package dmfmm.impressiveautomation.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * File created by mincrmatt12 on 1/21/2017.
 * Originally written for ImpressiveAutomation.
 * <p>
 * See LICENSE.txt for license information.
 */
public class BlockLogicController extends Block{
    public BlockLogicController() {
        super(Material.ANVIL);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {


        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
}
