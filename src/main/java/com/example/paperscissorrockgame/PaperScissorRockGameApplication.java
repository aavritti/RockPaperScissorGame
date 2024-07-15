package com.example.paperscissorrockgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.example.paperscissorrockgame.Constant.NUMBER_OF_MOVES;
import static com.example.paperscissorrockgame.Move.*;

public class PaperScissorRockGameApplication {

	public static void main(String[] args) {

		GameRule gameRule = new GameRule();
		GameAction paper = gameRule.paperRule();
		GameAction rock = gameRule.rockRule();
		GameAction scissor = gameRule.scissorRule();
		Random random = new Random();
		Score score = new Score();

		Scanner sc= new Scanner(System.in);

		// Start the game
		System.out.println("Welcome to Rock-Paper-Scissors! Please enter \"rock\", \"paper\", \"scissors\"");
		System.out.print("Enter how many rounds you want to play: ");

		int numOfRounds = sc.nextInt();
		sc.nextLine();

		while (numOfRounds>0){

			System.out.println("-------------------------\nEnter your move: ");
			String player1 = sc.nextLine();

			// Check for valid input
			Move playerMove = Arrays.stream(Move.values())
					.filter(v -> player1.equalsIgnoreCase(v.name()))
					.findFirst().orElse(null);

			if(playerMove == null){
				System.out.println("Invalid move");
				numOfRounds--;
				continue;
			}

			int randomNumber = random.nextInt(NUMBER_OF_MOVES);
			String computerMove = Move.values()[randomNumber].toString();

			System.out.println("Computer move: " + computerMove);

			// Compare player and computer's move
			if(computerMove.equals(ROCK.toString())){

				switch (playerMove){
					case PAPER:
						System.out.println(paper.playAgainst(rock, score));
						break;
					case SCISSORS:
						System.out.println(scissor.playAgainst(rock, score));
						break;
					case ROCK:
						System.out.println(rock.playAgainst(rock, score));
						break;
				}

			}else if(computerMove.equals(PAPER.toString())){

				switch (playerMove){
					case PAPER:
						System.out.println(paper.playAgainst(paper, score));
						break;
					case SCISSORS:
						System.out.println(scissor.playAgainst(paper, score));
						break;
					case ROCK:
						System.out.println(rock.playAgainst(paper, score));
						break;
				}

			}else if(computerMove.equals(SCISSORS.toString())){

				switch (playerMove){
					case PAPER:
						System.out.println(paper.playAgainst(scissor, score));
						break;
					case SCISSORS:
						System.out.println(scissor.playAgainst(scissor, score));
						break;
					case ROCK:
						System.out.println(rock.playAgainst(scissor, score));
						break;
				}

			}
			numOfRounds--;
		}

		//Display final Score of the player
		System.out.println("\nNumber of games won: " + Integer.toString(score.gameWon) +
				" Number of games lost: " + Integer.toString( score.gameLost));
	}
}
