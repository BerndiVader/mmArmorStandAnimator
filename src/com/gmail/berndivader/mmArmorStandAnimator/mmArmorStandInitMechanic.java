package com.gmail.berndivader.mmArmorStandAnimator;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.INoTargetSkill;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;

public class mmArmorStandInitMechanic extends SkillMechanic implements INoTargetSkill, ITargetedEntitySkill {

	private String animFile;
	private boolean base;

	public mmArmorStandInitMechanic(String skill, MythicLineConfig mlc) {
		super(skill, mlc);
		this.animFile = mlc.getString(new String[]{"animation","anim","a"},"");
		this.base = mlc.getBoolean(new String[]{"base","plate"},false);

	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
		return ArmorStandUtils.initArmorStandAnim(target, this.animFile, this.base);
	}

	@Override
	public boolean cast(SkillMetadata data) {
		return ArmorStandUtils.initArmorStandAnim(data.getCaster().getEntity(), this.animFile, this.base);
	}
}
