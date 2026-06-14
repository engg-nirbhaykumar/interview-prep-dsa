public class Codec {

    private static final String BASE_URL = "http://tinyurl.com/";
    private Integer id;
    private Map<String, String> urlMap;

    public Codec() {
        this.id = 0;
        this.urlMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = BASE_URL + id;
        id++;
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));