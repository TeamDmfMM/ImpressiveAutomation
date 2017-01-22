package dmfmm.impressiveautomation.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * File created by mincrmatt12 on 1/21/2017.
 * Originally written for ImpressiveAutomation.
 * <p>
 * See LICENSE.txt for license information.
 */

public abstract class BlockContainerRotatable extends Block implements ITileEntityProvider {
    IProperty<EnumFacing> propertyFacing = PropertyDirection.create("facing");

    public BlockContainerRotatable(Material materialIn) {
        super(materialIn);
    }

    abstract boolean canRotateVertical();

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, propertyFacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(propertyFacing).getIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(propertyFacing, EnumFacing.getFront(meta));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        if (canRotateVertical()) {
            return this.getDefaultState().withProperty(propertyFacing, EnumFacing.getDirectionFromEntityLiving(pos, placer));
        }
        else {
            return this.getDefaultState().withProperty(propertyFacing, placer.getHorizontalFacing().getOpposite());
        }
    }
}
