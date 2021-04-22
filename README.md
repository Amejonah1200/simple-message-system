# simple-message-system
Usage:
```java
private SimpleMessageSystem simpleMessageSystem;


// -- onEnable --
simpleMessageSystem = new SimpleMessageSystem(this); // loading defaults from template messages.yml

YamlConfiguration messages = YamlConfiguration.loadConfiguration(new File("plugins/MyPlugin/messages.yml"));
simpleMessageSystem.loadCustomMessages(messages); // loads custom messages

// this how to save defaults for unset paths
if (simpleMessageSystem.saveDefaultMessages(messages, false)) { // returns true if defaults where set, the "false" is for not overriding
  try {
    messages.save("plugins/MyPlugin/messages.yml");
  } catch (IOException e) {
    e.printStackTrace();
  }
}

// -- onEnable --


// -- elsewhere --

String message = simpleMessageSystem.translate("my.cool_cat"); // retrieving message
// Messages can have placeholders, see template messages.yml below
String placeholded_message = simpleMessageSystem.translate("my.other.cool_cat", 5, 10);

// -- elsewhere --
```
Messages Template:
```yml
my:
  cool_cat: "Test"
  other:
    cool_cat:
      message: "Cat n°%number% of %amount%." # Messages paths cannot ends with "message" like "my.cool_message"
      placeholders: ["number", "amount"] # order is relevant for providing args to translate-method!

```

Gradle (ftw!!):
```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
  implementation "io.github.amejonah:simple-message-system:1.0-stable"
}
```
