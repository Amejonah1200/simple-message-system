package ap.amejonah.simplemessagesystem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

import static ap.amejonah.simplemessagesystem.SimpleMessageSystem.translateAlternateColorCodes;

public class SimpleMessage {
  
  protected final String path;
  protected final String defaultMessage;
  protected String customMessage;
  
  /**
   * Instantiates a new SimpleMessage.
   *
   * @param path The message path in the configuration.
   * @param defaultMessage The default message specified in the default configuration.
   * @param customMessage The custom message.
   */
  public SimpleMessage(@Nonnull String path, @Nonnull String defaultMessage, @Nullable String customMessage) {
    this.path = Objects.requireNonNull(path, "Path cannot be null!");
    this.defaultMessage = translateAlternateColorCodes(
        Objects.requireNonNull(defaultMessage, "DefaultMessage cannot be null!"));
    this.customMessage = customMessage != null ? translateAlternateColorCodes(customMessage) : null;
  }
  
  /**
   * Instantiates a new SimpleMessage.
   *
   * @param path the path in the configuration
   * @param defaultMessage the default message specified in the default configuration.
   */
  public SimpleMessage(@Nonnull String path, @Nonnull String defaultMessage) {
    this(path, defaultMessage, null);
  }
  
  /**
   * Gets path to this message.
   *
   * @return the path
   */
  @Nonnull
  public String getPath() {
    return path;
  }
  
  /**
   * Gets default message.
   *
   * @return the default message
   */
  @Nonnull
  public String getDefaultMessage() {
    return defaultMessage;
  }
  
  /**
   * Gets custom message.
   *
   * @return the custom message
   */
  @Nullable
  public String getCustomMessage() {
    return customMessage;
  }
  
  /**
   * Sets custom message and translates color codes with "&" to "§".
   *
   * @param customMessage the custom message to set
   */
  public void setCustomMessage(@Nullable String customMessage) {
    this.customMessage = customMessage != null ? translateAlternateColorCodes(customMessage) : null;
  }
  
  /**
   * Gets raw message, if the custom message is null, it will return the default message.
   *
   * @return the raw message
   */
  @Nonnull
  public String getRawMessage() {
    return customMessage != null ? customMessage : defaultMessage;
  }
  
  @Override
  public String toString() {
    return "SimpleMessage{" + "path='" + path + '\'' + ", defaultMessage='" + defaultMessage + '\'' +
        ", customMessage='" + customMessage + '\'' + '}';
  }
}
