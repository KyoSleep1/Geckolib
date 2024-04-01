package software.bernie.example.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Zombie;
import software.bernie.example.client.model.entity.BatModel;
import software.bernie.example.client.model.entity.ReplacedCreeperModel;
import software.bernie.example.entity.ReplacedCreeperEntity;
import software.bernie.example.entity.ReplacedZombieEntity;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

/**
 * Example replacement renderer for a {@link net.minecraft.world.entity.monster.Zombie}.<br>
 * This functionally replaces the model and animations of an existing entity without needing to replace the entity entirely
 * @see GeoReplacedEntityRenderer
 * @see ReplacedCreeperEntity
 */
public class ReplacedZombieRenderer extends GeoReplacedEntityRenderer<Zombie, ReplacedZombieEntity> {
	public ReplacedZombieRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BatModel<>(), new ReplacedZombieEntity());
	}
}
