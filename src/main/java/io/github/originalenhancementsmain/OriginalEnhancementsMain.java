package io.github.originalenhancementsmain;

import io.github.originalenhancementsmain.block.OEBlocks;
import io.github.originalenhancementsmain.entity.OEEntitiers;
import io.github.originalenhancementsmain.item.OEItems;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathResourcePack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.GeckoLib;

import java.io.IOException;


@Mod(OriginalEnhancementsMain.MOD_ID)

public class OriginalEnhancementsMain {
    public static final String MOD_ID = "originalenhancementsmain";

    @SubscribeEvent
    public static void playJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getPlayer();
        Level level = player.level;

        player.sendMessage(new TextComponent("Be careful, once you complete certain levels, some monsters' abilities will increase dramatically., "+player.getDisplayName().getString()+"From "+(level.isClientSide?"CLIENT":"SERVER"+".")), Util.NIL_UUID);
    }
    public static final CreativeModeTab OETab = new CreativeModeTab(OriginalEnhancementsMain.MOD_ID) {

        @Override
        @OnlyIn(Dist.CLIENT)
        public @NotNull ItemStack makeIcon(){

            return new ItemStack(OEBlocks.EXAMPLE_BLOCK.get());
        }
    };
    
    public OriginalEnhancementsMain() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        OEItems.ITEMS.register(bus);
        OEBlocks.BLOCKS.register(bus);
        OESounds.SOUNDS.register(bus);
        OEEntitiers.ENTITY_TYPES.register(bus);
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);

    }
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }

}
