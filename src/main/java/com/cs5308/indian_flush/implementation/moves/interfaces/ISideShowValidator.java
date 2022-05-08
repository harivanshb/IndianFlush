/* @Author: Meshwa Savalia */

package com.cs5308.indian_flush.implementation.moves.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Meshwa Savalia */
public interface ISideShowValidator {

	public List<String> getActivePlayersList(ArrayList<Player> players);

	public String getPreviousPlayerID(String currentPlayerId, List<String> activePlayerList);

	public List<String> getNotBlindPlayersList(ArrayList<Player> players);

	public Boolean isCurrentOrPreviousPlayerBlind(String currentPlayerId, String previousActivePlayerId,
			ArrayList<Player> players);

	public Boolean validateSideShow(Boolean isCurrentOrPreviousPlayerBlind, List<String> activePlayerList);

}
