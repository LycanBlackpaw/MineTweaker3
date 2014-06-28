package minetweaker.mc1710;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import minetweaker.MineTweakerAPI;
import minetweaker.mc1710.network.MineTweakerLoadScriptsPacket;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 *
 * @author Stan
 */
public class FMLEventHandler {
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent ev) {
		if (ev.player instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) ev.player;
			MineTweakerMod.NETWORK.sendTo(
					new MineTweakerLoadScriptsPacket(MineTweakerAPI.tweaker.getScriptData()),
					player);
		}
	}
}