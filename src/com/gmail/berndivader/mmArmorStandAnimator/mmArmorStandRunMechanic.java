package com.gmail.berndivader.mmArmorStandAnimator;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.INoTargetSkill;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;

public class mmArmorStandRunMechanic extends SkillMechanic implements INoTargetSkill, ITargetedEntitySkill {

	public mmArmorStandRunMechanic(String skill, MythicLineConfig mlc) {
		super(skill, mlc);
		this.ASYNC_SAFE=false;
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
		return ArmorStandUtils.startArmorStandAnimation(target);
	}

	@Override
	public boolean cast(SkillMetadata data) {
		return ArmorStandUtils.startArmorStandAnimation(data.getCaster().getEntity());
	}
}
