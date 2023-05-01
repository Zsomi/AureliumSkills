package dev.aurelium.skills.api.skill;

import com.google.common.collect.ImmutableList;
import dev.aurelium.skills.api.ability.Ability;
import dev.aurelium.skills.api.mana.ManaAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SkillProperties {

    @NotNull
    Skill skill();

    @NotNull
    ImmutableList<Ability> abilities();

    @Nullable
    default ManaAbility manaAbility() {
        return null;
    }

}
