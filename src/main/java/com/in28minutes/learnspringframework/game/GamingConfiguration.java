package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
	
		@Bean
		public GamingConsole game() {
			var game = new PackManGame();
			return game;
		}
		
		@Bean
		public GameRunner gameRunner(GamingConsole game) {
			var gameRunner = new GameRunner(game);
			return gameRunner;
		}
		
//		//var game = new MarioGame();
//		//var game = new SuperContraGame();
//		var game = new PackManGame();
//		
//		var gameRunner = new GameRunner(game);
//		gameRunner.run();
}
