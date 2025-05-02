package io.papermc.paper.registry.event;

import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.data.BannerPatternRegistryEntry;
import io.papermc.paper.registry.data.DamageTypeRegistryEntry;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.data.GameEventRegistryEntry;
import io.papermc.paper.registry.data.PaintingVariantRegistryEntry;
import io.papermc.paper.registry.data.TrimMaterialRegistryEntry;
import io.papermc.paper.registry.data.TrimPatternRegistryEntry;
import org.bukkit.Art;
import org.bukkit.GameEvent;
import org.bukkit.block.banner.PatternType;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

import static io.papermc.paper.registry.event.RegistryEventProviderImpl.create;

/**
 * Holds providers for {@link RegistryEntryAddEvent} and {@link RegistryFreezeEvent}
 * handlers for each applicable registry.
 */
@ApiStatus.Experimental
@NullMarked
public final class RegistryEvents {

    // Start generate - RegistryEvents
    // @GeneratedFrom 1.21.5
    public static final RegistryEventProvider<GameEvent, GameEventRegistryEntry.Builder> GAME_EVENT = create(RegistryKey.GAME_EVENT);
    public static final RegistryEventProvider<DamageType, DamageTypeRegistryEntry.Builder> DAMAGE_TYPE = create(RegistryKey.DAMAGE_TYPE);
    public static final RegistryEventProvider<Enchantment, EnchantmentRegistryEntry.Builder> ENCHANTMENT = create(RegistryKey.ENCHANTMENT);
    public static final RegistryEventProvider<PatternType, BannerPatternRegistryEntry.Builder> BANNER_PATTERN = create(RegistryKey.BANNER_PATTERN);
    public static final RegistryEventProvider<Art, PaintingVariantRegistryEntry.Builder> PAINTING_VARIANT = create(RegistryKey.PAINTING_VARIANT);
    public static final RegistryEventProvider<TrimPattern, TrimPatternRegistryEntry.Builder> TRIM_PATTERN = create(RegistryKey.TRIM_PATTERN);
    public static final RegistryEventProvider<TrimMaterial, TrimMaterialRegistryEntry.Builder> TRIM_MATERIAL = create(RegistryKey.TRIM_MATERIAL);
    // End generate - RegistryEvents

    private RegistryEvents() {
    }
}
