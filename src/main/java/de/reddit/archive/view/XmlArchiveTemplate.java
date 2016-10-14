package de.reddit.archive.view;

import de.reddit.archive.interfaces.ArchiveTemplateInterface;
import net.dean.jraw.models.Submission;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * @author radonthetyrant
 */
public class XmlArchiveTemplate implements ArchiveTemplateInterface {

    Submission submission;

    public XmlArchiveTemplate(Submission submission) {
        this.submission = submission;
    }

    public String getContent() {


        return null;
    }
}
