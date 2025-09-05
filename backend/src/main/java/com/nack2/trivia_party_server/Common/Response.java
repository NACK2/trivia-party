package com.nack2.trivia_party_server.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Response<DataType> {
    public final Date timestamp;
    public final int code;
    public String error;
    public DataType data;

    public Response(Date timestamp, int code, String error) {
        this.timestamp = timestamp;
        this.code = code;
        this.error = error;
    }

    public Response(Date timestamp, int code, DataType data) {
        this.timestamp = timestamp;
        this.code = code;
        this.data = data;
    }
}
