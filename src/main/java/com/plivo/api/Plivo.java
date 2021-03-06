package com.plivo.api;

public class Plivo {

  private static PlivoClient instance = null;

  /**
   * Initializes the global {@link PlivoClient} instance
   */
  public static synchronized PlivoClient init(String authId, String authToken) {
    return init(authId, authToken, PlivoClient.BASE_URL);
  }

  /**
   * Initializes the global {@link PlivoClient} instance
   */
  public static synchronized PlivoClient init(String authId, String authToken, String baseUrl) {
    instance = new PlivoClient(authId, authToken, baseUrl);
    return instance;
  }


  /**
   * Initializes the global {@link PlivoClient} instance, taking the authId and authToken from
   * environment variables called PLIVO_AUTH_ID and PLIVO_AUTH_TOKEN.
   */
  public static synchronized PlivoClient init() {
    return init(System.getenv("PLIVO_AUTH_ID"), System.getenv("PLIVO_AUTH_TOKEN"));
  }

  public static PlivoClient getClient() {
    return instance;
  }
}
