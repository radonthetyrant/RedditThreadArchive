package de.reddit.archive.exception;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * @author radonthetyrant
 */
public class RedditSubmissionUnavailableException extends Exception {

    public RedditSubmissionUnavailableException(String message) {
        super(message);
    }

    public RedditSubmissionUnavailableException(Throwable cause) {
        super(cause);
    }
}
