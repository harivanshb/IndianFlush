/* @Author: Meshwa Savalia */
package com.cs5308.indian_flush.implementation.moves;

import java.util.ArrayList;
import java.util.List;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.ISideShowValidator;
import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Meshwa Savalia */
public class SideShowValidator implements ISideShowValidator {

	List<String> activePlayerList = new ArrayList<>();
	public final int SIDE_SHOW_VALID_COUNT=3;

	/* @Author: Meshwa Savalia */
	public List<String> getActivePlayersList(ArrayList<Player> players) {
		for (Player player : players) {
			if (Boolean.TRUE.equals(player.getPlayersIsActiveMapping())) {
				activePlayerList.add(player.getPlayerId());
			}
		}
		return activePlayerList;
	}

	/* @Author: Meshwa Savalia */
	public String getPreviousPlayerID(String currentPlayerId, List<String> activePlayerList) {
		String previousActivePlayerId = "";
		for (int index = 0; index < activePlayerList.size(); index++) {
			if (currentPlayerId.equals(activePlayerList.get(index))) {
				if (index == 0) {
					previousActivePlayerId = activePlayerList.get(activePlayerList.size() - 1);
				} else {
					previousActivePlayerId = activePlayerList.get(index - 1);
				}
			}
		}
		return previousActivePlayerId;
	}

	/* @Author: Meshwa Savalia */
	public List<String> getNotBlindPlayersList(ArrayList<Player> players) {
		List<String> notBlindPlayersList = new ArrayList<>();
		for (Player player : players) {
			if (Boolean.FALSE.equals(player.getPlayersIsBlindMapping())) {
				notBlindPlayersList.add(player.getPlayerId());
			}
		}
		return notBlindPlayersList;
	}

	/* @Author: Meshwa Savalia */
	public Boolean isCurrentOrPreviousPlayerBlind(String currentPlayerId, String previousActivePlayerId,
			ArrayList<Player> players) {
		boolean isCurrentOrPreviousPlayerBlind = false;
		for (Player player : players) {
			if ((player.getPlayerId().equals(previousActivePlayerId) && player.getPlayersIsBlindMapping())
					|| (player.getPlayerId().equals(currentPlayerId) && player.getPlayersIsBlindMapping())) {
				isCurrentOrPreviousPlayerBlind = true;
				break;
			}
		}
		return isCurrentOrPreviousPlayerBlind;
	}

	/* @Author: Meshwa Savalia */
	public Boolean validateSideShow(Boolean isCurrentOrPreviousPlayerBlind, List<String> activePlayerList) {
		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();
		boolean isSideShowAllowed = false;

		if (activePlayerList.size() < SIDE_SHOW_VALID_COUNT) {
			displayAbstractFactory.displayInvalidPlayersSideShow().displayInvalidPlayersSideShow();
		}
		else if (Boolean.TRUE.equals(isCurrentOrPreviousPlayerBlind)) {
			displayAbstractFactory.displayBlindPlayersSideShow().displayBlindPlayersSideShow();
		}
		else {
			isSideShowAllowed = true;
		}
		return isSideShowAllowed;
	}
}
