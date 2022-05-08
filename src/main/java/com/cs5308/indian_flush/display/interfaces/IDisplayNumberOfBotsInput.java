/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display.interfaces;

public interface IDisplayNumberOfBotsInput {
	void displayNumberOfBotsInputMessage(String playerName);

	void displayNumberOfBotsErrorMessage();

	void displayNumberOfBotsSuccessMessage(int i, String playerName);
}
