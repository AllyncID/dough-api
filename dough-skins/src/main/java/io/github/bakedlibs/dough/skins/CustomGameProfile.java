package io.github.bakedlibs.dough.skins;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import io.github.bakedlibs.dough.reflection.ReflectionUtils;
import io.github.bakedlibs.dough.versions.MinecraftVersion;
import io.github.bakedlibs.dough.versions.UnknownServerVersionException;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.util.UUID;

public final class CustomGameProfile {

    private static final String PLAYER_NAME = "CS-CoreLib";

    private final UUID uuid;
    private final URL skinUrl;
    private final String texture;

    CustomGameProfile(@Nonnull UUID uuid, @Nullable String texture, @Nonnull URL url) {
        this.uuid = uuid;
        this.texture = texture;
        this.skinUrl = url;
    }

    @Nonnull
    public UUID getId() {
        return uuid;
    }

    @Nullable
    public String getBase64Texture() {
        return texture;
    }

    void apply(@Nonnull SkullMeta meta)
            throws NoSuchFieldException, IllegalAccessException, UnknownServerVersionException {

        // ✅ MODERN PATH (1.20+)
        if (MinecraftVersion.get().isAtLeast(MinecraftVersion.parse("1.20"))) {

            PlayerProfile profile = Bukkit.createPlayerProfile(this.uuid, PLAYER_NAME);
            PlayerTextures textures = profile.getTextures();
            textures.setSkin(this.skinUrl);
            profile.setTextures(textures);

            meta.setOwnerProfile(profile);
            return;
        }

        // ⚠️ LEGACY PATH (< 1.20)
        GameProfile legacy = new GameProfile(this.uuid, PLAYER_NAME);

        ReflectionUtils.setFieldValue(meta, "profile", legacy);
        meta.setOwningPlayer(meta.getOwningPlayer());
        ReflectionUtils.setFieldValue(meta, "profile", legacy);
    }
}
