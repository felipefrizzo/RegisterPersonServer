package br.univel.server.request;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public interface GenericReadRequest {

    /**
     * Read request and redirect to methods POST, PUT, DELETE.
     * @return
     */
    Object read();
}
