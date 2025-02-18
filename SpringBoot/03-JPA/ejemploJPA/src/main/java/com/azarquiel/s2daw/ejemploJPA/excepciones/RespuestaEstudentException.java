package com.azarquiel.s2daw.ejemploJPA.excepciones;

public class RespuestaEstudentException {

    private int status;
    private String msg;
    private long timestamp;

    public RespuestaEstudentException() {
    }

    public RespuestaEstudentException(long timestamp, String msg, int status) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
