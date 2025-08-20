package net.augustus.modules.movement;

import net.augustus.events.EventUpdate;
import net.augustus.modules.Categorys;
import net.augustus.modules.Module;
import net.augustus.settings.DoubleValue;
import net.augustus.settings.StringValue;
import net.augustus.utils.MoveUtil;
import net.lenni0451.eventapi.reflection.EventTarget;

import java.awt.*;

public class LongJump extends Module {
   public StringValue mode = new StringValue(6932235, "Mode", this, "Vanilla", new String[]{
       "Vanilla", "HypixelBow", "HypixelFireball", "GrimVelocity", "GrimBoat", 
       "Hypixel", "Vulcan", "NormalHypixelFireball"
   });
   public DoubleValue speed = new DoubleValue(44, "Speed", this, 3.4, 0, 9, 2);
   private boolean flag;

   public LongJump() {
      super("LongJump", Color.ORANGE, Categorys.MOVEMENT);
   }

   @Override
   public void onEnable() {
      super.onEnable();
      flag = false;
      switch (mode.getSelected()) {
         case "Vanilla":
         case "HypixelBow":
         case "HypixelFireball":
         case "GrimVelocity":
         case "GrimBoat":
         case "Hypixel":
         case "Vulcan":
         case "NormalHypixelFireball": {
            mc.thePlayer.jump();
            break;
         }
      }
   }

   @EventTarget
   public void onUpdate(EventUpdate eventUpdate) {
      if (mc.thePlayer.onGround) {
         if (flag) {
            toggle();
         }
         flag = true;
      }
      switch (mode.getSelected()) {
         case "Vanilla": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue());
            } else {
               MoveUtil.strafe();
            }
            break;
         }
         case "HypixelBow": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue() * 0.75); // Mimics HypixelBowLongJump strafe
               mc.thePlayer.jump();
            } else {
               mc.thePlayer.motionY += 0.028; // Small vertical boost like HypixelBowLongJump
               MoveUtil.strafe(speed.getValue() * 0.8);
            }
            break;
         }
         case "HypixelFireball": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue() * 1.5); // Uses speed setting like HypixelFireballLongJump
               mc.thePlayer.jump();
            } else {
               MoveUtil.strafe(speed.getValue());
            }
            break;
         }
         case "GrimVelocity": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue()); // Strafe with configured speed
               mc.thePlayer.jump();
            } else {
               mc.thePlayer.motionY += 0.02; // Small vertical boost
               MoveUtil.strafe(speed.getValue() * 0.9);
            }
            break;
         }
         case "GrimBoat": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue()); // Strafe with configured speed
               mc.thePlayer.jump();
            } else {
               mc.thePlayer.motionY = speed.getValue() / 9.0; // Vertical boost based on speed
               MoveUtil.strafe(speed.getValue());
            }
            break;
         }
         case "Hypixel": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue() - 0.01); // Slightly reduced speed like HypixelLongJump
               mc.thePlayer.jump();
            } else {
               MoveUtil.strafe(speed.getValue() * 0.9);
            }
            break;
         }
         case "Vulcan": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue());
               mc.thePlayer.jump();
               mc.thePlayer.motionY = 0.0; // Mimics VulcanLongJump teleport effect
            } else {
               mc.thePlayer.motionY = -0.098; // Falling motion like VulcanLongJump
               MoveUtil.strafe(speed.getValue());
            }
            break;
         }
         case "NormalHypixelFireball": {
            if (mc.thePlayer.onGround) {
               MoveUtil.strafe(speed.getValue() * 1.3); // Slightly higher speed
               mc.thePlayer.jump();
            } else {
               mc.thePlayer.motionY = speed.getValue() / 7.0; // Vertical boost like NormalHypixelFireballLongJump
               MoveUtil.strafe(speed.getValue());
            }
            break;
         }
      }
   }
}