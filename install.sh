
echo "Installing dsi-utils"
./fr.inria.diverse.fingerprint/mvnw install:install-file \
   -Dfile=./thirdPartyLibrary/dsiutils/dsiutils-2.7.3-threadSafe.jar \
   -DpomFile=./thirdPartyLibrary/dsiutils/pom.xml
   
echo "Installing swh-graph"
./fr.inria.diverse.fingerprint/mvnw install:install-file \
   -Dfile=./thirdPartyLibrary/swh-graph/swh-graph-2.2.0-threadSafe.jar \
   -DpomFile=./thirdPartyLibrary/swh-graph/pom.xml
   