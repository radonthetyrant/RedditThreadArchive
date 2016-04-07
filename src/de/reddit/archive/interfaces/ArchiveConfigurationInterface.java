package de.reddit.archive.interfaces;

import de.reddit.archive.model.ArchiveStyle;

import java.net.URI;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * @author radonthetyrant
 * @see de.reddit.archive.model.ArchiveConfiguration for javadoc on properties
 */
public interface ArchiveConfigurationInterface {

    URI getSubmissionUrl();

    void setSubmissionUrl(URI submissionUrl);

    boolean isIncludeComments();

    void setIncludeComments(boolean includeComments);

    boolean isAnonymizeUsernames();

    void setAnonymizeUsernames(boolean anonymizeUsernames);

    boolean isEmbedImageFiles();

    void setEmbedImageFiles(boolean embedImageFiles);

    boolean isEmbedVideoFiles();

    void setEmbedVideoFiles(boolean embedVideoFiles);

    ArchiveStyle getArchiveStyle();

    void setArchiveStyle(ArchiveStyle archiveStyle);

    String getSavePath();

    void setSavePath(String savePath);

    String getArchiveName();

    void setArchiveName(String archiveName);

    String getReplaceBaseUrl();

    void setReplaceBaseUrl(String replaceBaseUrl);

    String getStylesheetPath();

    void setStylesheetPath(String stylesheetPath);

    String getJavascriptPath();

    void setJavascriptPath(String javascriptPath);
}
