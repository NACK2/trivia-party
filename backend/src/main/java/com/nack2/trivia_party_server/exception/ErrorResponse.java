package com.nack2.trivia_party_server.exception;

import java.util.Date;

public record ErrorResponse(Date timestamp, String message, int code) {}
