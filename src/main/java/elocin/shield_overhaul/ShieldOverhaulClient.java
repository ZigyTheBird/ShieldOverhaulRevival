package elocin.shield_overhaul;

import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import elocin.shield_overhaul.config.ConfigLoader;
import elocin.shield_overhaul.event.KeyInputHandler;
import elocin.shield_overhaul.networking.PacketRegistry;
import elocin.shield_overhaul.registry.RendererRegistry;
import elocin.shield_overhaul.registry.entity.EntityRegistry;
import elocin.shield_overhaul.registry.particle.ParticleClientRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

public class ShieldOverhaulClient implements ClientModInitializer {
    public static final Identifier animationLayerId = Identifier.of(ShieldOverhaul.MOD_ID, "factory");

    @Override
    public void onInitializeClient() {
        ConfigLoader.initClient();

        PacketRegistry.registerS2C();
        KeyInputHandler.initialize();
        ParticleClientRegistry.initialize();
        RendererRegistry.initializeRender();

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(
                animationLayerId,
                1500,
                player -> new ModifierLayer<>()
        );
    }
}
