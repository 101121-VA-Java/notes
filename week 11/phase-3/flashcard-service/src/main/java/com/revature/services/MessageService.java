package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.revature.events.FlashcardChangeEvent;
import com.revature.repositories.FlashcardRepository;

@Service
public class MessageService {

	@Autowired
	private FlashcardRepository flashDao;
	
	@Autowired
	private KafkaTemplate<String, FlashcardChangeEvent> kt;
	
	private static Set<Integer> eventCache = new HashSet<>();
	
	//method to add
	public void triggerEvent(FlashcardChangeEvent event) {
		// if this service is creating the record, keeps track of it so that it doesn't consume it again
		eventCache.add(event.hashCode());
		
		kt.send("flashcard", event);
	}
	
	//method to process
	@KafkaListener(topics = "flashcard")
	public void processEvent(FlashcardChangeEvent event) {
		// If the record was added by this flashcard service, doesn't rehandle the event
		if(eventCache.contains(event.hashCode())) {
			eventCache.remove(event.hashCode());
			return;
		}
		
		switch(event.getOperation()) {
		case CREATE:
		case UPDATE:
			flashDao.save(event.getFlashcard());
			break;
		case DELETE:
			flashDao.delete(event.getFlashcard());
			break;
		}
	}
}
