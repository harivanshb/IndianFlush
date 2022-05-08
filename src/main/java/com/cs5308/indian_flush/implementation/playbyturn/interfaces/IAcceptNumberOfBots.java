/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.implementation.playbyturn.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import com.cs5308.indian_flush.implementation.player.Player;

public interface IAcceptNumberOfBots {
	ArrayList<Player> acceptNumberOfBots(Player player, Scanner scanner);
}
