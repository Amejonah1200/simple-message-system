# simple-message-system
![Latest Version](https://img.shields.io/nexus/r/io.github.amejonah1200/simple-message-system?label=Release&nexusVersion=3&server=https%3A%2F%2Feldonexus.de&style=for-the-badge "Latest Version")

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
      message: "Cat n°%number% of %amount%."
      placeholders: ["number", "amount"] # order is relevant for providing args to translate-method!

```

Gradle Kotlin DSL:
```kotlin
repositories {
  maven("https://eldonexus.de/repository/maven-releases")
}

dependencies {
  implementation("io.github.amejonah1200", "simple-message-system", "1.0-stable")
}
```
Gradle Groovy DSL:
```groovy
repositories {
  maven { url "https://eldonexus.de/repository/maven-releases" }
}

dependencies {
  implementation "io.github.amejonah1200:simple-message-system:1.0-stable"
}
```

Maven? Switch to Gradle. .-.

