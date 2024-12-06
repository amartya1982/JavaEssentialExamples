import java.util.HashMap;

public class URLShortner {
    // HashMaps for storing URL mappings
    private HashMap<String, String> urlToShort;
    private HashMap<String, String> shortToUrl;
    private final String BASE_URL = "http://short.ly/";
    private final int HASH_LENGTH = 6;

    public URLShortner() {
        urlToShort = new HashMap<>();
        shortToUrl = new HashMap<>();
    }

    // Method to shorten a URL
    public String shortenURL(String originalUrl) {
        // Check if the URL is already shortened
        if (urlToShort.containsKey(originalUrl)) {
            return urlToShort.get(originalUrl);
        }

        String shortUrl;
        int attempt = 0;
        do {
            // Generate a hash-based short URL
            shortUrl = BASE_URL + generateHash(originalUrl + attempt);
            attempt++;
        } while (shortToUrl.containsKey(shortUrl)); // Resolve collision by retrying

        // Store mappings
        urlToShort.put(originalUrl, shortUrl);
        shortToUrl.put(shortUrl, originalUrl);

        return shortUrl;
    }

    // Method to retrieve the original URL
    public String expandURL(String shortUrl) {
        return shortToUrl.getOrDefault(shortUrl, "URL not found");
    }

    // Helper method to generate a hash of fixed length
    private String generateHash(String input) {
        return Integer.toHexString(input.hashCode()).substring(0, HASH_LENGTH).toUpperCase();

    }

    public static void main(String[] args) {
        URLShortner urlShortener = new URLShortner();

        // Test URLs
        String originalUrl1 = "https://example.com/long-url";
        String originalUrl2 = "https://anotherexample.com/some-page";

        String OriginalURL3 = "https://youtube.com/shorts/HDFIfOPZ1ds?si=5xhvFkCChcjRJ-My"

        // Shortening URLs
        String shortUrl1 = urlShortener.shortenURL(originalUrl1);
        String shortUrl2 = urlShortener.shortenURL(originalUrl2);
        String shortUrl3 = urlShortener.shortenURL(originalUrl1); // Duplicate URL

        // Print shortened URLs
        System.out.println("Shortened URL 1: " + shortUrl1);
        System.out.println("Shortened URL 2: " + shortUrl2);
        System.out.println("Shortened URL 3 (duplicate): " + shortUrl3);

        // Expanding URLs
        System.out.println("Original URL for " + shortUrl1 + ": " + urlShortener.expandURL(shortUrl1));
        System.out.println("Original URL for " + shortUrl2 + ": " + urlShortener.expandURL(shortUrl2));
        System.out.println("Original URL for unknown: " + urlShortener.expandURL("http://short.ly/unknown"));
    }
}
