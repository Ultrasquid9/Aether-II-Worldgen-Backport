package juni.aether_ii_worldgen_backport.world.feature;

import juni.aether_ii_worldgen_backport.AetherIIWorldgenBackport;
import juni.aether_ii_worldgen_backport.world.feature.configuration.CloudbedConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AetherIIWorldgenBackportFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AetherIIWorldgenBackport.MODID);

    public static RegistryObject<Feature<CloudbedConfiguration>> CLOUDBED = FEATURES.register("cloudbed", () -> new CloudbedFeature(CloudbedConfiguration.CODEC));
}