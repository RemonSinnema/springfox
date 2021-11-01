# Springfox

### About
This is the fork of the springfox project. For more information on the original project visit the [Springfox Website](http://springfox.io) or
 [http://springfox.github.io/springfox/](http://springfox.github.io/springfox/)

### Useful links
- [Reference Documentation](http://springfox.io)
- [Examples repository](https://github.com/springfox/springfox-demos)
- [Contribution Guidelines](https://github.com/springfox/springfox/wiki/Contribution-guidelines)
- [Core contributors](http://springfox.github.io/springfox/contributors.html)
- [Development and contribution guidelines](https://github.com/martypitt/swagger-springmvc/wiki/Development)
- [Change log](docs/release-notes.md)
- [Development Environment](http://springfox.github.io/springfox/docs/current/#development-environment)
- [Release Instructions](http://springfox.github.io/springfox/docs/current/#releasing)

### Getting Started

#### For new projects
For Maven
```xml 
<dependency>
    <groupId>org.thingsboard</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.1</version>
</dependency>

```

For Gradle
```gradle 
  implementation "org.thingsboard:springfox-boot-starter:<version>"
```
#### Migrating from earlier snapshot 
#### Spring Boot Applications
NOTE: Would love feedback to make this better
1. Remove explicit dependencies on `springfox-swagger2`
2. Remove any `@EnableSwagger2...` annotations
3. Add the `springfox-boot-starter` dependency
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces.

#### Migrating from existing 2.x version
#### Spring Boot Applications
NOTE: Would love feedback to make this better
1. Remove explicit dependencies on `springfox-swagger2`
2. Remove the `@EnableSwagger2` annotations
3. Add the `springfox-boot-starter` dependency
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces 
5. If you are using WebMvc but you don't use the [`@EnableWebMvc`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/EnableWebMvc.html) annotation yet, add this annotation.

#### Regular spring mvc  
NOTE: Would love feedback to make this experience better
1. Remove explicit dependencies on `springfox-swagger2`
2. Add `@EnableOpenApi` for open API (and `@EnableSwagger2WebMvc` or `@EnableSwagger2WebFlux` for older versions)  
3. Added the `springfox-oas` library 
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces 


License
-------

Copyright 2015 Marty Pitt - [@martypitt](https://github.com/martypitt), Dilip Krishnan - [@dilipkrish](https://github.com/dilipkrish),
Adrian Kelly -  [@adrianbk](https://github.com/adrianbk),

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at [apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox?ref=badge_large)
