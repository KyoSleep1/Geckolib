package software.bernie.example.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.example.client.renderer.entity.BatRenderer;
import software.bernie.example.entity.BatEntity;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link BatEntity}
 * @see BatRenderer
 */
public class BatModel<T extends GeoAnimatable> extends DefaultedEntityGeoModel<T> {
	// We use the alternate super-constructor here to tell the model it should handle head-turning for us
	public BatModel() {
		super(new ResourceLocation(GeckoLib.MOD_ID, "bat"), true);
	}
}
