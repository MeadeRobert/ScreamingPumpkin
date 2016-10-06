package com.turnip.screamingpumpkinmod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ScreamingPumpkinBlock extends BlockDirectional
{
	public IIcon[] icons = new IIcon[6];
	private boolean jackOLantern;
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon faceIcon;

	protected ScreamingPumpkinBlock(String unlocalizedName, Material m)
	{
		super(m);
		this.setTickRandomly(true);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(ScreamingPumpkin.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1);
		this.setResistance(5);
		this.setHarvestLevel("axe", 0);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random r)
	{
		// randomly scream
		world.playSoundEffect(x + .5D, y + .5D, z + .5D, "screamingpumpkin:pumpkin_scream", 1.0F, 1.0F);
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);

		if (world.getBlock(x, y - 1, z) == Blocks.snow && world.getBlock(x, y - 2, z) == Blocks.snow)
		{
			if (!world.isRemote)
			{
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);
				EntitySnowman entitysnowman = new EntitySnowman(world);
				entitysnowman.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F,
						0.0F);
				world.spawnEntityInWorld(entitysnowman);
				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));
			}

			for (int i1 = 0; i1 < 120; ++i1)
			{
				world.spawnParticle("snowshovel", (double) x + world.rand.nextDouble(),
						(double) (y - 2) + world.rand.nextDouble() * 2.5D, (double) z + world.rand.nextDouble(), 0.0D,
						0.0D, 0.0D);
			}
		}
		else if (world.getBlock(x, y - 1, z) == Blocks.iron_block && world.getBlock(x, y - 2, z) == Blocks.iron_block)
		{
			boolean flag = world.getBlock(x - 1, y - 1, z) == Blocks.iron_block
					&& world.getBlock(x + 1, y - 1, z) == Blocks.iron_block;
			boolean flag1 = world.getBlock(x, y - 1, z - 1) == Blocks.iron_block
					&& world.getBlock(x, y - 1, z + 1) == Blocks.iron_block;

			if (flag || flag1)
			{
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag)
				{
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				}
				else
				{
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				EntityIronGolem entityirongolem = new EntityIronGolem(world);
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F,
						0.0F);
				world.spawnEntityInWorld(entityirongolem);

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double) x + world.rand.nextDouble(),
							(double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(),
							0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag)
				{
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				}
				else
				{
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).isReplaceable(world, x, y, z)
				&& World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}

	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
	{
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		this.faceIcon = reg.registerIcon(this.getTextureName() + "_face_" + (this.jackOLantern ? "on" : "off"));
		this.topIcon = reg.registerIcon(this.getTextureName() + "_top");
		this.blockIcon = reg.registerIcon(this.getTextureName() + "_side");
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		// not our fault... blame notch for this
		return side == 1 ? this.topIcon
				: (side == 0 ? this.topIcon
						: (meta == 2 && side == 2 ? this.faceIcon
								: (meta == 3 && side == 5 ? this.faceIcon
										: (meta == 0 && side == 3 ? this.faceIcon
												: (meta == 1 && side == 4 ? this.faceIcon : this.blockIcon)))));
	}
}
