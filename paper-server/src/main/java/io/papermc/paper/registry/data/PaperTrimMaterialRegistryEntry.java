package io.papermc.paper.registry.data;

import io.papermc.paper.adventure.PaperAdventure;
import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import org.jspecify.annotations.Nullable;
import java.util.stream.Collectors;

import static io.papermc.paper.registry.data.util.Checks.*;

public class PaperTrimMaterialRegistryEntry implements TrimMaterialRegistryEntry {

    protected net.minecraft.world.item.equipment.trim.@Nullable MaterialAssetGroup assets;
    protected @Nullable Component description;

    protected final Conversions conversions;

    public PaperTrimMaterialRegistryEntry(
        final Conversions conversions,
        final @Nullable TrimMaterial trimMaterial
    ) {

        this.conversions = conversions;
        if (trimMaterial == null) return;

        this.assets = trimMaterial.assets();
        this.description = trimMaterial.description();
    }

    @Override
    public MaterialAssetGroup assets() {
        return MaterialAssetGroup.of(
            MaterialAssetGroup.AssetInfo.of(this.assets.base().suffix()),
            this.assets.overrides().entrySet().stream().collect(Collectors.toMap(
                e -> PaperAdventure.asAdventure(e.getKey().location()),
                e -> MaterialAssetGroup.AssetInfo.of(e.getValue().suffix())
            ))
        );

    }

    @Override
    public net.kyori.adventure.text.Component description() {
        return conversions.asAdventure(this.description);
    }

    public static final class PaperBuilder extends PaperTrimMaterialRegistryEntry implements Builder, PaperRegistryBuilder<TrimMaterial, org.bukkit.inventory.meta.trim.TrimMaterial> {

        public PaperBuilder(final Conversions conversions, final @Nullable TrimMaterial trimMaterial) {
            super(conversions, trimMaterial);
        }

        @Override
        public TrimMaterial build() {
            return new TrimMaterial(
                asConfigured(this.assets, "assets"),
                asConfigured(this.description, "description")
            );
        }

        @Override
        public Builder assets(final MaterialAssetGroup assets) {
            this.assets = net.minecraft.world.item.equipment.trim.MaterialAssetGroup.create(
                assets.base().suffix(),
                assets.overrides().entrySet().stream().collect(Collectors.toMap(
                    e -> ResourceKey.create(EquipmentAssets.ROOT_ID, PaperAdventure.asVanilla(e.getKey())),
                    e -> e.getValue().suffix()
                )));
            return this;
        }

        @Override
        public Builder description(final net.kyori.adventure.text.Component description) {
            this.description = conversions.asVanilla(description);
            return this;
        }
    }
}
