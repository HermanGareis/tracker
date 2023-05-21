package com.tracker.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.tracker.dto.ResponseBodyDTO;

/**
 * A utility class for generating HTTP responses with a generic type.
 * 
 * @param <T> the type of the response body.
 */
public class ResponseGenerator<T> {
	public ResponseGenerator() {
	}

	/**
	 * Generates a response with the provided response body, HTTP status, and call
	 * dates.
	 *
	 * @param response      The response body.
	 * @param status        The HTTP status of the response.
	 * @param startCallDate The start date of the API call.
	 * @param <T>           The type of the response body.
	 * @return The generated ResponseBodyDTO object.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResponseBodyDTO<T> generateResponse(T response, HttpStatus status, Date startCallDate) {
		return new ResponseBodyDTO(response, startCallDate, new Date(), status);
	}
}
