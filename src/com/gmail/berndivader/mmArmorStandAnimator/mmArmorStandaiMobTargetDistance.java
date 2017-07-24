package com.gmail.berndivader.mmArmorStandAnimator;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.ConditionAction;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import io.lumine.xikage.mythicmobs.util.types.RangedDouble;

public class mmArmorStandaiMobTargetDistance extends SkillCondition 
implements
IEntityCondition {
	protected RangedDouble distance;
	
	public mmArmorStandaiMobTargetDistance(String line, MythicLineConfig mlc) {
		super(line);
		try {
			this.ACTION = ConditionAction.valueOf(mlc.getString(new String[]{"action","a"}, "TRUE").toUpperCase());
		} catch (Exception ex) {
			this.ACTION = ConditionAction.TRUE;
		}
        String d = mlc.getString(new String[]{"distance", "d"},"5");
        this.distance = new RangedDouble(d, true);
	}

	@Override
	public boolean check(AbstractEntity entity) {
		ArmorStandAnimator asa = ArmorStandUtils.getAnimatorInstance(entity);
		if (asa!=null && asa.hasAI()) {
			ActiveMob aiMob = asa.aiMob;
			AbstractEntity target = aiMob.getEntity().getTarget();
	        double diffSq = (float)entity.getLocation().distanceSquared(target.getLocation());
	        return this.distance.equals(diffSq);
		}
		return false;
	}
}
