import java.io.IOException;    
import java.io.InputStream;    
import java.io.OutputStream;    
import java.net.URI;    
import java.net.URISyntaxException;    
import java.util.Properties;

public class MongoDBConfig {

    private static final String  MongoDB_URL = "mongodb://root:899000@49.234.106.142:27017/";    
    private static final int PORT = 27017;    
    private static final String DB_NAME = "icbc_mongo";

    public static MongoDBConfig getMongoDBConfig() throws IOException {    
        Properties props = new Properties();    
        props.put("url", MongoDB_URL);    
        props.put("port", PORT);    
        props.put("dbName", DB_NAME);    
        return new MongoDBConfig(props);    
    }

    private MongoDBConfig(Properties props) throws IOException {    
        this.props = props;    
    }

    public static void main(String[] args) throws IOException {    
        MongoDBConfig config = MongoDBConfig.getMongoDBConfig();    
        System.out.println(config);    
    }

    private Properties props;

    private void readProps(InputStream in) throws IOException {    
        props = new Properties();    
        props.load(in);    
    }

    private void writeProps(OutputStream out) throws IOException {    
        props.store(out, null);    
    }

    public String getUsername() {    
        return props.getProperty("username");    
    }

    public String getPassword() {    
        return props.getProperty("password");    
    }

    public URI getURI() {    
        return new URI(props.getProperty("url"));    
    }    
}
