package edu.school.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Type 1 to start the game!");
	Scanner scanner = new Scanner(System.in);
	boolean has_the_game_started=false,has_the_game_finished=false;
	int console;
	while(has_the_game_started==false) {
	console=scanner.nextInt();
	if(console==1) {
	has_the_game_started=true;	
	}
	}
	
    Game a = new Game();
    a.mixing_an_array();
    a.sending_cards_to_players();
    
    while(has_the_game_finished==false) {
    if(a.has_the_game_finished()) {
    	has_the_game_finished=true;	
    }
    a.play();
    }
    
	}

}

