package software.bernie.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import software.bernie.example.client.renderer.block.FertilizerBlockRenderer;
import software.bernie.example.client.renderer.block.GeckoHabitatBlockRenderer;
import software.bernie.example.client.renderer.entity.*;
import software.bernie.example.registry.BlockEntityRegistry;
import software.bernie.example.registry.BlockRegistry;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib.network.GeckoLibNetwork;

public final class ClientListener implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		if (GeckoLibMod.shouldRegisterExamples())
			registerRenderers();
		registerNetwork();
	}

	private static void registerRenderers() {
		EntityRendererRegistry.register(EntityRegistry.BAT, BatRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.BIKE, BikeRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.RACE_CAR, RaceCarRenderer::new);

		EntityRendererRegistry.register(EntityRegistry.PARASITE, ParasiteRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.COOL_KID, CoolKidRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.MUTANT_ZOMBIE, MutantZombieRenderer::new);
		EntityRendererRegistry.register(EntityRegistry.GREMLIN, GremlinRenderer::new);

		EntityRendererRegistry.register(EntityRegistry.FAKE_GLASS, FakeGlassRenderer::new);
		EntityRendererRegistry.register(EntityType.CREEPER, ReplacedCreeperRenderer::new);
		EntityRendererRegistry.register(EntityType.ZOMBIE, ReplacedZombieRenderer::new);

		BlockEntityRendererRegistry.register(BlockEntityRegistry.GECKO_HABITAT,
				context -> new GeckoHabitatBlockRenderer());
		BlockEntityRendererRegistry.register(BlockEntityRegistry.FERTILIZER_BLOCK,
				context -> new FertilizerBlockRenderer());

		BlockRenderLayerMapImpl.INSTANCE.putBlock(BlockRegistry.GECKO_HABITAT_BLOCK, RenderType.translucent());
	}

	private static void registerNetwork() {
		GeckoLibNetwork.registerClientReceiverPackets();
	}
}
