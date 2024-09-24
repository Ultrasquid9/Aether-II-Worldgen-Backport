package juni.aether_ii_worldgen_backport.world.density;

import juni.aether_ii_worldgen_backport.AetherIIWorldgenBackport;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AetherIIWorldgenBackportDensityFunctionTypes {
    public static final DeferredRegister<Codec<? extends DensityFunction>> DENSITY_FUNCTIONS = DeferredRegister.create(Registries.DENSITY_FUNCTION_TYPE, AetherIIWorldgenBackport.MODID);
    
	public static RegistryObject<Codec<? extends DensityFunction>> PERLIN_NOISE = DENSITY_FUNCTIONS.register("perlin_noise", PerlinNoiseFunction.CODEC::codec);
}
