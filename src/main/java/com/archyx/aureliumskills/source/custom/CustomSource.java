package com.archyx.aureliumskills.source.custom;

import com.archyx.aureliumskills.skills.Skill;
import com.archyx.aureliumskills.source.Source;
import org.bukkit.inventory.ItemStack;

public class CustomSource implements Source {

    private final Skill skill;
    private final String name;
    private final ItemStack menuItem;

    public CustomSource(Skill skill, String name, ItemStack menuItem) {
        this.skill = skill;
        this.name = name;
        this.menuItem = menuItem;
    }

    @Override
    public Skill getSkill() {
        return skill;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public ItemStack getMenuItem() {
        return menuItem;
    }
}
