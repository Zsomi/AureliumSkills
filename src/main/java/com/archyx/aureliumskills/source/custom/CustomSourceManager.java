package com.archyx.aureliumskills.source.custom;

import com.archyx.aureliumskills.AureliumSkills;
import com.archyx.aureliumskills.skills.Skill;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomSourceManager {

    private final AureliumSkills plugin;
    private final Map<Skill, Map<CustomSource, Double>> customSources;
    private final CustomBlockLeveler customBlockLeveler;

    public CustomSourceManager(AureliumSkills plugin) {
        this.plugin = plugin;
        this.customSources = new HashMap<>();
        this.customBlockLeveler = new CustomBlockLeveler(plugin);
    }

    public void loadCustomSources(FileConfiguration config) {
        // TODO Loading custom sources from config
    }

    @Nullable
    public Map<CustomSource, Double> getSources(Skill skill) {
        return customSources.get(skill);
    }

    public Set<CustomSource> getAllSources() {
        Set<CustomSource> sourceSet = new HashSet<>();
        for (Map<CustomSource, Double> sourceMap : customSources.values()) {
            sourceSet.addAll(sourceMap.keySet());
        }
        return sourceSet;
    }

    public CustomBlockLeveler getLeveler() {
        return customBlockLeveler;
    }

}
