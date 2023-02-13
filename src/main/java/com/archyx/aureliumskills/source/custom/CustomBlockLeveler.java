package com.archyx.aureliumskills.source.custom;

import com.archyx.aureliumskills.AureliumSkills;
import com.archyx.aureliumskills.leveler.SkillLeveler;
import com.archyx.aureliumskills.skills.Skill;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Map;

public class CustomBlockLeveler extends SkillLeveler {

    public CustomBlockLeveler(AureliumSkills plugin) {
        super(plugin);
    }

    public void checkCustomBlocks(Player player, Block block, Skill skill) {
        Map<CustomSource, Double> customSources = plugin.getSourceManager().getCustomSourceManager().getSources(skill);
        if (customSources == null) return;

        for (Map.Entry<CustomSource, Double> entry : customSources.entrySet()) {
            CustomSource source = entry.getKey();
            if (source instanceof CustomBlockSource) {
                CustomBlockSource blockSource = (CustomBlockSource) source;
                if (blockSource.isMatch(block)) { // Block matches custom source
                    double xp = entry.getValue();
                    plugin.getLeveler().addXp(player, skill, getAbilityXp(player, xp, skill.getXpMultiplierAbility()));
                }
            }
        }
    }

}
