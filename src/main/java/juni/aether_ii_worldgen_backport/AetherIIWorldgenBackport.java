package juni.aether_ii_worldgen_backport;

import juni.aether_ii_worldgen_backport.world.biome.AetherIIWorldgenBackportRegion;
import juni.aether_ii_worldgen_backport.world.density.AetherIIWorldgenBackportDensityFunctionTypes;
import juni.aether_ii_worldgen_backport.world.feature.AetherIIWorldgenBackportFeatures;
import juni.aether_ii_worldgen_backport.world.tree.foliage.AetherIIWorldgenBackportFoliagePlacerTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AetherIIWorldgenBackport.MODID)
public class AetherIIWorldgenBackport
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "aether_ii_worldgen_backport";

    public AetherIIWorldgenBackport()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::commonSetup);

		// Registerring
		AetherIIWorldgenBackportFeatures.FEATURES.register(modEventBus);
		AetherIIWorldgenBackportDensityFunctionTypes.DENSITY_FUNCTIONS.register(modEventBus);
		AetherIIWorldgenBackportFoliagePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

	private void commonSetup(final FMLCommonSetupEvent event) {
		Regions.register(new AetherIIWorldgenBackportRegion(new ResourceLocation(MODID, "aether_ii_worldgen_backport"), 100));
	}
}
