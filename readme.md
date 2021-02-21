### IWT Core Library
    I build this library because i use in almost of my projects this functions.
    I don't know if this will be util to you, but for me help a lot :).

### Included
    - factory
        * IwtMapper -> return a ObjectMapper ignoring missing fields and support to LocalDateTime
    - sql
        * ResultsetMapper -> serialize a Resultset in a list of your object or a simple Map<String, Object>
    - util
        * Ldtu -> return the current date/time with a default format and have a most used values converted
        * Security -> encrypt and decrypt with AES tecnology
        * UniqueUUID -> generate a unique uuid based on your application, local datetime and a random number

### Usage
    Clone this repository
    execute this command:
    mvn clean install
    Import in your pom.xml
    <dependencies>
        <dependency>
            <groupId>com.tiagoiwamoto</groupId>
            <artifactId>iwt-libcore</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    With spring we recomend to you create a Bean of this lib

    @Configuration
    class IwtBean{

        @Bean
        public Iwtlibcore buildIwtLibcore(){
            return new Iwtlibcore();
        }
    }

    and then you can use with @Autowired

    @Autowired
    private Iwtlibcore iwtlibcore;

    ...

    this.iwtlibcore.resultsetMapper();
