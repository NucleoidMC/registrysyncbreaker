package xyz.nucleoid.registrysyncbreaker.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(value = RegistrySyncManager.class, remap = false)
public class RegistrySyncManagerMixin {
    @Inject(method = "createAndPopulateRegistryMap", at = @At("HEAD"), cancellable = true)
    private static void letThereBeNoSync(CallbackInfoReturnable<Map<Identifier, Object2IntMap<Identifier>>> cir) {
        cir.setReturnValue(null);
    }
}
