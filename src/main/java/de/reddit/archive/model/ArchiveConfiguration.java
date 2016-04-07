package de.reddit.archive.model;

import de.reddit.archive.interfaces.ArchiveConfigurationInterface;

import java.net.URI;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * Container class to transfer a configuration from the gui to the model. Serializable, so the last used configuration
 * can be stored on disk and reloaded the next time.
 *
 * @author radonthetyrant
 */
public class ArchiveConfiguration implements ArchiveConfigurationInterface {

    /**
     * URL to the reddit submission.
     */
    private URI submissionUrl;

    /**
     * if comments should be archived
     */
    private boolean includeComments;

    /**
     * if usernames should be replaced with anon-$randomnumber
     */
    private boolean anonymizeUsernames;

    /**
     * if linked images should be embedded into the archive
     */
    private boolean embedImageFiles;

    /**
     * if linked video files should be embedded into the archive
     */
    private boolean embedVideoFiles;

    /**
     * Sets the visual style/format for the archive
     */
    private ArchiveStyle archiveStyle;

    /**
     * The directory where to put the archive
     */
    private String savePath;

    /**
     * The name of the archive directory if it needs one, filename if it results only in one combined .html file
     */
    private String archiveName;

    /**
     * replacement url for the embedded files. Null if disabled
     */
    private String replaceBaseUrl;

    /**
     * filename for the external stylesheet. Null if disabled
     */
    private String stylesheetPath;

    /**
     * filename for the external javascripts. Null if disabled
     */
    private String javascriptPath;

    public URI getSubmissionUrl() {
        return submissionUrl;
    }

    public void setSubmissionUrl(URI submissionUrl) {
        this.submissionUrl = submissionUrl;
    }

    public boolean isIncludeComments() {
        return includeComments;
    }

    public void setIncludeComments(boolean includeComments) {
        this.includeComments = includeComments;
    }

    public boolean isAnonymizeUsernames() {
        return anonymizeUsernames;
    }

    public void setAnonymizeUsernames(boolean anonymizeUsernames) {
        this.anonymizeUsernames = anonymizeUsernames;
    }

    public boolean isEmbedImageFiles() {
        return embedImageFiles;
    }

    public void setEmbedImageFiles(boolean embedImageFiles) {
        this.embedImageFiles = embedImageFiles;
    }

    public boolean isEmbedVideoFiles() {
        return embedVideoFiles;
    }

    public void setEmbedVideoFiles(boolean embedVideoFiles) {
        this.embedVideoFiles = embedVideoFiles;
    }

    public ArchiveStyle getArchiveStyle() {
        return archiveStyle;
    }

    public void setArchiveStyle(ArchiveStyle archiveStyle) {
        this.archiveStyle = archiveStyle;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getReplaceBaseUrl() {
        return replaceBaseUrl;
    }

    public void setReplaceBaseUrl(String replaceBaseUrl) {
        this.replaceBaseUrl = replaceBaseUrl;
    }

    public String getStylesheetPath() {
        return stylesheetPath;
    }

    public void setStylesheetPath(String stylesheetPath) {
        this.stylesheetPath = stylesheetPath;
    }

    public String getJavascriptPath() {
        return javascriptPath;
    }

    public void setJavascriptPath(String javascriptPath) {
        this.javascriptPath = javascriptPath;
    }
}
