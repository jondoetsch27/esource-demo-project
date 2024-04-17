# esource-demo-project
```
# Run mvn clean:install to build .jar #

docker build -t esource/demo .
docker run -p 8080:8080 esource/demo
curl -o output.json http://localhost:8080/run

## for Linux Terminal ##
cat output.json

## for Windows PowerShell ##
Get-Content .\output.json
```