package com.revature.events;

import java.time.LocalDateTime;

import com.revature.models.Difficulty;
import com.revature.models.Flashcard;
import com.revature.models.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class FlashcardChangeEvent {

	private Flashcard flashcard;
	private Operation operation;
	private LocalDateTime timestamp;
}
