package crud.backend;

/**
 * Created by 241180 on 13/03/2017.
 */
public class Greeting {

    private final long id;
    private final String value;

    public Greeting(long id, String content) {
        this.id = id;
        this.value = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return value;
    }

}