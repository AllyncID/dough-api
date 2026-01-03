# 🥯 Dough (AllyncID Fork)

<hr />
<p align="center">
    <a href="https://github.com/AllyncID/dough-api/actions">
        <img alt="Build Status" src="https://github.com/AllyncID/dough-api/actions/workflows/maven.yml/badge.svg?event=push" />
    </a>
    <a href="https://jitpack.io/#AllyncID/dough-api">
        <img alt="JitPack" src="https://jitpack.io/v/AllyncID/dough-api.svg" />
    </a>
</p>
<hr />

## 📌 About This Fork

This repository is a **community-maintained fork of Dough**, originally developed by the Slimefun team  
and formerly known as **cs-corelib2**.

### ✨ What’s different in this fork?

This fork is **modified and maintained by AllyncID** with the primary goal of:

- ✅ **Full compatibility with Minecraft 1.21+**
- ✅ **Java 21 support**
- ❌ Removal of deprecated / broken Mojang Authlib access
- ❌ Removal of legacy `GameProfile` property injection
- ❌ Removal of NMS-based head skin injection
- ✅ Migration to **official Bukkit / Paper APIs** (`PlayerProfile`, `SkullMeta#setOwnerProfile`)
- ✅ Stable runtime on **Paper / Purpur 1.21.x**

> ⚠️ This fork is **NOT an official Dough release**.  
> It exists to bridge breaking changes introduced in Minecraft 1.20–1.21  
> until upstream libraries fully migrate.

---

## 🧱 Usage & Compatibility

- **Target Minecraft**: `1.21.x`
- **Required Java**: `21`
- **Tested on**:
  - Paper 1.21.x
  - Purpur 1.21.x
- **Primary consumer**:
  - Slimefun (custom / experimental builds)

---

## 📦 Getting Started (JitPack)

This fork is distributed via **JitPack**.

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.AllyncID</groupId>
        <artifactId>dough-api</artifactId>
        <version>v1.1.3-mc1.21</version>
    </dependency>
</dependencies>

repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.AllyncID:dough-api:v1.1.3-mc1.21'
}

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.5.0</version>

    <configuration>
        <relocations>
            <relocation>
                <pattern>io.github.bakedlibs.dough</pattern>
                <shadedPattern>[YOUR.PACKAGE].dough</shadedPattern>
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
