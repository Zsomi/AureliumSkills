package com.archyx.aureliumskills.source.custom;

import com.archyx.aureliumskills.skills.Skill;
import com.archyx.aureliumskills.source.BlockSource;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;
import java.util.Set;

public class CustomBlockSource extends CustomSource implements BlockSource {

    private CustomBlockData blockData;

    public CustomBlockSource(Skill skill, String name, ItemStack menuItem) {
        super(skill, name, menuItem);
    }

    @Override
    public String toString() {
        return blockData.getMaterial().toUpperCase(Locale.ROOT); // Use the material as the name
    }

    @Override
    public String getLegacyMaterial() {
        return blockData.getMaterial();
    }

    @Override
    public byte getLegacyData() {
        return blockData.getLegacyData();
    }

    @Override
    public boolean allowBothIfLegacy() {
        return false;
    }

    // Checks if the provided block is this custom block source
    @Override
    public boolean isMatch(Block block) {
        boolean matchedMaterial = BlockSource.super.isMatch(block); // Check that the material matches
        if (matchedMaterial) {
            if (blockData.shouldCheckBlockStates()) { // Check block states
                Set<BlockData> includedStates = blockData.getIncludedStates();
                if (includedStates != null) {
                    for (BlockData blockData : includedStates) {
                        if (block.getBlockData().matches(blockData)) {
                            return true; // Matches block data
                        }
                    }
                }
                return false; // Does not match if no block states matched
            } else {
                return true; // Matches if passed material filter and does not need to check block states
            }
        } else {
            return false; // Does not match regular material filter
        }
    }

}
