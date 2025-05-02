package io.papermc.paper.registry.data;

import io.papermc.paper.registry.RegistryBuilder;
import io.papermc.paper.registry.RegistryKey;
import it.unimi.dsi.fastutil.Pair;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import java.util.Map;

public interface TrimMaterialRegistryEntry {

    MaterialAssetGroup assets();
    Component description();

    interface MaterialAssetGroup {
        AssetInfo base();
        Map<Key, AssetInfo> overrides();

        static MaterialAssetGroup of(AssetInfo base, Map<Key, AssetInfo> overrides) {
            record Impl(AssetInfo base, Map<Key, AssetInfo> overrides) implements MaterialAssetGroup {
            }
            return new Impl(base, overrides);
        }

        interface AssetInfo {
            String suffix();

            static AssetInfo of(String suffix) {
                record Impl(String suffix) implements AssetInfo {
                }
                return new Impl(suffix);
            }
        }
    }

    interface Builder extends TrimMaterialRegistryEntry, RegistryBuilder<TrimMaterial> {
        Builder assets(MaterialAssetGroup assets);
        Builder description(Component description);
    }
}
