package juni.aether_ii_worldgen_backport.world.biome;

import juni.aether_ii_worldgen_backport.AetherIIWorldgenBackport;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AetherIIWorldgenBackportBiomes {
	public static final ResourceKey<Biome> FLOURISHING_FIELD = register("flourishing_field");
	public static final ResourceKey<Biome> VERDANT_WOODS = register("verdant_woods");

	private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AetherIIWorldgenBackport.MODID, name));
    }
}