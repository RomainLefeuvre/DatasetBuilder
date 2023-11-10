# Bundle downloader
## Launching
```sh
java -jar ./bundle-0.1.0.jar --input=example_origin_url_snap_swhid.json --output=outputfolder --token=eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhMTMxYTQ1My1hM2IyLTQwMTUtODQ2Ny05MzAyZjk3MTFkOGEifQ.eyJpYXQiOjE2OTY5MjkxOTgsImp0aSI6IjE3NzY2ZmZkLWNhOGEtNGRjYy1hMGFiLTVmMDVjMGU3MDQwYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5zb2Z0d2FyZWhlcml0YWdlLm9yZy9hdXRoL3JlYWxtcy9Tb2Z0d2FyZUhlcml0YWdlIiwiYXVkIjoiaHR0cHM6Ly9hdXRoLnNvZnR3YXJlaGVyaXRhZ2Uub3JnL2F1dGgvcmVhbG1zL1NvZnR3YXJlSGVyaXRhZ2UiLCJzdWIiOiIwZmUxYWU4MS1mMWE0LTQzM2MtOTYxZS1kN2M5ZjczYWY4NTkiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoic3doLXdlYiIsInNlc3Npb25fc3RhdGUiOiJlOWEzMDk2Mi1mMWVlLTQyZmEtOGZmYi03MThmMDg1YTY4YjMiLCJzY29wZSI6Im9wZW5pZCBvZmZsaW5lX2FjY2VzcyBwcm9maWxlIGVtYWlsIn0.X_4M4ZwplWTc_aSUV80zt7JyXc4CvImI_dpP5zoEs9Y
```
More informations with 
```sh
java -jar target/bundle-0.1.0.jar --help
```

## Compiling

```sh
    ./mvnw clean package
```
The resulting fat jar is now located in the ```target``` folder 

default options can be changed before compiling [here](src/main/resources/defaultConfig.properties)



