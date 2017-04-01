package demo.graph;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.util.Arrays;

/**
 * @author YQ.Huang
 */
@Embeddable
public class Attachment {

    private String name;

    @Lob
    private byte[] content;

    public Attachment() {
    }

    public Attachment(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Attachment setName(String name) {
        this.name = name;
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public Attachment setContent(byte[] content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return Arrays.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
