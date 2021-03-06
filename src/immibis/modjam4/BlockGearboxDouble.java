package immibis.modjam4;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

// metadata is high-speed direction
public class BlockGearboxDouble extends BlockContainer {
	public BlockGearboxDouble(Material m) {
		super(m);
		
		setCreativeTab(CreativeTabs.tabAllSearch);
		setHardness(2);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return (side & 6) == (meta & 6) ? Blocks.log.getIcon(0, 0) : super.getIcon(side, meta);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileGearboxDouble();
	}
	
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase pl, ItemStack p_149689_6_) {
		int l = MathHelper.floor_double((double)(pl.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int meta = l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
        w.setBlockMetadataWithNotify(x, y, z, meta, 3);
	}
}
