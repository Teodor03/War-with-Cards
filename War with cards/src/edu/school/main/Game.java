package edu.school.main;

import java.util.ArrayList;

public class Game {

	private int[] starting_deck;
	private int[] mixed_starting_deck;
	private ArrayList<Integer> decks_of_player_one;
	private ArrayList<Integer> decks_of_player_two;
	private ArrayList<Integer> decks_of_player_three;
	private ArrayList<Integer> decks_of_player_four;
	private boolean is_first_player_alive = true;
	private boolean is_second_player_alive = true;
	private boolean is_third_player_alive = true;
	private boolean is_four_player_alive = true;
	private int how_much_rounds_are_played=0,how_much_wars_are_played=0;

	public Game() {
		starting_deck = new int[52];
		for (int adding_starting_cards = 0; adding_starting_cards < 52; adding_starting_cards++) {
			starting_deck[adding_starting_cards] = adding_starting_cards;
		}
		decks_of_player_one = new ArrayList<Integer>();
		decks_of_player_two = new ArrayList<Integer>();
		decks_of_player_three = new ArrayList<Integer>();
		decks_of_player_four = new ArrayList<Integer>();
		System.out.println("Game has started!");
		System.out.println("");
	}

	public boolean has_the_game_finished() {
		int number_of_deth = 0;
		if (is_first_player_alive == false) {
			number_of_deth++;
		}
		if (is_second_player_alive == false) {
			number_of_deth++;
		}
		if (is_third_player_alive == false) {
			number_of_deth++;
		}
		if (is_four_player_alive == false) {
			number_of_deth++;
		}
		if (number_of_deth == 3) {
			System.out.println();
			if (is_first_player_alive) {
				System.out.println("First player won the game! Statistics: Rounds played: "+how_much_rounds_are_played+" Wars played: "+how_much_wars_are_played);
			}
			if (is_second_player_alive) {
				System.out.println("Second player won the game! Statistics: Rounds played: "+how_much_rounds_are_played+" Wars played: "+how_much_wars_are_played);
			}
			if (is_third_player_alive) {
				System.out.println("Third player won the game! Statistics: Rounds played: "+how_much_rounds_are_played+" Wars played: "+how_much_wars_are_played);
			}
			if (is_four_player_alive) {
				System.out.println("Four player won the game! Statistics: Rounds played: "+how_much_rounds_are_played+" Wars played: "+how_much_wars_are_played);
			}
			return true;
		} else {
			return false;
		}

	}

	public void mixing_an_array() {
		System.out.println("Starting mixing cards!");
		System.out.println("Order of mixed cards:");
		int[] mixed_array = new int[starting_deck.length];
		for (int adding_starting_cards_of_mixed_array = 0; adding_starting_cards_of_mixed_array < 52; adding_starting_cards_of_mixed_array++) {
			mixed_array[adding_starting_cards_of_mixed_array] = -1;
		}
		int random;
		boolean is_placed = false;
		for (int placed_number = 0; placed_number < mixed_array.length; placed_number++) {
			while (is_placed == false) {
				random = (int) Math.round(Math.random() * 51);
				if (mixed_array[random] == -1) {
					System.out.print(" " + random);
					mixed_array[random] = starting_deck[placed_number];
					is_placed = true;
				}
			}
			is_placed = false;
		}
		mixed_starting_deck = mixed_array;
		System.out.println();
		System.out.println();
	}

	public void sending_cards_to_players() {
		System.out.println("Starting sending cards to players!");
		for (int sending_cards = 0; sending_cards < 52; sending_cards = sending_cards + 4) {
			decks_of_player_one.add(mixed_starting_deck[sending_cards]);
			decks_of_player_two.add(mixed_starting_deck[sending_cards + 1]);
			decks_of_player_three.add(mixed_starting_deck[sending_cards + 2]);
			decks_of_player_four.add(mixed_starting_deck[sending_cards + 3]);
		}
		System.out.println("Sending finished! Results:");
		System.out.println("First player gets starting cards:");
		for (int counter = 0; counter < decks_of_player_one.size(); counter++) {
			System.out.print(" " + decks_of_player_one.get(counter));
		}
		System.out.println();
		System.out.println("Second player gets starting cards:");
		for (int counter = 0; counter < decks_of_player_one.size(); counter++) {
			System.out.print(" " + decks_of_player_two.get(counter));
		}
		System.out.println();
		System.out.println("Third player gets starting cards:");
		for (int counter = 0; counter < decks_of_player_one.size(); counter++) {
			System.out.print(" " + decks_of_player_three.get(counter));
		}
		System.out.println();
		System.out.println("Four player gets starting cards:");
		for (int counter = 0; counter < decks_of_player_one.size(); counter++) {
			System.out.print(" " + decks_of_player_four.get(counter));
		}
		System.out.println();
		System.out.println();
	}

	public void play() {
		if (has_the_game_finished() == true) {
			return;
		}else {
		how_much_rounds_are_played++;
		}
		System.out.print("Starting the round. Cards of players:");
		int[] powers_of_people = new int[4];
		int the_biggest = -1, number_of_people_in_the_war = 0;
		boolean is_first_player_in_war = false;
		boolean is_second_player_in_war = false;
		boolean is_third_player_in_war = false;
		boolean is_four_player_in_war = false;
		ArrayList<Integer> pledged_cards = new ArrayList<Integer>();

		if (decks_of_player_one.size() > 0) {
			powers_of_people[0] = decks_of_player_one.get(0) % 13;
			System.out.print(" " + decks_of_player_one.get(0));
			pledged_cards.add(decks_of_player_one.get(0));
		} else {
			powers_of_people[0] = -1;
			is_first_player_alive = false;
			if (has_the_game_finished() == true) {
				return;
			}
			System.out.print(" -");
		}

		if (decks_of_player_two.size() > 0) {
			powers_of_people[1] = decks_of_player_two.get(0) % 13;
			System.out.print(" " + decks_of_player_two.get(0));
			pledged_cards.add(decks_of_player_two.get(0));
		} else {
			powers_of_people[1] = -1;
			is_second_player_alive = false;
			if (has_the_game_finished() == true) {
				return;
			}
			System.out.print(" -");
		}

		if (decks_of_player_three.size() > 0) {
			powers_of_people[2] = decks_of_player_three.get(0) % 13;
			System.out.print(" " + decks_of_player_three.get(0));
			pledged_cards.add(decks_of_player_three.get(0));
		} else {
			powers_of_people[2] = -1;
			is_third_player_alive = false;
			if (has_the_game_finished() == true) {
				return;
			}
			System.out.print(" -");
		}

		if (decks_of_player_four.size() > 0) {
			powers_of_people[3] = decks_of_player_four.get(0) % 13;
			System.out.println(" " + decks_of_player_four.get(0));
			pledged_cards.add(decks_of_player_four.get(0));
		} else {
			powers_of_people[3] = -1;
			is_four_player_alive = false;
			if (has_the_game_finished() == true) {
				return;
			}
			System.out.println(" -");
		}

		get_a_card_from_all_the_players(0);

		for (int counter = 0; counter < 4; counter++) {
			if (powers_of_people[counter] > the_biggest) {
				the_biggest = powers_of_people[counter];
			}
		}
		if (powers_of_people[0] == the_biggest) {
			is_first_player_in_war = true;
			number_of_people_in_the_war++;
		}
		if (powers_of_people[1] == the_biggest) {
			is_second_player_in_war = true;
			number_of_people_in_the_war++;
		}
		if (powers_of_people[2] == the_biggest) {
			is_third_player_in_war = true;
			number_of_people_in_the_war++;
		}
		if (powers_of_people[3] == the_biggest) {
			is_four_player_in_war = true;
			number_of_people_in_the_war++;
		}
		if (number_of_people_in_the_war > 1) {
			System.out.println("Round fineshed with war. Players in war - " + is_first_player_in_war + " "
					+ is_second_player_in_war + " " + is_third_player_in_war + " " + is_four_player_in_war);
			recursive_war(is_first_player_in_war, is_second_player_in_war, is_third_player_in_war,
					is_four_player_in_war, pledged_cards);
		} else {
			if (is_first_player_in_war == true) {
				System.out.println("Round fineshed without war. First player won the round. First player won cards: ");
				for (int counter = 0; counter < pledged_cards.size(); counter++) {
					System.out.print(" " + pledged_cards.get(counter));
					decks_of_player_one.add(pledged_cards.get(counter));
				}
			}
			if (is_second_player_in_war == true) {
				System.out
						.println("Round fineshed without war. Second player won the round. Second player won cards: ");
				for (int counter = 0; counter < pledged_cards.size(); counter++) {
					System.out.print(" " + pledged_cards.get(counter));
					decks_of_player_two.add(pledged_cards.get(counter));
				}
			}
			if (is_third_player_in_war == true) {
				System.out.println("Round fineshed without war. Third player won the round. Third player won cards: ");
				for (int counter = 0; counter < pledged_cards.size(); counter++) {
					System.out.print(" " + pledged_cards.get(counter));
					decks_of_player_three.add(pledged_cards.get(counter));
				}
			}
			if (is_four_player_in_war == true) {
				System.out.println("Round fineshed without war. Four player won the round. Four player won cards: ");
				for (int counter = 0; counter < pledged_cards.size(); counter++) {
					System.out.print(" " + pledged_cards.get(counter));
					decks_of_player_four.add(pledged_cards.get(counter));
				}
			}

		}
		System.out.println();
	}

	private void get_a_card_from_all_the_players(int index) {
		if (decks_of_player_one.size() > 0) {
			decks_of_player_one.remove(index);
		}
		if (decks_of_player_two.size() > 0) {
			decks_of_player_two.remove(index);
		}
		if (decks_of_player_three.size() > 0) {
			decks_of_player_three.remove(index);
		}
		if (decks_of_player_four.size() > 0) {
			decks_of_player_four.remove(index);
		}
	}

	private void recursive_war(boolean is_first_player_in_war, boolean is_second_player_in_war,
			boolean is_three_player_in_war, boolean is_four_player_in_war, ArrayList<Integer> list_of_pledged_cards) {
		if (has_the_game_finished() == true) {
			return;
		}else {
			how_much_wars_are_played++;
		}
		System.out.println();
		System.out.println("War starting. Cards in the war:");
		int[] powerful_cards_of_players = new int[4];
		boolean is_first_player_continuing_in_war = false;
		boolean is_second_player_continuing_in_war = false;
		boolean is_three_player_continuing_in_war = false;
		boolean is_four_player_continuing_in_war = false;
		int number_of_people_continuing_in_war = 0;
		for (int counter = 0; counter < 4; counter++) {
			powerful_cards_of_players[counter] = -1;
		}

		if (is_first_player_in_war) {
			if (decks_of_player_one.size() >= 3) {
				powerful_cards_of_players[0] = decks_of_player_one.get(2);
				System.out.println("First player cards:" + decks_of_player_one.get(0) + " , "
						+ decks_of_player_one.get(1) + " , " + decks_of_player_one.get(2));
				list_of_pledged_cards.add(decks_of_player_one.get(0));
				list_of_pledged_cards.add(decks_of_player_one.get(1));
				list_of_pledged_cards.add(decks_of_player_one.get(2));
				try {
					decks_of_player_one.remove(0);
					decks_of_player_one.remove(1);
					decks_of_player_one.remove(2);
				} catch (Exception e) {
					System.out.println("Error" + decks_of_player_one.size());
				}
			} else {
				if (decks_of_player_one.size() == 2) {
					System.out.println("First player cards:" + decks_of_player_one.get(0) + " , "
							+ decks_of_player_one.get(1) + " - ");
					powerful_cards_of_players[0] = decks_of_player_one.get(1);
					list_of_pledged_cards.add(decks_of_player_one.get(0));
					list_of_pledged_cards.add(decks_of_player_one.get(1));
					try {
						decks_of_player_one.remove(0);
						decks_of_player_one.remove(1);
					} catch (Exception e) {
						System.out.println("Error" + decks_of_player_one.size());
					}
				} else {
					if (decks_of_player_one.size() == 1) {
						System.out.println("First player cards:" + decks_of_player_one.get(0) + " , - , - ");
						powerful_cards_of_players[0] = decks_of_player_one.get(0);
						list_of_pledged_cards.add(decks_of_player_one.get(0));
						decks_of_player_one.remove(0);
					} else {
						if (decks_of_player_one.size() == 0) {
							is_first_player_alive = false;
							if (has_the_game_finished() == true) {
								return;
							}
						}
					}
				}
			}
		}

		if (is_second_player_in_war) {
			if (decks_of_player_two.size() > 2) {
				powerful_cards_of_players[1] = decks_of_player_two.get(2);
				System.out.println("Second player cards:" + decks_of_player_two.get(0) + " , "
						+ decks_of_player_two.get(1) + " , " + decks_of_player_two.get(2));
				list_of_pledged_cards.add(decks_of_player_two.get(0));
				list_of_pledged_cards.add(decks_of_player_two.get(1));
				list_of_pledged_cards.add(decks_of_player_two.get(2));
				try {
					decks_of_player_two.remove(0);
					decks_of_player_two.remove(1);
					decks_of_player_two.remove(2);
				} catch (Exception e) {
					System.out.println("Error" + decks_of_player_one.size());
				}

			} else {
				if (decks_of_player_two.size() == 2) {
					System.out.println("Second player cards:" + decks_of_player_two.get(0) + " , "
							+ decks_of_player_two.get(1) + " - ");
					powerful_cards_of_players[1] = decks_of_player_two.get(1);
					list_of_pledged_cards.add(decks_of_player_two.get(0));
					list_of_pledged_cards.add(decks_of_player_two.get(1));
					try {
						decks_of_player_two.remove(0);
						decks_of_player_two.remove(1);
					} catch (Exception e) {
						System.out.println("Error" + decks_of_player_one.size());
					}
				} else {
					if (decks_of_player_two.size() == 1) {
						System.out.println("Second player cards:" + decks_of_player_two.get(0) + " , - , - ");
						powerful_cards_of_players[1] = decks_of_player_two.get(0);
						list_of_pledged_cards.add(decks_of_player_two.get(0));
						decks_of_player_two.remove(0);
					} else {
						if (decks_of_player_two.size() == 0) {
							is_second_player_alive = false;
							if (has_the_game_finished() == true) {
								return;
							}
						}
					}
				}
			}
		}
		if (is_three_player_in_war) {
			if (decks_of_player_three.size() >= 3) {
				powerful_cards_of_players[2] = decks_of_player_three.get(2);
				System.out.println("Third player cards:" + decks_of_player_three.get(0) + " , "
						+ decks_of_player_three.get(1) + " , " + decks_of_player_three.get(2));
				list_of_pledged_cards.add(decks_of_player_three.get(0));
				list_of_pledged_cards.add(decks_of_player_three.get(1));
				list_of_pledged_cards.add(decks_of_player_three.get(2));
				try {
					decks_of_player_three.remove(0);
					decks_of_player_three.remove(1);
					decks_of_player_three.remove(2);
				} catch (Exception e) {
					System.out.println("Error" + decks_of_player_one.size());
				}
			} else {
				if (decks_of_player_three.size() == 2) {
					System.out.println("Third player cards:" + decks_of_player_three.get(0) + " , "
							+ decks_of_player_three.get(1) + " - ");
					powerful_cards_of_players[2] = decks_of_player_three.get(1);
					list_of_pledged_cards.add(decks_of_player_three.get(0));
					list_of_pledged_cards.add(decks_of_player_three.get(1));
					try {
						decks_of_player_three.remove(0);
						decks_of_player_three.remove(1);
					} catch (Exception e) {
						System.out.println("Error" + decks_of_player_one.size());
					}
				} else {
					if (decks_of_player_three.size() == 1) {
						System.out.println("Third player cards:" + decks_of_player_three.get(0) + " , - , - ");
						powerful_cards_of_players[2] = decks_of_player_three.get(0);
						list_of_pledged_cards.add(decks_of_player_three.get(0));
						decks_of_player_three.remove(0);
					} else {
						if (decks_of_player_three.size() == 0) {
							is_third_player_alive = false;
							if (has_the_game_finished() == true) {
								return;
							}
						}
					}
				}
			}
		}

		if (is_four_player_in_war) {
			if (decks_of_player_four.size() >= 3) {
				powerful_cards_of_players[3] = decks_of_player_four.get(2);
				System.out.println("Four player cards:" + decks_of_player_four.get(0) + " , "
						+ decks_of_player_four.get(1) + " , " + decks_of_player_four.get(2));
				list_of_pledged_cards.add(decks_of_player_four.get(0));
				list_of_pledged_cards.add(decks_of_player_four.get(1));
				list_of_pledged_cards.add(decks_of_player_four.get(2));
				try {
					decks_of_player_four.remove(0);
					decks_of_player_four.remove(1);
					decks_of_player_four.remove(2);
				} catch (Exception e) {
					System.out.println("Error" + decks_of_player_one.size());
				}
			} else {
				if (decks_of_player_four.size() == 2) {
					System.out.println("Four player cards:" + decks_of_player_four.get(0) + " , "
							+ decks_of_player_four.get(1) + " - ");
					powerful_cards_of_players[3] = decks_of_player_four.get(1);
					list_of_pledged_cards.add(decks_of_player_four.get(0));
					list_of_pledged_cards.add(decks_of_player_four.get(1));
					try {
						decks_of_player_four.remove(0);
						decks_of_player_four.remove(1);
					} catch (Exception e) {
						System.out.println("Error" + decks_of_player_one.size());
					}
				} else {
					if (decks_of_player_four.size() == 1) {
						System.out.println("Four player cards:" + decks_of_player_four.get(0) + " , - , - ");
						powerful_cards_of_players[3] = decks_of_player_four.get(0);
						list_of_pledged_cards.add(decks_of_player_four.get(0));
						decks_of_player_four.remove(0);
					} else {
						if (decks_of_player_four.size() == 0) {
							is_four_player_alive = false;
							if (has_the_game_finished() == true) {
								return;
							}
						}
					}
				}
			}
		}

		int the_biggest = -1;
		for (int counter = 0; counter < powerful_cards_of_players.length; counter++) {
			if (powerful_cards_of_players[counter] == -1) {
			} else {
				if (powerful_cards_of_players[counter] % 13 > the_biggest) {
					the_biggest = powerful_cards_of_players[counter] % 13;
				}
			}
		}

		if (powerful_cards_of_players[0] % 13 == the_biggest) {
			is_first_player_continuing_in_war = true;
			number_of_people_continuing_in_war++;
		}
		if (powerful_cards_of_players[1] % 13 == the_biggest) {
			is_second_player_continuing_in_war = true;
			number_of_people_continuing_in_war++;
		}
		if (powerful_cards_of_players[2] % 13 == the_biggest) {
			is_three_player_continuing_in_war = true;
			number_of_people_continuing_in_war++;
		}
		if (powerful_cards_of_players[3] % 13 == the_biggest) {
			is_four_player_continuing_in_war = true;
			number_of_people_continuing_in_war++;
		}

		if (number_of_people_continuing_in_war > 1) {
			if (has_the_game_finished() == true) {
				return;
			}
			System.out.println("War finished with war. Players in the war: " + is_first_player_continuing_in_war + " "
					+ is_second_player_continuing_in_war + " " + is_three_player_continuing_in_war + " "
					+ is_four_player_continuing_in_war);
			recursive_war(is_first_player_continuing_in_war, is_second_player_continuing_in_war,
					is_three_player_continuing_in_war, is_four_player_continuing_in_war, list_of_pledged_cards);
		} else {
			if (is_first_player_continuing_in_war) {
				System.out.println("First player won the war!First player gets cards:");
				for (int counter = 0; counter < list_of_pledged_cards.size(); counter++) {
					System.out.print(" " + list_of_pledged_cards.get(counter));
					decks_of_player_one.add(list_of_pledged_cards.get(counter));
				}
			}
			if (is_second_player_continuing_in_war) {
				System.out.println("Second player won the war!Second player gets cards:");
				for (int counter = 0; counter < list_of_pledged_cards.size(); counter++) {
					System.out.print(" " + list_of_pledged_cards.get(counter));
					decks_of_player_two.add(list_of_pledged_cards.get(counter));
				}
			}
			if (is_three_player_continuing_in_war) {
				System.out.println("Third player won the war!Third player gets cards:");
				for (int counter = 0; counter < list_of_pledged_cards.size(); counter++) {
					System.out.print(" " + list_of_pledged_cards.get(counter));
					decks_of_player_three.add(list_of_pledged_cards.get(counter));
				}
			}
			if (is_four_player_continuing_in_war) {
				System.out.println("Four player won the war!Four player gets cards:");
				for (int counter = 0; counter < list_of_pledged_cards.size(); counter++) {
					System.out.print(" " + list_of_pledged_cards.get(counter));
					decks_of_player_four.add(list_of_pledged_cards.get(counter));
				}
			}
		}
		System.out.println();
	}

}
