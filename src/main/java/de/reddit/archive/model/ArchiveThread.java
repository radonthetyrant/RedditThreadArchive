package de.reddit.archive.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.javaws.exceptions.InvalidArgumentException;
import de.reddit.archive.exception.RedditSubmissionUnavailableException;
import de.reddit.archive.interfaces.ArchiveConfigurationInterface;
import de.reddit.archive.interfaces.ArchiveTemplateInterface;
import de.reddit.archive.view.XmlArchiveTemplate;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.SubmissionRequest;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Submission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;

/**
 * Created by radonthetyrant on 07.04.2016.
 *
 * @author radonthetyrant
 */
public class ArchiveThread {

    private ArchiveConfigurationInterface archiveConfiguration;

    private ArchiveTemplateInterface archiveTemplate;

    private Submission submission;

    public ArchiveThread(ArchiveConfigurationInterface archiveConfiguration)
    {
        this.archiveConfiguration = archiveConfiguration;
    }

    public ArchiveConfigurationInterface getArchiveConfiguration()
    {
        return this.archiveConfiguration;
    }

    protected String getThreadJson() throws MalformedURLException, RedditSubmissionUnavailableException {
        URL url = getArchiveConfiguration().getSubmissionUrl().toURL();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Length", "0");
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);
            connection.setConnectTimeout(10); // @TODO: add to config
            connection.setReadTimeout(10); // @TODO: add to config
            connection.connect();
            int status = connection.getResponseCode();

            if (status != 200) {
                connection.disconnect();
                throw new RedditSubmissionUnavailableException("Request returned unexpected HTTP Status: "+status);
            }

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            connection.disconnect();

            return sb.toString();
        } catch (IOException e) {
            throw new RedditSubmissionUnavailableException(e);
        }
    }

    protected Submission getSubmission(String id)
    {
        UserAgent agent = UserAgent.of("Java", "RedditThreadArchive", "0.1", "redditusername"); // @TODO: from config: username, version constant
        RedditClient client = new RedditClient(agent);
        Credentials credentials = Credentials.script("radonthetyrant", "Zweizwei22", "z0nMvvid75V6Dg", "L9vcn8JdVQUVIUrm8MhoXckRybU");
        OAuthData auth = null;
        try {
            auth = client.getOAuthHelper().easyAuth(credentials);
        } catch (OAuthException e) {
            e.printStackTrace();
        }

        client.authenticate(auth);
        SubmissionRequest.Builder builder = new SubmissionRequest.Builder(id);
        //SubmissionRequest submissionRequest = new SubmissionRequest(builder);

        return client.getSubmission(builder.depth(Integer.MAX_VALUE).build());
    }

    protected ArchiveTemplateInterface createArchiveTemplate(ArchiveStyle archiveStyle, Submission submissionData)
    {
        switch (archiveStyle) {
            case XML:
                return new XmlArchiveTemplate(submissionData);
            default:
                throw new InvalidParameterException("ArchiveStyle is not covered by the Archive Templates!");
        }
    }

    public String getContents()
    {
        if (submission == null) {
            submission = getSubmission("4dmnn6");
        }

        if (archiveTemplate == null) {
            archiveTemplate = createArchiveTemplate(archiveConfiguration.getArchiveStyle(), submission);
        }

        return archiveTemplate.toString();
    }


}
