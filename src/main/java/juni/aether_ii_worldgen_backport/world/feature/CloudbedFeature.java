package juni.aether_ii_worldgen_backport.world.feature;

import com.mojang.serialization.Codec;
import juni.aether_ii_worldgen_backport.world.feature.configuration.CloudbedConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CloudbedFeature extends Feature<CloudbedConfiguration> {

    public CloudbedFeature(Codec<CloudbedConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<CloudbedConfiguration> context) {
        int chunkX = context.origin().getX() - (context.origin().getX() % 16);
        int chunkZ = context.origin().getZ() - (context.origin().getZ() % 16);
        PerlinSimplexNoise base_noise = new PerlinSimplexNoise(new XoroshiroRandomSource(context.config().noiseXZ()), List.of(0, 1, 2, 3, 4));
        PerlinSimplexNoise y_offset = new PerlinSimplexNoise(new XoroshiroRandomSource(context.config().noiseY()), List.of(0, 1));

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                double scale = context.config().scaleXZ() * 0.00375;
                int xCoord = chunkX + x;
                int zCoord = chunkZ + z;
                double main = base_noise.getValue(xCoord * scale, zCoord * scale, false);
                double yOffset = y_offset.getValue(xCoord * scale * 0.75D, zCoord * scale * 0.75D, false);
                float offs = (float) Mth.lerp(Mth.inverseLerp(yOffset, -0.5, 0.5), 0D, 10D);
                if (main >= 0) {
                    double d1 = Mth.clamp(main, 0, 0.5) * 2;
                    float delta = costrp((float) d1, 0, 1);
                    float thicknessUp = Mth.lerp(delta, 0F, context.config().thicknessUp()) + offs;
                    float thicknessDown = Mth.lerp(delta, 0F, context.config().thicknessDown()) - offs;

                    for (int i = Mth.floor(-thicknessDown); i <= Mth.floor(thicknessUp); i++) {
                        int y = Mth.clamp(context.config().baseHeight() + i, context.level().getMinBuildHeight(), context.level().getMaxBuildHeight());
                        BlockPos pos = new BlockPos(xCoord, y, zCoord);
                        if (context.level().isStateAtPosition(pos, BlockBehaviour.BlockStateBase::isAir)) {
                            setBlock(context.level(), pos, context.config().block().getState(context.random(), pos));
                        }
                    }
                }
            }
        }
        return false;
    }
    public static float costrp(float progress, float start, float end) {
        return (((-Mth.cos((float) (Math.PI * progress)) + 1F) * 0.5F) * (end - start)) + start;
    }
}