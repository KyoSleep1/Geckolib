package software.bernie.example.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Replacement {@link net.minecraft.world.entity.monster.Creeper} {@link GeoEntity} to showcase
 * replacing the model and animations of an existing entity
 * @see software.bernie.geckolib.renderer.GeoReplacedEntityRenderer
 * @see software.bernie.example.client.renderer.entity.ReplacedCreeperRenderer
 * @see software.bernie.example.client.model.entity.ReplacedCreeperModel
 */
public class ReplacedZombieEntity implements GeoReplacedEntity {

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(
				// Add our flying animation controller
				new AnimationController<>(this, 10, state -> state.setAndContinue(DefaultAnimations.FLY))
						.setCustomInstructionKeyframeHandler(state -> {
							Player player = ClientUtils.getClientPlayer();

							if (player != null)
								player.displayClientMessage(Component.literal("KeyFraming"), true);
						}),
				// Add our generic living animation controller
				DefaultAnimations.genericLivingController(this)
		);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public EntityType<?> getReplacingEntityType() {
		return EntityType.ZOMBIE;
	}
}
