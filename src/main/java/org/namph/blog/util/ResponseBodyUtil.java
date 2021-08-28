package org.namph.blog.util;

public class ResponseBodyUtil {
    private ResponseStatusUtil status;
    private String errorMessage;
    private Object data;

    /**
     * get data
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * get status
     * @return
     */
    public ResponseStatusUtil getStatus() {
        return status;
    }

    /**
     * set data
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * set status
     * @param status
     */
    public void setStatus(ResponseStatusUtil status) {
        this.status = status;
    }
}
