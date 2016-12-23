package demo;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author YQ.Huang
 */
@Document
@CompoundIndex(def = "{'k1':1,'k2':1}", unique = true)
public class Something {
    private String id;
    private final String k1;
    private final String k2;
    private String content;

    public Something(String k1, String k2) {
        id = null;
        this.k1 = k1;
        this.k2 = k2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getK1() {
        return k1;
    }

    public String getK2() {
        return k2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
