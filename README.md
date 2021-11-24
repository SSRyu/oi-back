# oi-back

## ktlint
A kotlin formatter.

### run
```
./graldew ktlintFormat
```

### reference
- https://github.com/jlleitschuh/ktlint-gradle

## detekt
A static code analysis tool for the Kotlin programming language.

### generate default config
```
./gradlew detektGenerateConfig
```

### run
```
./gradlew detekt
```

### reports
```
build/reports/detekt
```

### reference
- https://github.com/detekt/detekt
- https://qiita.com/uhooi/items/cd1250c6f6de7d4abfd6

## flyway
A database version control plugin.

### migrate
```
./gradlew flywayMigrate
```

### reference
- https://flywaydb.org/documentation/getstarted/firststeps/gradle