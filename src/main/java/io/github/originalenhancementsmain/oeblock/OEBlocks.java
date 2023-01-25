package io.github.originalenhancementsmain.oeblock;

import io.github.originalenhancementsmain.OriginalEnhancementMain;
import io.github.originalenhancementsmain.oeblock.apparatusblock.blocks.NatureRealNameReconfigurableApparatusBlock;
import io.github.originalenhancementsmain.oeblock.blocks.LadiaOreBlock;
import io.github.originalenhancementsmain.item.OEItems;
import io.github.originalenhancementsmain.test.TestBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OEBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OriginalEnhancementMain.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = OEItems.ITEMS;

    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("demon_ice", () -> new Block(BlockBehaviour.Properties.of(Material.ICE, MaterialColor.COLOR_PURPLE)
            .strength(10.0f, 3.0f).speedFactor(0.4F).sound(SoundType.GLASS).requiresCorrectToolForDrops()), OriginalEnhancementMain.OETab);


    public static final RegistryObject<Block> LADIA_ORE = registerBlock("ladia_ore",() -> new LadiaOreBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(15.0f,300.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion(),UniformInt.of(10,20)), OriginalEnhancementMain.OETab);

    public static final RegistryObject<Block> DEEPSLATE_LADIA_ORE = registerBlock("deepslate_ladia_ore",() -> new LadiaOreBlock(BlockBehaviour.Properties.of(Material.STONE,MaterialColor.DEEPSLATE)
            .strength(15.0f,300.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().noOcclusion(),UniformInt.of(10,20)), OriginalEnhancementMain.OETab);

    public static final RegistryObject<Block> NATURE_REAL_NAME_RECONFIGURABLE_APPARATUS_BLOCK = registerBlock("nature_real_name_reconfigurable_apparatus_block", ()-> new NatureRealNameReconfigurableApparatusBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
            .strength(3.0f, 3.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().noOcclusion()), OriginalEnhancementMain.OETab);

    public static final RegistryObject<Block> TEXT_BLOCK = registerBlock("test_block", ()-> new TestBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
            .strength(3.0f, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()), OriginalEnhancementMain.OETab);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        OEItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


}
