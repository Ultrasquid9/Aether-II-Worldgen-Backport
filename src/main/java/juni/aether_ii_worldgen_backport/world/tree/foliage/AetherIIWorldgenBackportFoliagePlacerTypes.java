package juni.aether_ii_worldgen_backport.world.tree.foliage;

import juni.aether_ii_worldgen_backport.world.tree.foliage.amberoot.*;

import juni.aether_ii_worldgen_backport.AetherIIWorldgenBackport;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AetherIIWorldgenBackportFoliagePlacerTypes {
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, AetherIIWorldgenBackport.MODID);

	public static final RegistryObject<FoliagePlacerType<LargeSkyrootFoliagePlacer>> LARGE_SKYROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("large_skyroot_foliage_placer", () -> new FoliagePlacerType<>(LargeSkyrootFoliagePlacer.CODEC));

	public static final RegistryObject<FoliagePlacerType<AmberootFoliagePlacer>> AMBEROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("amberoot_foliage_placer", () -> new FoliagePlacerType<>(AmberootFoliagePlacer.CODEC));
	public static final RegistryObject<FoliagePlacerType<SingularAmberootFoliagePlacer>> SINGULAR_AMBEROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("singular_amberoot_foliage_placer", () -> new FoliagePlacerType<>(SingularAmberootFoliagePlacer.CODEC));
	public static final RegistryObject<FoliagePlacerType<LargeAmberootFoliagePlacer>> LARGE_AMBEROOT_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("large_amberoot_foliage_placer", () -> new FoliagePlacerType<>(LargeAmberootFoliagePlacer.CODEC));
}