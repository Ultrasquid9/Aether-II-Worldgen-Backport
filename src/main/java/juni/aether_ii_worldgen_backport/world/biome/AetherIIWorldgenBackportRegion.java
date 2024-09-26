package juni.aether_ii_worldgen_backport.world.biome;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

public class AetherIIWorldgenBackportRegion extends Region {
	public AetherIIWorldgenBackportRegion(ResourceLocation name, int weight) {
		super(name, AetherRegionType.THE_AETHER, weight);
	}

	@Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
		
	}
}