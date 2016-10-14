package de.reddit.archive.main;

import de.reddit.archive.interfaces.ArchiveConfigurationInterface;
import de.reddit.archive.model.ArchiveConfiguration;
import de.reddit.archive.model.ArchiveStyle;
import de.reddit.archive.model.ArchiveThread;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * @author radonthetyrant
 */
public class Program {

    public static void main(String[] args)
    {

        ArchiveConfigurationInterface config = new ArchiveConfiguration();
        config.setArchiveStyle(ArchiveStyle.XML);

        ArchiveThread thread = new ArchiveThread(config);
        String xml = thread.getContents();
        System.out.println(xml);

    }

}
