package io.papermc.paper.registry.data;

import io.papermc.paper.registry.RegistryBuilder;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.trim.TrimPattern;

public interface TrimPatternRegistryEntry {

    Key assetId();
    Component description();
    boolean decal();

    interface Builder extends TrimPatternRegistryEntry, RegistryBuilder<TrimPattern> {

        Builder assetId(Key assetId);
        Builder description(Component description);
        Builder decal(boolean decal);

    }
}
