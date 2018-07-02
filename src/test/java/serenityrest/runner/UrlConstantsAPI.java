package serenityrest.runner;

public enum UrlConstantsAPI {
	
	SAMPLE("/ip");
	
	private String url;

    UrlConstantsAPI(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
