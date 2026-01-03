# :bagel: Dough

<hr />
<p align="center">
    <a href="https://github.com/baked-libs/dough/actions">
        <img alt="Build Status" src="https://github.com/baked-libs/dough/actions/workflows/maven.yml/badge.svg?event=push" />
    </a>
    <a href="https://javadoc.io/doc/io.github.baked-libs/dough-api">
	<img alt="javadocs" src="https://javadoc.io/badge2/io.github.baked-libs/dough-api/javadoc.svg" />
    </a>
    <a href="https://search.maven.org/search?q=baked-libs">
        <img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.baked-libs/dough?color=1074ad&logo=apache-maven" />
    </a>
    <a href="https://sonarcloud.io/project/overview?id=baked-libs_dough">
        <img alt="Code Coverage" src="https://sonarcloud.io/api/project_badges/measure?project=baked-libs_dough&metric=coverage" />
    </a>
    <a href="https://sonarcloud.io/project/overview?id=baked-libs_dough">
        <img alt="Maintainability" src="https://sonarcloud.io/api/project_badges/measure?project=baked-libs_dough&metric=sqale_rating" />
    </a>
</p>
<hr />

Formerly known as "cs-corelib2", dough is a very powerful library aiming to help the everyday Spigot/Plugin developer.
It is packed to the brim with useful features and APIs to use and play around with.

Dough may be more commonly known as the backbone of [Slimefun](https://github.com/Slimefun/Slimefun4).

## :mag: Getting Started
Dough is hosted on maven-central (OSS Sonatype) for easy access.
Furthermore, it consists of multiple different submodules.

If you want to utilise the entirety of dough, use the artifact `dough-api`.<br>
Otherwise replace `dough-api` in the following examples with whatever module you want to import. Note that
some modules have dependencies on other modules, all modules require `dough-common` as an example.

### Adding dough via gradle
Dough can easily be included in gradle using mavenCentral.<br />
Simply replace `[DOUGH VERSION]` with the most up to date version of dough:
![Maven Central](https://img.shields.io/maven-central/v/io.github.baked-libs/dough?label=latest%20version)

```gradle
repositories {
	mavenCentral()
}

dependencies {
	implementation 'io.github.baked-libs:dough-api:[DOUGH VERSION]'
}
```

To shadow dough and relocate it:
```gradle
plugins {
  id "com.github.johnrengelman.shadow" version "7.0.0"
}

shadowJar {
   relocate "io.github.bakedlibs.dough", "[YOUR PACKAGE].dough"
}
```

### Adding dough via Maven
Dough can easily be included be added using maven-central.<br />
Simply replace `[DOUGH VERSION]` with the most up to date version of dough:
![Maven Central](https://img.shields.io/maven-central/v/io.github.baked-libs/dough?label=latest%20version)

```xml
<dependencies>
  <dependency>
    <groupId>io.github.baked-libs</groupId>
    <artifactId>dough-api</artifactId>
    <version>[DOUGH VERSION]</version>
    <scope>compile</scope>
  </dependency>
</dependencies>
```

To shadow dough and relocate it:
```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>3.2.4</version>

      <configuration>
        <relocations>
          <relocation>
            <pattern>io.github.bakedlibs.dough</pattern>
            <shadedPattern>[YOUR PACKAGE].dough</shadedPattern>
          </relocation>
        </relocations>
      </configuration>

      <executions>
        <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```
