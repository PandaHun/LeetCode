public class Codec {

    Map<String,String> index = new HashMap<>();
    Map<String,String> reverseIndex = new HashMap<>();
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private String createKey() {
        char[] code = new char[6];
        for (int i = 0 ; i < 6; i++) {
            int random = (int) (Math.random() * 62);
            code[i] = charSet.charAt(random);
        }
        return BASE_URL + String.valueOf(code);
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (reverseIndex.containsKey(longUrl)) {
            return reverseIndex.get(longUrl);
        }
        String key = createKey();
        while (index.containsKey(key)) {
            key = createKey();
        }
        index.put(key, longUrl);
        reverseIndex.put(longUrl, key);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));