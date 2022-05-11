package com.archyx.aureliumskills.source.custom;

import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class CustomBlockData {

    private final String material;
    private final byte legacyData;

    private final boolean checkBlockStates;
    private Set<BlockData> includedStates;

    public CustomBlockData(String material, byte legacyData) {
        this.material = material;
        this.legacyData = legacyData;
        this.checkBlockStates = false;
    }

    public CustomBlockData(String material, byte legacyData, Set<BlockData> includedStates) {
        this.material = material;
        this.legacyData = legacyData;
        this.checkBlockStates = true;
        this.includedStates = includedStates;
    }

    public String getMaterial() {
        return material;
    }

    public byte getLegacyData() {
        return legacyData;
    }

    public boolean shouldCheckBlockStates() {
        return checkBlockStates;
    }

    @Nullable
    public Set<BlockData> getIncludedStates() {
        return includedStates;
    }


}
