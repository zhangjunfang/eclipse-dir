
package com.rop.request;

/**
 * <pre>
 *    上传文件字符串转换时发生错误
 * </pre>
 */
@SuppressWarnings("all")
public class IllegalUploadFileFormatException extends IllegalArgumentException {

    public IllegalUploadFileFormatException() {
        super();
    }

    public IllegalUploadFileFormatException(String s) {
        super(s);
    }

    public IllegalUploadFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUploadFileFormatException(Throwable cause) {
        super(cause);
    }
}

