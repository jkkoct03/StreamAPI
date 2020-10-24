package com.streamapi.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/operation")
public class StreamApiController {

	@PostMapping
	public String returnLongestString(@RequestBody List<String> listOfString) {

		Optional<String> str = listOfString.stream().max(Comparator.comparing(String::length));

		String longestString = "";

		if (str.isPresent())
			longestString = str.get();

		return longestString;

	}

	@DeleteMapping
	public Stream<String> returnRemaining(@RequestBody List<String> listOfString) {

		Stream<String> str = listOfString.stream().filter((n) -> n.length() < 10);

		return str;
	}

}
