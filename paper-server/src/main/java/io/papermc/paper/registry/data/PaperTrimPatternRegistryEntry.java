package io.papermc.paper.registry.data;

import io.papermc.paper.adventure.PaperAdventure;
import io.papermc.paper.registry.PaperRegistryBuilder;
import io.papermc.paper.registry.data.util.Conversions;
import net.kyori.adventure.key.Key;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import org.jspecify.annotations.Nullable;

import static io.papermc.paper.registry.data.util.Checks.*;

public class PaperTrimPatternRegistryEntry implements TrimPatternRegistryEntry{

    protected @Nullable ResourceLocation assetId;
    protected @Nullable Component description;
    protected boolean decal;

    protected final Conversions conversions;

    public PaperTrimPatternRegistryEntry(
        final Conversions conversions,
        final @Nullable TrimPattern trimPattern
        ) {
        this.conversions = conversions;
        if (trimPattern == null) return;

        this.assetId = trimPattern.assetId();
        this.description = trimPattern.description();
        this.decal = trimPattern.decal();
    }

    @Override
    public Key assetId() {
        return PaperAdventure.asAdventure(this.assetId);
    }

    @Override
    public net.kyori.adventure.text.Component description() {
        return conversions.asAdventure(this.description);
    }

    @Override
    public boolean decal() {
        return this.decal;
    }


    public static final class PaperBuilder extends PaperTrimPatternRegistryEntry implements Builder, PaperRegistryBuilder<TrimPattern, org.bukkit.inventory.meta.trim.TrimPattern> {

        public PaperBuilder(final Conversions conversions, final @Nullable TrimPattern trimPattern) {
            super(conversions, trimPattern);
        }

        @Override
        public TrimPattern build() {
            return new TrimPattern(
                asConfigured(this.assetId, "assetId"),
                asConfigured(this.description, "description"),
                this.decal()
            );
        }

        @Override
        public Builder assetId(final Key assetId) {
            this.assetId = PaperAdventure.asVanilla(assetId);
            return this;
        }

        @Override
        public Builder description(final net.kyori.adventure.text.Component description) {
            this.description = conversions.asVanilla(description);
            return this;
        }

        @Override
        public Builder decal(final boolean decal) {
            this.decal = decal;
            return this;
        }
    }
}
