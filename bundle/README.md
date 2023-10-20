# Bundle downloader

## Compiling

```sh
    ./mvnw clean package
```
## Launching
```sh
java -jar target/bundle-0.1.0.jar --input=example_origin_url_snap_swhid.json --output=outputfolder
```

default options can be changed before compiling [here](src/main/resources/defaultConfig.properties)

More informations with 
```sh
java -jar target/bundle-0.1.0.jar --help
```

