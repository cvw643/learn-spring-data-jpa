package demo.graph;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author YQ.Huang
 */
@NamedEntityGraph(name = "mail.full", includeAllAttributes = true)
@Entity
public class Mail {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String subject;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String body;

    @ElementCollection
    private Collection<Attachment> attachments = new ArrayList<>();

    Mail() {
    }

    public Mail(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Mail setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Mail setBody(String body) {
        this.body = body;
        return this;
    }

    public Mail setId(int id) {
        this.id = id;
        return this;
    }

    public Collection<Attachment> getAttachments() {
        return attachments;
    }

    public Mail addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
        return this;
    }
}
